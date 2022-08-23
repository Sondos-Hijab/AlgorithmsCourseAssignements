//Sondos Hijab 11923751
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static int UnBoundedKnapFun(int n,int w,int c[],int p[],int cw){
        w=w-cw;
        
        int[][] T = new int[n+1][w+1];
        int [][] tCost = new int[n+1][w+1];
        
        for (int i=0;i<=w;i++){
            T[0][i] = 0;
            tCost[0][i] = 0;
        }
        
        for (int i=0;i<=n;i++){
            T[i][0] = 0;
            tCost[i][0] = 0;
        }
        
        for (int i=1;i<=n;i++){
            T[i][0] = 0;
            tCost[i][0] = 0;
            for (int j=1;j<=w;j++){
                if(c[i-1]<=j){
                    if(p[i - 1]+ T[i][j - c[i - 1]]>T[i - 1][j]){
                        T[i][j] = p[i - 1]+ T[i][j - c[i - 1]];
                        tCost[i][j] = c[i - 1]+ tCost[i][j - c[i - 1]];
                }
                    else
                        {T[i][j] = T[i-1][j];
                        tCost[i][j] = tCost[i-1][j];

                        }
                }
                else
                {
                    T[i][j] = T[i-1][j];
                    tCost[i][j] = tCost[i-1][j];

                }
            }
           
            
        }
        
        return tCost[n][w]+cw;
    }
 
    static int maxPow(int n,int w,int c[],int p[],int cw){
        w=w-cw;
        
        int[][] T = new int[n+1][w+1];
        
        for (int i=0;i<=w;i++){
            T[0][i] = 0;
        }
        
        for (int i=0;i<=n;i++){
            T[i][0] = 0;
        }
        
        for (int i=1;i<=n;i++){
            T[i][0] = 0;
            for (int j=1;j<=w;j++){
                if(c[i-1]<=j){
                    if(p[i - 1]+ T[i][j - c[i - 1]]>T[i - 1][j]){
                        T[i][j] = p[i - 1]+ T[i][j - c[i - 1]];
                }
                    else
                        {T[i][j] = T[i-1][j];
                        }
                }
                else
                {
                    T[i][j] = T[i-1][j];

                }
            }
           
            
        }
        
        return T[n][w];
    }
    
    
static int multipleContainers (int contNum, int totalCost,int n, int c[][],int p [][],int cw []){
        
 int maxCont[] = new int [cw.length];
            int g=0;
            int maxmax = maxPow(n,totalCost,c[0],p[0],cw[0]);
            for(int i=1;i<cw.length;i++){
                if( maxPow(n,totalCost,c[i],p[i],cw[i]) > maxmax ){
                    maxmax= maxPow(n,totalCost,c[i],p[i],cw[i]);
                    maxCont[0] = i;
                }
                
            }

            totalCost -= UnBoundedKnapFun(n,totalCost,c[maxCont[0]],p[maxCont[0]],cw[maxCont[0]]);


            for(int r=1;r<cw.length;r++){
                for(int i=0;i<cw.length ; i++){
                    for(int k=0;k<maxCont.length;k++){
                        if(i == maxCont[k])  maxmax+=0;
                        
                        else{
                            if(totalCost!=0 && maxPow(n,totalCost,c[i],p[i],cw[i])+ maxmax > maxmax){
                                maxmax += maxPow(n,totalCost,c[i],p[i],cw[i]);
                                maxCont[1+g] = i;
                                g++;
                                totalCost -= UnBoundedKnapFun(n,totalCost,c[maxCont[i]],p[maxCont[i]],cw[maxCont[i]]);
                            }

                        }
                    }
                }
            }
            

            
            
            
            
            return maxmax;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfC = sc.nextInt();
        int costCont[]=new int[numOfC];
        int n = sc.nextInt();
        int w = sc.nextInt();
        
        for(int i=0;i<numOfC;i++){
        costCont[i] = sc.nextInt();
        }

        int c [][] = new int [numOfC][n];
        int[] p [] = new int [numOfC][n];
        for(int i=0;i<numOfC;i++){
            for(int j=0;j<n;j++){
                c[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<numOfC;i++){
            for(int j=0;j<n;j++){
                p[i][j] = sc.nextInt();
            }
        }
   
    System.out.println(multipleContainers (numOfC,w,n, c,p, costCont));    }
}
