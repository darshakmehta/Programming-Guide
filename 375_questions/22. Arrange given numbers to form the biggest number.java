import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static void printLargest(List<String> arr, int n) {
		Collections.sort(arr, new Comparator<String>() {
			@Override public int compare(String X, String Y) {
				// first append Y at the end of X
                String XY = X + Y;

                // then append X at the end of Y
                String YX = Y + X;

                return XY.compareTo(YX) > 0 ? -1 : 1;
			}
		});

		Iterator it = arr.iterator();

        while (it.hasNext()) {
            System.out.print(it.next());
        }
	}
	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // number of elements
		if (n == 0) {
			System.out.println("No Input provided");
			return;
		}

		int[] arr = new int[n];
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			list.add(String.valueOf(arr[i])); // convert it to string to avoid overflow
		}

		printLargest(list, n);
	}
}

/**
Ideone: https://ideone.com/ap19tF
**/
