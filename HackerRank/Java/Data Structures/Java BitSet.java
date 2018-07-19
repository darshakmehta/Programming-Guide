import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        BitSet bitset[] = new BitSet[3];
        bitset[1] = b1;
        bitset[2] = b2;
        
        for(int i = 0; i < m; i++) {
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            int x = Integer.parseInt(arr[1]);
            int y = Integer.parseInt(arr[2]);
            switch(arr[0]) {
                case "AND" :
                    bitset[x].and(bitset[y]);
                    break;
                case "OR" :
                     bitset[x].or(bitset[y]);
                     break;
                case "XOR" :
                     bitset[x].xor(bitset[y]);
                    break;
                case "FLIP" :                    
                      bitset[x].flip(y);
                      break;
                case "SET" :
                     bitset[x].set(y);
                     break;
            }
           
            System.out.println(b1.cardinality() +" " + b2.cardinality());
        }
    }
}