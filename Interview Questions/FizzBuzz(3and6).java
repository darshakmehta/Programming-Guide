import java.lang.*;
 
class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		for ( int i = 1; i <= 97; i += 6 ) {
			System.out.println("The number '" + i + "' is odd.");
			System.out.println("The number '" + (i + 1) + "' is even.");
			System.out.println("The number '" + (i + 2) + "' is divisible by three.");
			System.out.println("The number '" + (i + 3) + "' is even.");
			if( i + 3 == 100) return;
			System.out.println("The number '" + (i + 4) + "' is odd.");
			System.out.println("The number '" + (i + 5) + "' is divisible by two and three.");
		}
	}
}