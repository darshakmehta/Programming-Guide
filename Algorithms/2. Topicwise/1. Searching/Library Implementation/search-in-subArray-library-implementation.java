import java.util.Arrays; 
import java.lang.*;
import java.io.*;

class Solution {
	public static void main (String[] args) throws java.lang.Exception {
        byte byteArr[] = {10,20,15,22,35}; 
        char charArr[] = {'g','p','q','c','i'}; 
        int intArr[] = {1,2,3,4,5,6}; 
        double doubleArr[] = {10.2,15.1,2.2,3.5}; 
        float floatArr[] = {10.2f,15.1f,2.2f,3.5f}; 
        short shortArr[] = {10,20,15,22,35}; 
  
        Arrays.sort(byteArr); 
        Arrays.sort(charArr); 
        Arrays.sort(intArr); 
        Arrays.sort(doubleArr); 
        Arrays.sort(floatArr); 
        Arrays.sort(shortArr); 
  
        byte byteKey = 22; 
        char charKey = 'p'; 
        int intKey = 3; 
        double doubleKey = 1.5; 
        float floatKey = 35; 
        short shortKey = 5; 
  
        System.out.println(byteKey + " found at index = "
                        +Arrays.binarySearch(byteArr,2,4,byteKey)); 
        System.out.println(charKey + " found at index = "
                        +Arrays.binarySearch(charArr,1,4,charKey)); 
        System.out.println(intKey + " found at index = "
                        +Arrays.binarySearch(intArr,1,4,intKey)); 
        System.out.println(doubleKey + " found at index = "
                        +Arrays.binarySearch(doubleArr,1,4,doubleKey)); 
        System.out.println(floatKey + " found at index = "
                        +Arrays.binarySearch(floatArr,1,4,floatKey)); 
        System.out.println(shortKey + " found at index = "
                        +Arrays.binarySearch(shortArr,0,4,shortKey)); 
	}

}


/***

Binary search - Sorted Array within subArray (Library)

Syntax :

public static int binarySearch(data_type[] arr, int fromIndex, int toIndex, data_type key)
Parameters :
arr – the array to be searched
fromIndex – the index of the first element (inclusive) to be searched
toIndex - the index of the last element (exclusive) to be searched
 key  – the value to be searched for


It is static inbuilt method defined in Arrays (java.util.Arrays) class in java and returns the index of the specified key if found within the specified range.

Here, data_type can be any of the primitive data_type: byte, char, double, int, float, short, long and Object as well.

The above function Searches a range of the specified array of the given data type for the specified key using binary search algorithm.
The range within which the specified key to be searched must be sorted (as by the Arrays.sort() method) prior to making this call. 
Otherwise result would be undefined. If the specified array contains multiple values same as the specified key, there is no guarantee which one will be found.

Returns :
Index of the specified key if found within the specified range in the specified array, Otherwise (-(insertion point) – 1).
The insertion point is defined as a point at which the specified key would be inserted: the index of the first element in the range greater than the key, or toIndex if all elements in the range are less than the specified key.
Note:This guarantees that the return value will be >= 0 if and only if the key is found.

Exceptions :

IllegalArgumentException : throws when starting index(fromIndex) is greater than the end index(toIndex) of specified range.(means: fromIndex > toIndex)
ArrayIndexOutOfBoundsException : throws if one or both index are not valid means fromIndex< 0 or toIndex > arr.length.

Important Points:

If input list is not sorted, the results are undefined.
If there are duplicates, there is no guarantee which one will be found.

Source: https://www.geeksforgeeks.org/arrays-binarysearch-in-java-with-examples-set-2-search-in-subarray/

***/