import java.util.Arrays; 
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		byte byteArr[] = {10,20,15,22,35}; 
        char charArr[] = {'g','p','q','c','i'}; 
        int intArr[] = {10,20,15,22,35}; 
        double doubleArr[] = {10.2,15.1,2.2,3.5}; 
        float floatArr[] = {10.2f,15.1f,2.2f,3.5f}; 
        short shortArr[] = {10,20,15,22,35}; 
  
        Arrays.sort(byteArr); 
        Arrays.sort(charArr); 
        Arrays.sort(intArr); 
        Arrays.sort(doubleArr); 
        Arrays.sort(floatArr); 
        Arrays.sort(shortArr); 
  
        byte byteKey = 35; 
        char charKey = 'g'; 
        int intKey = 22; 
        double doubleKey = 1.5; 
        float floatKey = 35; 
        short shortKey = 5; 
  
        System.out.println(byteKey + " found at index = "
                           +Arrays.binarySearch(byteArr,byteKey)); 
        System.out.println(charKey + " found at index = "
                           +Arrays.binarySearch(charArr,charKey)); 
        System.out.println(intKey + " found at index = "
                           +Arrays.binarySearch(intArr,intKey)); 
        System.out.println(doubleKey + " found at index = "
                           +Arrays.binarySearch(doubleArr,doubleKey)); 
        System.out.println(floatKey + " found at index = "
                           +Arrays.binarySearch(floatArr,floatKey)); 
        System.out.println(shortKey + " found at index = "
                           +Arrays.binarySearch(shortArr,shortKey)); 
	}

}


/***

Binary search - Sorted Array (Library)

Declaration:

public static int binarySearch(data_type arr, data_type key )
where data_type can be any of the primitive data types: byte, char, double, int, float, short, long and Object as well.

Description:

The array must be sorted (as by the Arrays.sort() method) prior to making this call.If it is not sorted, the results are undefined. If the array contains multiple elements with the specified value, there is no guarantee which one will be found.

Parameters:

arr – the array to be searched
key – the value to be searched for

Returns:

index of the search key, if it is contained in the array; otherwise, (-(insertion point) – 1). The insertion point is defined as the point at which the key would be inserted into the array: the index of the first element greater than the key, or a.length if all elements in the array are less than the specified key. Note that this guarantees that the return value will be >= 0 if and only if the key is found.


Important Points:

If input list is not sorted, the results are undefined.
If there are duplicates, there is no guarantee which one will be found.


Source: https://www.geeksforgeeks.org/arrays-binarysearch-java-examples-set-1/
***/