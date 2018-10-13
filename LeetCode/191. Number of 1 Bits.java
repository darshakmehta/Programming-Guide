public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        int count = 0;
        while(n != 0) {
            if(Integer.remainderUnsigned(n,2) == 1)
                count++;
            n = Integer.divideUnsigned(n, 2);
        }
        return count;
    }
}


/**

Algorithm

The solution is straight-forward. We check each of the 3232 bits of the number. If the bit is 11, we add one to the number of 11-bits.

We can check the i^{th} ith bit of a number using a bit mask. We start with a mask m=1, because the binary representation of 11 is,

0000 0000 0000 0000 0000 0000 0000 0001

Clearly, a logical AND between any number and the mask 11 gives us the least significant bit of this number. To check the next bit, we shift the mask to the left by one.

0000 0000 0000 0000 0000 0000 0000 0010

And so on.

The run time depends on the number of bits in n. Because nn in this piece of code is a 32-bit integer, the time complexity is O(1)

The space complexity is O(1), since no additional space is allocated.

**/

public int hammingWeight(int n) {
    int bits = 0;
    int mask = 1;
    for (int i = 0; i < 32; i++) {
        if ((n & mask) != 0) {
            bits++;
        }
        mask <<= 1;
    }
    return bits;
}

/**

We can make the previous algorithm simpler and a little faster. Instead of checking every bit of the number, we repeatedly flip the least-significant 1-bit of the number to 0, and add 1 to the sum. As soon as the number becomes 0, we know that it does not have any more 1-bits, and we return the sum.

The key idea here is to realize that for any number n, doing a bit-wise AND of n and n - 1 flips the least-significant 1-bit in n to 0. Why? Consider the binary representations of n and n - 1.

In the binary representation, the least significant 1-bit in n always corresponds to a 0-bit in n - 1. Therefore, anding the two numbers n and n - 1 always flips the least significant 1-bit in n to 0, and keeps all other bits the same.

Using this trick, the code becomes very simple.

The run time depends on the number of 11-bits in nn. In the worst case, all bits in nn are 11-bits. In case of a 32-bit integer, the run time is O(1).

The space complexity is O(1), since no additional space is allocated.

**/

public int hammingWeight(int n) {
    int sum = 0;
    while (n != 0) {
        sum++;
        n &= (n - 1);
    }
    return sum;
}