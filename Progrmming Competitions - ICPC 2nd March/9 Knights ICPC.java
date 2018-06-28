import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Solution s = new Solution();
		Scanner sc = new Scanner(System.in);
		char [][]a = new char[5][5];
		int count = 0;
		for(int i = 0; i<5;i++) {
			String s1 = sc.next();
			for(int j = 0; j<5; j++) {
				a[i][j] = s1.charAt(j);
				if(a[i][j] == 'k')
					count++;	
			}
		}
		int flag = 0;
		if(count == 9) {
		for(int i = 0; i<5;i++) {
			for(int j = 0; j<5; j++) {
				if(a[i][j] == 'k') {
					if(((i+2 < 5) && (j+1<5)) &&(a[i+2][j+1] == 'k')) {
						flag =1;
						break;
					}
					if(((i+1 < 5) && (j+2<5)) &&(a[i+1][j+2] == 'k')) {
						flag =1;
						break;
					}
					
					if(((i-1 >0) && (j+2<5)) &&(a[i-1][j+2] == 'k')) {
						flag =1;
						break;
					}
					
					
					if(((i-2 > 0) && (j+1<5)) &&(a[i-2][j+1] == 'k')) {
						flag =1;
						break;
					}
					
					
					if(((i-2 >0) && (j-1>0)) &&(a[i-2][j-1] == 'k')) {
						flag =1;
						break;
					}
					
					if(((i-1 >0) && (j-2>0)) &&(a[i-1][j-2] == 'k')) {
						flag =1;
						break;
					}
					
					if(((i+1<5) && (j-2 > 0)) &&(a[i+1][j-2] == 'k')) {
						flag =1;
						break;
					}
					
					if(((i+2<5) && (j-1 > 0)) &&(a[i+2][j-1] == 'k')) {
						flag =1;
						break;
					}	
				}
			}
		}
		}
		if(flag == 1 || count!=9) {
			System.out.println("invalid");
		}else {
			System.out.println("valid");
		}
		
	}
}