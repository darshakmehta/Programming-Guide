/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl { //TLE
    public int firstBadVersion(int n) {
        
        for(int i = 1; i <=n; i++) {
            if(isBadVersion(i)) {
                return i;
            }
        }
        return n;
    }
}

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

/***

If you are setting mid = {left + right}/{2}, you have to be very careful. Unless you are using a language that does not overflow such as Python, left + right could overflow. One way to fix this is to use left + {right - left}/{2} instead.

If you fall into this subtle overflow bug, you are not alone. Even Jon Bentley's own implementation of binary search had this overflow bug and remained undetected for over twenty years.

***/