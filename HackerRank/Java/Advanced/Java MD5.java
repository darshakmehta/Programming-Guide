import java.io.*;
import java.util.*;
import java.security.*; 
import java.nio.charset.StandardCharsets;

public class Solution {
    
    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) 
                hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        try{
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] encodedhash = digest.digest(s.getBytes(StandardCharsets.UTF_8));
            System.out.println(bytesToHex(encodedhash));
        } catch(NoSuchAlgorithmException e) {
            System.out.println(e);
        }
    }
}