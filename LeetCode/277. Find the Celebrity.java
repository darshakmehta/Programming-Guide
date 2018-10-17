public Solution {
	public static int findCelebrity(int n) {
		int celeb = 0;
		// We find a 'i' which is known by everyone, but doesn't know anyone.
		for (int i = 1; i < n; i++) {
			if (knows(celeb, i))
				celeb = i;
		}
		/*
		 * To make sure the value we find out is actually the celebrity, we
		 * check if celeb knows none and everyone knows him.
		 */
		for (int i = 0; i < n; i++) {
			if (i != celeb && (knows(celeb, i) || !knows(i, celeb)))
				return -1;
		}

		return celeb;
	}
}

/***

TODO:
1. Graph O(N^2)
2. Recursion
3. Using Stack
4. Using Two Pointers
5. Write code to find celebrity. Don’t use any data structures like graphs, stack, etc… you have access to N and HaveAcquaintance(int, int) only.
6. Implement the algorithm using Queues. What is your observation? Compare your solution with Finding Maximum and Minimum in an array and Tournament Tree. What are minimum number of comparisons do we need (optimal number of calls to HaveAcquaintance())?

Similar Problem: Number of Sink Nodes

References: 
1. https://letstalkalgorithms.com/find-the-celebrity/
2. https://www.geeksforgeeks.org/the-celebrity-problem/

***/