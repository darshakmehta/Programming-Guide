public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }
}

public class Solution { //BFS solution
     public int numSquares(int n) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        for (int level = 0; !queue.isEmpty(); level++) {
            for (int i = queue.size(); i > 0; i--) {
                int num = queue.poll();
                if (num == 0) return level;
                for (int j = 1; j * j <= num; j++)
                    if (set.add(num - j * j))
                        queue.offer(num - j * j);
            }
        }
        return 0;
    }
}