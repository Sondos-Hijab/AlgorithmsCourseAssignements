/*Sondos Hijab 11923751*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    void merge (int array[], int left, int middle, int right){
        int length1 = middle - left + 1;
        int length2 = right - middle;
        
        int [] arr1 = new int [length1];
        int [] arr2 = new int [length2];
        
        for (int i=0;i<length1;i++){
            arr1[i] = array[left+i];
        }
        for (int j=0;j<length2;j++){
            arr2[j] = array[middle+1+j];
        }
        
        int count1=0,count2=0;
        int count3=left;
        
        while(count1<length1 && count2<length2){
            if(arr1[count1] <= arr2[count2]){
                array[count3] = arr1[count1];
                count1++;
            }
            else{
                array[count3] = arr2[count2];
                count2++;
            }
            count3++;
        }
        
        while(count1<length1){
            array[count3] = arr1[count1];
            count1++;
            count3++;
        }
        while(count2<length2){
            array[count3] = arr2[count2];
            count2++;
            count3++;
        }
    }
    
    void sort(int array[],int left, int right ){
        if(left<right){
            int middle = left + (right-left)/2;
            sort(array,left,middle);
            sort(array,middle+1, right);
            merge(array, left, middle, right);
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan=new Scanner(System.in);  
        int num = scan.nextInt(); 
        int Array [] = new int [num];
        for (int r=0;r<num;r++){
            Array[r] = scan.nextInt();
        }
        Solution object = new Solution();
        object.sort(Array, 0, Array.length - 1);
        
        
        for(int i=0;i<num;i++){
            if(i==0) System.out.print("["+Array[i]+",");
            else if (i==num-1) System.out.print(Array[i]+"]");
            else System.out.print(Array[i]+",");
         }
  
    }
}
