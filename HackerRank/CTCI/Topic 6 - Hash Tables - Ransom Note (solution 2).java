import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;
import java.security.KeyStore.Entry;

public class HashTable {
	public static void main(String arg[]) {
		Map<String, Integer> mapA = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		boolean flag = true;
		
		for(int i=0; i<m ;i++) {
			String s = sc.next();
			if(mapA.containsKey(s)) {
				mapA.put(s,mapA.get(s)+1);
			}else {
				mapA.put(s, 1);
			}
		}
		for(int i=0; (i < n && flag) ;i++) {
			String s = sc.next();
			if(mapA.containsKey(s)) {
				int x = mapA.get(s);
				if(x >= 1)
					mapA.put(s,mapA.get(s) - 1);
				else
					flag = false;
			}else {
				flag = false;
			}
			
		}
		if(flag) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		
		sc.close();
		
	}
}