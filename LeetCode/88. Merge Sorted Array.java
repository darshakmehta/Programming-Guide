class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int arr[] = new int[nums1.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < (nums1.length - nums2.length) && j < nums2.length) {
            if(nums1[i] <= nums2[j]) {
                arr[k] = nums1[i];
                i++;
            } else {
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }
        
        while(i < (nums1.length - nums2.length)) {
            arr[k++] = nums1[i++];
        }
        
        while(j < nums2.length) {
            arr[k++] = nums2[j++];
        }
        
        for(i = 0; i < arr.length; i++)
            nums1[i] = arr[i];
    }
}