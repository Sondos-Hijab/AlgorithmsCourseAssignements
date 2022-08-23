// Sondos Qais Salah Hijab 11923751
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    // swapping method
    static void swap(int [] a, int i1, int i2){
        int temp=a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }
    
    // quick sort method    
    static void quickSort(int [] a, int li, int hi){
    if (li >= hi) {
      return;
    }

    int pi = new Random().nextInt(hi - li) + li;
    int p = a[pi];
    swap(a, pi, hi);

    int lp = partition(a, li, hi, p);

    quickSort(a, li, lp - 1);
    quickSort(a, lp + 1, hi);
    }
    
    // partitioning method
    static int partition(int[] a, int li, int hi, int p) {
        int lp = li;
        int rp = hi - 1;

            while (lp < rp) {
              while (a[lp] <= p && lp < rp) {
                lp++;
              }
              while (a[rp] >= p && lp < rp) {
                rp--;
              }

              swap(a, lp, rp);
            }
            if(a[lp] > a[hi]) {
              swap(a, lp, hi);
            }
            else {
              lp = hi;
            }

            return lp;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan=new Scanner(System.in);  
        int num = scan.nextInt(); 
        int Array [] = new int [num];
        for (int r=0;r<num;r++){
            Array[r] = scan.nextInt();
        }

        quickSort(Array, 0 , Array.length-1);
                    
        for(int i=0;i<num;i++){
                if(i==0) System.out.print("["+Array[i]+",");
                else if (i==num-1) System.out.print(Array[i]+"]");
                else System.out.print(Array[i]+",");
                }
    }
}
