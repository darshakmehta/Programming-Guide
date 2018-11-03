/* Given word1 and word2 in the words list, find the shortest distance between these two words */
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {

    	int i = -1;
    	int j = -1;
    	int min = Integer.MAX_VALUE;
    	for(int k = 0; k < words.length; k++) {
    		if(words[k].equals(word1)) {
    			if(j != -1 && i == -1) {
    				min = k - j;
    			} else {
    				min = Math.min(min, k - j)
    			}
    			i = k;
    		} else if(words[k].equals(word2)) {
    			if(j == -1 && i != -1) {
    				min = k - i;
    			} else {
    				min = Math.min(min, k - i);
    			}
    			j = k;
    		}
    	}
    	return min;
    }
}

/* easy to understand but little inefficent since we check minimum condition for all words in the list, we can improve by writing the minimum condition block inside the if and else if to drastically improve the efficiency */
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int i = -1, j = -1;
        int min = Integer.MAX_VALUE;
        for(int k = 0; k < words.length; i++) {
            if(words[k].equals(word1)) i = k;
            else if(words[k].equals(word1)) j = k;
            if(i != -1 && j != -1)
                min = Math.min(min, Math.abs(i - j));
        }
    }
}

/* Efficient Solution than the previous one */
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int i = -1, j = -1;
        int min = Integer.MAX_VALUE;
        for(int k = 0; k < words.length; i++) {
            if(words[k].equals(word1)) {
                i = k;
                if(i != -1 && j != -1)
                    min = Math.min(min, Math.abs(i - j));
            }
            else if(words[k].equals(word1)) {
                j = k;
                if(i != -1 && j != -1)
                    min = Math.min(min, Math.abs(i - j));
            }
        }
    }
}

/***



**/