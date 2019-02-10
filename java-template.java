import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	static class HashMapList<T, E> {
		private HashMap<T, ArrayList<E>> map = new HashMap<T, ArrayList<E>>();

		/* Insert item into list as key */
		public void put(T key, E item) {
			if(!map.containsKey(key)) {
				map.put(key, new ArrayList<E>());
			}
			map.get(key).add(item);
		}

		/* Insert list of items at key */
		public void put(T key, ArrayList<E> items) {
			map.put(key, items);
		}

		/* Get list of items at key */
		public ArrayList<E> get(T key) {
			return map.get(key);
		}

		/* Check if hashmaplist contains key */
		public boolean containsKey(T key) {
			return map.containsKey(key);
		}

		/* Check if list at key contains value */
		public boolean containsKeyValue(T key, E value) {
			ArrayList<E> list = get(key);
			if(list == null) return false;
			return list.contains(value);
		}

		/* Get the list of keys */
		public Set<T> keySet() {
			return map.keySet();
		}

		@Override
		public String toString() {
			return map.toString();
		}

	}

	public void printArr(int nums[]) {
        for(int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void print2DArr(int a[][]) {
    	for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    	
	public int gcd(int a, int b) {
        if (b == 0) 
            return a; 
        else
            return gcd(b, a % b); 
    }

    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    public int sieveOfEratosthenes(int n) {
        boolean a[] = new boolean[n];
        for(int i = 2; i < n; i++)
            a[i] = true;
        
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(a[i]) {
                for(int j = i * i; j < n ; j+=i) {
                    a[j] = false;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++)
            if(a[i])
                count++;
        return count;
    } 
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		
		/* Storing values of array in HashMap */
		Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for (int n : nums) {
			hmap.put(n, hmap.getOrDefault(n, 0) + 1); //inefficent over the count technique?
		}

		//Iterate HashMap
		Set set = hmap.entrySet();
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			Map.Entry pair = (Map.Entry) iter.next();
			System.out.println(pair.getKey() + " " + pair.getValue());  
			/* You need to typecast to use
			For example: int x = (Integer) pair.getValue();*/
		}

		for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            //System.out.println("key: " + key + " Value: " + value );
        }
	}
}

/***

TODO: 

1. Goal: 

Implementation:

Running Time:

Space Time: 

***/