class Solution
{
    static int getIndex(int[] a, int low, int high, int key) {
        int mid = low + (high - low) / 2;

        if (a[mid] == key) {
            return mid;
        }

        if (a[low] < a[mid]) {
            if (key >= a[low] && key <= a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        } else {
            if (key <= a[high] && key >= a[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return getIndex(a, low, high, key);
    }

    int search(int A[], int l, int h, int key)
    {
        return getIndex(A, l, h, key);
    }
}
