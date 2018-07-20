//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
         HashMap<String, Integer> hmap  = new HashMap<String, Integer>();;
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            hmap.put(name, phone);
            
        }
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            if(hmap.containsKey(s))
                System.out.println(s+"="+hmap.get(s));
            else
                System.out.println("Not found");
        }
        in.close();
    }
}