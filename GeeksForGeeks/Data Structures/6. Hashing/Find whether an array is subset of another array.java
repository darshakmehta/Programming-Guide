import java.util.Arrays;
class Solution
{
    static boolean isSubset(int arr1[], int arr2[], int m,int n) { // m should be greater than n
        int i = 0, j = 0;
             
        if(m < n)
        	return false;
         
        Arrays.sort(arr1); 
        Arrays.sort(arr2);
 
        while( i < n && j < m )
        {
            if( arr1[j] < arr2[i] )
                j++;
            else if( arr1[j] == arr2[i] )
            {
                j++;
                i++;
            }
            else if( arr1[j] > arr2[i] )
                return false;
        }
         
        if( i < n )
            return false;
        else
            return true;
    } 
         
    public static void main(String[] args) 
    { 
        int arr1[] = {11, 1, 13, 21, 3, 7};
        int arr2[] = {11, 3, 7, 1};
         
        int m = arr1.length;
        int n = arr2.length;
         
        if(isSubset(arr1, arr2, m, n))
        	System.out.println("arr2 is a subset of arr1");
        else
        	System.out.println("arr2 is not a subset of arr1");
    }
}



/***

TODO:

Method 1: Brute Force
Method 2: Sorting and Binary Search
Method 3: Sorting and Merge Process (Solved above)
1) Sort both arrays: arr1[] and arr2[] O(mLogm + nLogn)
2) Use Merge type of process to see if all elements of sorted arr2[] are present in sorted arr1[]

Time Complexity: O(mLogm + nLogn) which is better than method 2. Please note that this will be the complexity if an nLogn algorithm is used for sorting both arrays which is not the case in above code. In above code Quick Sort is sued and worst case time complexity of Quick Sort is O(n^2)

Method 4: Hashing

Note: Method 3 takes care of duplicate values, we need to make changes in other methods to incorporate the change.

***/