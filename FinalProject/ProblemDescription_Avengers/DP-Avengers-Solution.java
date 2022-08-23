//Sondos Hijab 11923751
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
 static int UnBoundedKnapFun(int n,int w,int c[],int p[]){
        int[][] T = new int[n+1][w+1];
        boolean[][] Tbool = new boolean[n+1][w+1];
        
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
                        Tbool[i][j] = true;
                }
                    else
                        {T[i][j] = T[i-1][j];
                        Tbool[i][j] = false;

                        }
                }
                else
                {
                    T[i][j] = T[i-1][j];
                    Tbool[i][j] = false;

                }
            }
           
            
        }
        
        return T[n][w];
    }
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
        int numOfC = sc.nextInt();
        int n = sc.nextInt();
        int w = sc.nextInt();
        int subt = sc.nextInt();
        w-=subt;
        int c [] = new int [n];
        int p [] = new int[n];
        for(int i=0;i<n;i++){
            c[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            p[i] = sc.nextInt();
        }


        //here we start with the code :)

        System.out.println(UnBoundedKnapFun(n,w,c,p));
    }
}
