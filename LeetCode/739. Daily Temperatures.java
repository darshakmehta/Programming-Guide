class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        Stack<int[]> stack = new Stack();
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            // days is 0 when there is no warmer temperature available (stack empty)
            int days = 0;

            // current temperature is warmer than stack top
            while (!stack.isEmpty() && stack.peek()[0] <= T[i]) {
                // pop colder temperature
                days += stack.pop()[1];
            }

            if (!stack.isEmpty()) {
                result[i] = ++days;
            } else {
                result[i] = 0; // stack is empty => there is no warmer temperature available
            }

            // If current temperature is colder compare to stack top push to the stack
            stack.push(new int[] {T[i], result[i]});
        }

        return result;
    }
}

// Note: Monotonous stack can help us find first largest element in O(n) time complexity.

// TODO: Improve space complexity of Stack from int[] to int
// TODO: Use Deque Interface instead of Stack class =>  Deque<Integer> stack = new ArrayDeque<Integer>();
