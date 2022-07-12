import java.util.*;
import java.lang.*;
import java.io.*;

class Solution { // TODO: Verify this works
	public static void search(String pat, String txt, int q) {
		// d is the number of characters in the input alphabet
    	int d = 256;

		int M = pat.length();
		int N = txt.length();
		int p = 0; // hash value of pattern
		int t = 0; // hash value of text
		int h = 1;
		int i, j;

		// The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate the hash value of pattern and first window of text
        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

		// Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {
        	// Check the hash values of current window of text
            // and pattern. If the hash values match then only
            // check for characters one by one
            if ( p == t )
            {
                /* Check for characters one by one */
                for (j = 0; j < M; j++)
                {
                    if (txt.charAt(i+j) != pat.charAt(j)) {
                        break;
                    }
                }

                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == M) {
                    System.out.println("Pattern found at index " + i);
                }

                // Calculate hash value for next window of text: Remove
	            // leading digit, add trailing digit
	            if ( i < N-M ) {
	                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;

	                // We might get negative value of t, converting it
	                // to positive
	                if (t < 0) {
	                	t = (t + q);
	                }
	            }
            }
        }
	}

	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		String pattern = sc.nextLine();

		int q = 101; // prime number
		search(pattern, text, q);
	}
}

/**
Ideone: https://ideone.com/yH1Z6C
**/

/**
Time Complexity:
The average and best-case running time of the Rabin-Karp algorithm is O(n+m), but its worst-case time is O(nm).
Worst case of Rabin-Karp algorithm occurs when all characters of pattern and text are same
as the hash values of all the substrings of txt[] match with hash value of pat[].
For example pat[] = “AAA” and txt[] = “AAAAAAA”.
**/

/**
Reference: https://www.geeksforgeeks.org/rabin-karp-algorithm-for-pattern-searching/
**/
