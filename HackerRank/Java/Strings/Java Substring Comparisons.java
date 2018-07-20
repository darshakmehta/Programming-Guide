    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        char c[] = s.toCharArray();
        String arr[] = new String[c.length]; //temporary array
        int j = 0; //counter
        for(int i = 0; i <= c.length - k; i++) {
            arr[j++] = s.substring(i, i + k);
        }
        
        smallest = arr[0];
        largest = arr[0];
        for(int i = 1; i < j; i++) {
                if(smallest.compareTo(arr[i]) > 0) {
                    smallest = arr[i];
                }
                if(largest.compareTo(arr[i]) < 0) {
                    largest = arr[i];
                }
        }
        return smallest + "\n" + largest;
    }