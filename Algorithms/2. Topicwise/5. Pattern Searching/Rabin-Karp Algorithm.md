1. String comparison is more costly than numeric comparison
2. Hashing converts the string to a numeric value, which speed up testing the equality of pattern and substring.
3. The algorithm exploits the fact that if two strings are equal, their hash values are also equal.

# Hash function => O(1)

Hash at the next shift must be efficiently computable (O(1)) from the current has value and next character in text.

