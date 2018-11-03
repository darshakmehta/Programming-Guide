class Solution { //Very Inefficient
    public int[] sortArrayByParity(int[] A) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
            
        for(int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0) {
                queue.addFirst(A[i]);
            } else {
                queue.addLast(A[i]);
            }
        }
        
        for(int i = 0; i < A.length; i++) {
            A[i] = queue.get(i);
        }
        return A;
    }
}

class Solution { //100% Solution
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int left = 0, right = A.length - 1;
        for(int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0) {
                result[left++] = A[i]; 
            } else {
                result[right--] = A[i];
            }
        }
        
        return result;
    }
}

/***

TODO: Inplace 

**/