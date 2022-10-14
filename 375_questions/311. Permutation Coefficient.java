/**
 * Helper formula: P(n, k) = n! / (n - k)!
 */
class Solution {
    public int permutationCoefficient(int n, int k) {
        int[] fact = new int[n + 1];

        // base case
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = i * fact[i - 1]; // calculate fact! till n and save in fact[] to use it to compute (n - k)!
        }

        return fact[n] / fact[n - k];
    }
}

/**
 * We can save memory since we only memoized to calculate (n-k)! but we can skip fact[]
 */
class Solution {
    public int permutationCoefficient(int n, int k) {
        int fn = 1, fk = 1;

        for (int i = 1; i <= n; i++) {
            fn = fn * i; // This stores n!
            if (i == (n - k)) {
                fk = fn; // This stores (n - k)!
            }
        }

        return fn / fk;
    }
}
