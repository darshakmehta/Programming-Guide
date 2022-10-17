public static long nthCatalanNumber (int n) {
    long[] catalan = new long[n + 1];

    // Base Case
    catalan[0] = 1;
    catalan[1] = 1;

    for (int i = 2; i <= n; i++) {
        for (int j = 0; j < i; j++) {
            catalan[i] += catalan[j] * catalan[i - j - 1];
        }
    }

    return catalan[n];
}
