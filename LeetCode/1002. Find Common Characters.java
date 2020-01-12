class Solution {
    public List<String> commonChars(String[] A) {
        int[][] arr = new int[A.length][26];
        List<String> result = new ArrayList<String>();
        
        for (int k = 0; k < A.length; k++) {
            for (char c : A[k].toCharArray()) {
                arr[k][c - 'a'] += 1;
            }
        }

        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < A.length; j++) {
                if (arr[j][i] < min) {
                    min = arr[j][i];
                }
            }

            while (min != 0) {
                result.add(((char)('a' + i) + ""));
                min--;
            }
        }
        
        return result;
    }
}

// Ugly Code using Sorting

class Solution {
    public List<String> commonChars(String[] A) {
        int min = Integer.MAX_VALUE;
        List<String> result = new ArrayList<String>();
        int minIndex = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (A[i].length() < min) {
                min = A[i].length();
                minIndex = i;
            }
            
            char[] tempArr = A[i].toCharArray();
            Arrays.sort(tempArr);
            A[i] = new String(tempArr);
        }
        
        for (int j = 0; j < min; j++) {
            
            char c = A[minIndex].charAt(j);
            boolean exists = false;
            
            for (int k = 0; k < A.length; k++) {
                if (k == minIndex) continue;
                exists = true;
                
                for (int i = 0; i < A[k].length(); i++) {
                    if (A[k].charAt(i) != c) {
                        exists = false;
                    } else {
                        char[] cArr = A[k].toCharArray();
                        cArr[i] = '-';
                        A[k] = new String(cArr);
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    break;
                }
            }
            if (exists) {
                result.add(String.valueOf(c));
            }
        }
        return result;
    }
}
