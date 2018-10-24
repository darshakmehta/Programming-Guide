public class Solution { //Binary Search
	public int kthSmallest(int[][] matrix, int k) {
		int low = matrix[0][0];
		int high = matrix[matrix.length - 1][matrix[0].length - 1] + 1; //[low, high)

		while(low < high) {
			int mid = low + (high - low) / 2;
			int count = 0, j = matrix[0].length - 1;

			for(int i = 0; i < matrix.length; i++) {
				while(j >= 0 && matrix[i][j] > mid) j--;
				count += j  + 1;
			}
			if(count < k) low = mid + 1;
			else high = mid;
		}
		return low;
	}
}

public class Solution { //minHeap
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		PriorityQueue<Tuple> queue = new PriorityQueue<Tuple>();
		for(int j = 0; j <= n - 1; j++) {
			queue.offer(new Tuple(0, j, matrix[0][j]));
		}
		for(int i = 0; i < k - 1; i++) {
			Tuple tuple = queue.poll();
			if(tuple.x == n - 1) continue;
			queue.offer(new Tuple(tuple.x + 1, tuple.y, matrix[tuple.x + 1][tuple.y]));
		}
		return queue.poll().val;
	}
}

class Tuple implements Comparable<Tuple> {
	int x, y, val;
	public Tuple(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}

	@Override
	public int compareTo(Tuple that) {
		return this.val - that.val;
	}
}