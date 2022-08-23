import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
     static void radixsort(int a[])
    {
        int n = a.length;
        int max = findMaximumNumberIn(a);
        for (int exponential = 1; max / exponential > 0; exponential *= 10)
            countSort(a, exponential);
    }
    
        static int findMaximumNumberIn(int a[])
    {
        int n = a.length;
        int max = a[0];
        for (int i = 1; i < n; i++)
            if (a[i] > max)
                max = a[i];
        return max;
    }
    
    
     static void countSort(int a[], int exponential)
    {
        int n= a.length;
        int op[] = new int[n]; 
        int index;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (index = 0; index < n; index++)
            count[(a[index] / exponential) % 10]++;

        for (index = 1; index < 10; index++)
            count[index] += count[index - 1];

        for (index = n - 1; index >= 0; index--) {
            op[count[(a[index] / exponential) % 10] - 1] = a[index];
            count[(a[index] / exponential) % 10]--;
        }
        
        for (index = 0; index < n; index++)
            a[index] = op[index];
    }
    

    
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan=new Scanner(System.in);  
        int num = scan.nextInt(); 
        int Array [] = new int [num];
        for (int r=0;r<num;r++){
            Array[r] = scan.nextInt();
        }
        
        
        radixsort(Array);
                    
        for(int i=0;i<num;i++){
                if(i==0) System.out.print("["+Array[i]+",");
                else if (i==num-1) System.out.print(Array[i]+"]");
                else System.out.print(Array[i]+",");
                }
    }
}
