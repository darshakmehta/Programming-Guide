class Solution {
    public int binaryGap(int n) {
        Stack<Integer> stack = new Stack<Integer>();
        while(n != 0) {
            stack.push(n%2);
            n = n/2;
        }
        int a[] = new int[stack.size()];
        int i = 0;
        
        while(!stack.isEmpty()) {
            a[i++] = stack.pop();
        }
        for(i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        int count = -1;
        int result = 0;
        for(i = 0; i < a.length; i++) {
            if(a[i] == 1) {
                count = 0;
                for(int j = i + 1; j < a.length; j++) {
                    if(a[j] != 0) {
                        result = Math.max(result, ++count);
                        break;
                    }
                    count++;
                }
            } 
        }
        return result;
    }
}