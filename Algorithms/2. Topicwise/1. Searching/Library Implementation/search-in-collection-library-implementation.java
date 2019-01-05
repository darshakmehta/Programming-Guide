import java.lang.*;
import java.io.*;
import java.util.List; 
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.*; 


// A user-defined class to store domains with id and url 
class Domain { 
    private int id; 
    private String url; 
  
    // Constructor 
    public Domain(int id, String url) { 
        this.id = id; 
        this.url = url; 
    } 
  
    public Integer getId() { 
        return Integer.valueOf(id); 
    } 
} 

class Solution {
	public static void main (String[] args) throws java.lang.Exception {
                /*** Searching an int key in a list sorted in ascending order: ***/

                List al = new ArrayList(); 
                al.add(1); 
                al.add(2); 
                al.add(3); 
                al.add(10); 
                al.add(20); 
          
                // 10 is present at index 3. 
                int index = Collections.binarySearch(al, 10); 
                System.out.println(index); 
          
                // 13 is not present. 13 would have been inserted 
                // at position 4. So the function returns (-4-1)  
                // which is -5. 
                index = Collections.binarySearch(al, 15); 
                System.out.println(index); 


                /*** Searching an int key in a list sorted in descending order. ***/

                List al2 = new ArrayList(); 
                al2.add(100); 
                al2.add(50); 
                al2.add(30); 
                al2.add(10); 
                al2.add(2); 
          
                // The last parameter specifies the comparator method 
                // used for sorting. 
                index = Collections.binarySearch(al2, 50,  
                                          Collections.reverseOrder()); 
          
                System.out.println("Found at index " + index); //1


                /*** Searching in a list of user-defined class objects: ***/

  
                // Create a list 
                List<Domain> l = new ArrayList<Domain>(); 
                l.add(new Domain(10, "quiz.geeksforgeeks.org")); 
                l.add(new Domain(20, "practice.geeksforgeeks.org")); 
                l.add(new Domain(30, "code.geeksforgeeks.org")); 
                l.add(new Domain(40, "www.geeksforgeeks.org")); 
  
                Comparator<Domain> c = new Comparator<Domain>() 
                { 
                    public int compare(Domain u1, Domain u2) 
                    { 
                        return u1.getId().compareTo(u2.getId()); 
                    } 
                }; 
  
                // Searching a domain with key value 10. To search 
                // we create an object of domain with key 10. 
                index = Collections.binarySearch(l, 
                                         new Domain(10, null), c); 
                System.out.println("Found at index  " + index);  //0
          
                // Searching an item with key 5 
                index = Collections.binarySearch(l, 
                                         new Domain(5, null), c); 
                System.out.println(index); //-1

        }

}


/***

Binary search - Sorted Collection (Library)

Collections.binarySearch()
java.util.Collections.binarySearch() method is a java.util.Collections class method that returns position of an object in a sorted list.

// Returns index of key in sorted list sorted in
// ascending order
public static int binarySearch(List slist, T key)

// Returns index of key in sorted list sorted in
// order defined by Comparator c.
public static int binarySearch(List slist, T key, Comparator c)

If key is not present, the it returns "(-(insertion point) - 1)". 
The insertion point is defined as the point at which the key 
would be inserted into the list.

The method throws ClassCastException if elements of list are not comparable using the specified comparator, or the search key is not comparable with the elements.

Important Points:

If input list is not sorted, the results are undefined.
If there are duplicates, there is no guarantee which one will be found.
This method runs in log(n) time for a “random access” list like ArrayList. If the specified list does not implement the RandomAccess interface and is large, this method will do an iterator-based binary search that performs O(n) link traversals and O(log n) element comparisons.


Source: https://www.geeksforgeeks.org/collections-binarysearch-java-examples/

***/