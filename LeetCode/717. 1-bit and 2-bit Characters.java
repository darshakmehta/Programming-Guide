class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1; // If 2 bit jump by 1 + 1, or  0 + 1
        }
        return i == bits.length - 1;
    }
}

/***

Intuition and Algorithm

The second-last 0 must be the end of a character (or, the beginning of the array if it doesn't exist). Looking from that position forward, the array bits takes the form [1, 1, ..., 1, 0] where there are zero or more 1's present in total. It is easy to show that the answer is true if and only if there are an even number of ones present.

In our algorithm, we will find the second last zero by performing a linear scan from the right. We present two slightly different approaches below.

**/

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = bits.length - 2;
        while (i >= 0 && bits[i] > 0) i--;
        return (bits.length - i) % 2 == 0;
    }
}

/***

We don't need to traverse the whole array, just check the last part of it.

if there is only one symbol in array the answer is always true (as last element is 0)
if there are two 0s at the end again the answer is true no matter what the rest symbols are( ...1100, ...1000,)
if there is 1 right before the last element(...10), the outcome depends on the count of sequential 1, i.e.
a) if there is odd amount of 1(10, ...01110, etc) the answer is false as there is a single 1 without pair
b) if it's even (110, ...011110, etc) the answer is true, as 0 at the end doesn't have anything to pair with

**/

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int ones = 0;
        //Starting from one but last, as last one is always 0.
        for (int i = bits.length - 2; i >= 0 && bits[i] != 0 ; i--) { 
            ones++;
        }
        if (ones % 2 > 0) return false; 
        return true;
    }
}