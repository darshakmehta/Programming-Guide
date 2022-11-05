class Solution {
    public static int[] productArray(int[] arr, int n) {
        int[] prod = new int[n];

        // left side product
        prod[0] = 1;

        for (int i = 1; i < n; i++) {
            prod[i] = prod[i-1] * arr[i-1];
        }

        // right side product
        int temp = 1;

        for (int i = n - 2; i >= 0; i--) {
            temp = temp * arr[i+1];
            prod[i] = prod[i] * temp;
        }

        return prod;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 3, 5, 6, 2 };
        int n = arr.length;
        System.out.println("The product array is : ");
        int[] result = productArray(arr, n);
        System.out.println(Arrays.toString(result));
    }
}
