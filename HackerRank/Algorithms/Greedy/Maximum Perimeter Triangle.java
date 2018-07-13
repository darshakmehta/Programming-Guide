/*** Solution 1: Correct and inefficient ***/
public class Solution {

    // Complete the maximumPerimeterTriangle function below.
    static int[] maximumPerimeterTriangle(int[] sticks) {
        int answerArray[] = new int[3];
        int deg[] = new int[1];
        Arrays.sort(sticks);
       
        long a1 = 0;
        long a2 = 0;
        long a3 = 0;
        boolean flag = false;
        for(int i = 0; i < sticks.length - 2; i++) {
            long a = sticks[i];
            long b = sticks[i + 1];
            long c = sticks[i + 2];
            if((a + b) > c) {
                long p = a + b + c;
                    a1 = a;
                    a2 = b;
                    a3 = c;  
                    flag =true;
            }
        }
            answerArray[0] = (int) a1;
            answerArray[1] = (int) a2;
            answerArray[2] = (int) a3;
        if(!flag) {
            deg[0] = -1;
            return deg;
        }
        return answerArray;

    }

}

/*** Solution 2: Correct and efficient ***/

public class Solution {

    // Complete the maximumPerimeterTriangle function below.
    static int[] maximumPerimeterTriangle(int[] sticks) {
        int answerArray[] = new int[3];
        int deg[] = new int[1];
        Arrays.sort(sticks);
      
        for(int i = sticks.length - 3; i >= 0; i--) {
            if((sticks[i] + sticks[i + 1]) > sticks[i + 2]) {
                    answerArray[0] = (int) sticks[i];
                    answerArray[1] = (int) sticks[i + 1];
                    answerArray[2] = (int) sticks[i + 2]; 
            return answerArray;
            }
        }
            deg[0] = -1;
            return deg;
   }
}


/***

Solution 1: Correct and inefficient as we are checking for all the values from start of the array.

Solutin 2: Maximum perimeter is possible with maximum sides, so we can traverse from back of the array, and return the first possible set of a,b,c


***/
