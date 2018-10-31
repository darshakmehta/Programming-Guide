class Solution {
    public int numTrees(int n) {
        int [] G = new int[n+1];
        G[0] = G[1] = 1; //empty tree or only one root - Base Condition

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j]; 
            }
        }

        return G[n];
    }
}

/* Note: Application of Catalan Numbers */
/* 

Recursive - Inefficient

 public int numTrees(int n) {
    return trees(1, n);
}

int trees(int lo, int hi) {
    if (lo >= hi) return 1;
    int total = 0;
    for (int i = lo; i <= hi; i++)
        total += trees(lo, i - 1) * trees(i + 1, hi);
    return total;
}

*/

/***

F(i, n) = G(i-1) * G(n-i)	1 <= i <= n 
G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0) 

***/
