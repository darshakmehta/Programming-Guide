/**
 * Using Heap: Time Complexity: O(n Log n) and Auxiliary Space: O(n)
 * Ideone: https://ideone.com/VC4U2C
 */
class Solution {
    public static void printMedian(int[] arr) {
        // Max Heap to store smaller half elements
        PriorityQueue<Integer> smallerMaxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        // Min Heap to store greater half elements
        PriorityQueue<Integer> greaterMinHeap = new PriorityQueue<Integer>();

        double median = arr[0];
        smallerMaxHeap.add(arr[0]);

        System.out.println(median);

        // Read elements of stream one by one
        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];

            // Case 1: Left side heap has more elements
            if (smallerMaxHeap.size() > greaterMinHeap.size()) {
                if (x < median) {
                    greaterMinHeap.add(smallerMaxHeap.remove());
                    smallerMaxHeap.add(x);
                } else {
                    greaterMinHeap.add(x);
                }
                median = (double) (smallerMaxHeap.peek() + greaterMinHeap.peek()) / 2;
            }

            // Case 2: Both Heaps are balanced
            else if (smallerMaxHeap.size() == greaterMinHeap.size()) {
                if (x < median) {
                    smallerMaxHeap.add(x);
                    median = (double) smallerMaxHeap.peek();
                } else {
                    greaterMinHeap.add(x);
                    median = (double) greaterMinHeap.peek();
                }
            }

            // Case 3: Right side heap has more elements
            else {
                if (x > median) {
                    smallerMaxHeap.add(greaterMinHeap.remove());
                    greaterMinHeap.add(x);
                } else {
                    smallerMaxHeap.add(x);
                }
                median = (double) (smallerMaxHeap.peek() + greaterMinHeap.peek()) / 2;
            }

            System.out.println(median);
        }
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        printMedian(arr);
    }
}
