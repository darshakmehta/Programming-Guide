public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int max = 0, maxNum = 0;
        for (char c : tasks) {
            count[c - 'A']++;
            if (count[c - 'A'] > max) {
                max = count[c - 'A'];
                maxNum = 1;
            } else if (count[c - 'A'] == max) {
                maxNum++;
            }
        }
        return Math.max(tasks.length, (max - 1) * (n + 1) + maxNum);
    }
}

/***

ACCCEEE 2
"CE_CE_CE_" <== 3 identical chunks "CE_" and this is the frame. You missed the last space. This has c[25]x(n-1) time units.
"CE_CE_CE" <== But the last spaces should be omitted since we don't need to count the last idles if there is no task left. And there are (n+1-f) last spaces where f is the number of most frequent tasks.
"CEACE_CE" <== To insert task 'A'.

So the calculation formula is
c[25]x(n+1) - (n+1-f) == (c[25] - 1)x(n+1) + f
which is the formula

***/