class Solution {
    public int minIncrementForUnique(int[] A) {
        if(A == null || A.length == 0) return 0;
        
        Set<Integer> set = new HashSet<Integer>();
        Arrays.sort(A);
        //for(int i : A) System.out.print(i + " ");
        boolean[] flag = new boolean[40001];
        for(int i : A) set.add(i);
        
        int count = 0;
        
        for(int i = 0; i < A.length; i++) {
            if(set.contains(A[i]) && !flag[A[i]]) {
                flag[A[i]] = true;
                if(A[i] > 39000)
                System.out.println(A[i] + " Answer is " + A[i]);
            } else {
                int j = 0;
                for(j = A[i] + 1; j <= 40000; j++) {
                    if(!set.contains(j) && !flag[j]) {
                        count += j - A[i];
                        flag[j] = true;
                        break;
                    }
                }
                if(j > 39000)
                System.out.println(A[i] + " Answer is " + j);
            }
            
            
        }
        return count;
        
    }
}