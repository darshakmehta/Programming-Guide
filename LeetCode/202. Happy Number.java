class Solution {

  public int squareDigitsOfNumber(int n) {
    int temp = 0;
    while (n > 0) {
      temp += (n % 10) * (n % 10);
      n = n / 10;
    }
    return temp;
  }

  public boolean isHappy(int n) {
    int slow = squareDigitsOfNumber(n);
    int fast = squareDigitsOfNumber(squareDigitsOfNumber(n));

    while (slow != 1 && slow != fast) {
      slow = squareDigitsOfNumber(slow);
      fast = squareDigitsOfNumber(fast);
      fast = squareDigitsOfNumber(fast);
    }

    return slow == 1;
  }
}

// First Solution: Slow and Fast Pointers
// Second Solution: Using HashMap
// Third Solution: It can take max 18 iterations to find if it is loop.

// Third Solution

class Solution {

  public int squareDigitsOfNumber(int n) {
    int temp = 0;
    while (n > 0) {
      temp += (n % 10) * (n % 10);
      n = n / 10;
    }
    return temp;
  }

  public boolean isHappy(int n) {
    for (int i = 1; i <= 18; i++) {
      int x = squareDigitsOfNumber(n);
      if (x == 1) {
        return true;
      }
      n = x;
    }
    return false;
  }
}
