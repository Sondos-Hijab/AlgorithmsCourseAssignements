/*Sondos Qais Hijab 11923751*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan=new Scanner(System.in);  
        int num = scan.nextInt(); 
        int A [] = new int [num];
        for (int r=0;r<num;r++){
            A[r] = scan.nextInt();
        }
        for (int j=1;j<num;j++){
            while(j>0){
                if(A[j]<A[j-1]){
                    int temp = A[j];
                    A[j]=A[j-1];
                    A[j-1]=temp;
                }
                else
                break;
                j--;
            }
        }
        
     for(int i=0;i<num;i++){
        if(i==0) System.out.print("["+A[i]+",");
        else if (i==num-1) System.out.print(A[i]+"]");
        else System.out.print(A[i]+",");
     }
     }


}
