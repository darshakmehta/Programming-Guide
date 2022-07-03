import java.util.*;
import java.lang.*;
import java.io.*;

class Solution { // Time: O(n*log(n)) and Space: O(1)
	static class Interval {
		int start;
		int end;
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static int mergeIntervals(Interval[] interval, int n) {
		Arrays.sort(interval, new Comparator<Interval>() {
			public int compare(Interval x, Interval y) {
				return x.start - y.start;
			}
		});

		int index = 0;

		for (int i = 1; i < n; i++) {
			if (interval[index].end >= interval[i].start) {
				interval[index].end = Math.max(interval[index].end, interval[i].end);
			} else {
				index++;
				interval[index] = interval[i];
			}
		}

		return index;
	}

	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // number of intervals
		if (n == 0) {
			System.out.println("No Input provided");
			return;
		}

		Interval[] interval = new Interval[n];
		for (int i = 0; i < n; i++) {
			interval[i] = new Interval(sc.nextInt(), sc.nextInt());
		}

		int index = mergeIntervals(interval, n);
		for (int i = 0; i <= index; i++) {
			System.out.println(interval[i].start + " " + interval[i].end);
		}
	}
}

/**
Ideone: https://ideone.com/4GUczw
**/
