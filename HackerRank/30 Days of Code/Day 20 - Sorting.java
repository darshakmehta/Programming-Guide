import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = a[i];
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        // Write Your Code Here
        boolean isSorted = false;
        int lastUnsorted = a.length - 1;
        int countSwaps = 0;
        while(!isSorted) {
            isSorted = true;
            for(int i = 0; i < lastUnsorted; i++) {
                if(a[i] > a[i+1]) {
                    swap(a, i, i + 1);
                    isSorted = false;
                    countSwaps++;
                }
            }
            lastUnsorted--;
        }
        System.out.println("Array is sorted in " + countSwaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);
    }
}