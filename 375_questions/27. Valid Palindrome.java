class Solution { // Two Pointer technique
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            if (!Character.isLetterOrDigit(arr[left])) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(arr[right])) {
                right--;
                continue;
            }

            if (Character.toLowerCase(arr[left]) != Character.toLowerCase(arr[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
