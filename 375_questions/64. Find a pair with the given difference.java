/**
 * Using Binary Saerch
 * Ideone: https://ideone.com/Ne0suc
 */
class Solution {
    public static void findPair(int[] arr, int x) { // Time: O(nlogn)
        Arrays.sort(arr);
        int len = arr.length;
        x = Math.abs(x);

        for (int i = 0; i < len; i++) {
            int low = i+1;
            int high = len - 1;
            int temp = x + arr[i];

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (arr[mid] == (temp)) {
                    System.out.println("Pair found: " + arr[i] + " , " + arr[mid]);
                    return;
                }

                if (arr[mid] < temp) {
                    low = mid + 1;
                }
                if (arr[mid] > temp) {
                    high = mid - 1;
                }
            }
        }
        System.out.println("No such pair");
    }

    public static void main (String[] args) {
        int arr[] = {1, 8, 30, 40, 100};
        int x = -60;
        findPair(arr,x);
    }
}

/**
 * Using Hashing
 * Ideone: https://ideone.com/5B0KfU
 */
class Solution {
    public static void findPair(int[] arr, int x) { // Time: O(n)
        x = Math.abs(x);
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            int temp = x + arr[i];
            if (hmap.containsKey(arr[i])) {
                System.out.println("Pair found: " + arr[i] + " " + hmap.get(arr[i]));
                return;
            }

            hmap.put(temp, arr[i]);
        }

        System.out.println("No such pair");
    }

    public static void main (String[] args) {
        int arr[] = {1, 8, 30, 40, 100};
        int x = -60;
        findPair(arr,x);
    }
}
