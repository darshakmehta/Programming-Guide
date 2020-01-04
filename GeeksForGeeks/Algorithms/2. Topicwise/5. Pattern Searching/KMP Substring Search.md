# Knuth-Morris-Pratt Pattern searching (Substring search)

1. Brute Force

Compare every character of pattern to each character of text until we find a match of entire pattern we return the index. If we cannot find, we will return -1.

Time complexity: O(m * n) 
where m is length of text and n is length of pattern.

2. KMP Algo

To build Pattern DP[]

Time and Space: O(n)


Time complexity: O(m + n)
where m is time to build pattern dp[] and n is time to build text dp[]

Space: O(n)

# Prefix Array Logic

