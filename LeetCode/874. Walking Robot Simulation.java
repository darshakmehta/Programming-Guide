class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<String>();
        
        for(int i = 0; i < obstacles.length; i++) {
            String s = obstacles[i][0] + "," + obstacles[i][1];
            set.add(s);
        }
        int result = Integer.MIN_VALUE;
        char c = 'N';
        int j = 0;
        int i = 0;
        for(int k = 0; k < commands.length ; k++) {
            if(commands[k] > 0) {
                int trace = commands[k];
                if(c == 'N') {
                    while(trace-- > 0) {
                        String s = i + "," + j;
                        if(!set.contains(s)) {
                            j++;
                        } else {
                            j--;
                            break;
                        }
                    }
                } else if(c == 'E') {
                    while(trace-- > 0) {
                        String s = i + "," + j;
                        if(!set.contains(s)) {
                            i++;
                        } else {
                            i--;
                            break;
                        }
                    }
                    
                } else if(c == 'S') {
                    while(trace-- > 0) {
                        String s = i + "," + j;
                        if(!set.contains(s)) {
                            j--;
                        } else {
                            j++;
                            break;
                        }
                    }
                } else if(c == 'W') {
                    while(trace-- > 0) {
                        String s = i + "," + j;
                        if(!set.contains(s)) {
                            i--;
                        } else {
                            i++;
                            break;
                        }
                    }
                }
            } else if(commands[k] == -1) {
                if(c == 'N')
                    c = 'E';
                else if(c == 'E')
                    c = 'S';
                else if(c == 'S')
                    c = 'W';
                else if(c == 'W')
                    c = 'N';     
            } else if(commands[k] == -2) {
                if(c == 'N')
                    c = 'W';
                else if(c == 'W')
                    c = 'S';
                else if(c == 'S')
                    c = 'E';
                else if(c == 'E')
                    c = 'N';  
            }
            
            result = Math.max(result, Math.abs(i * i) + Math.abs(j  * j));
        }
        return result;
    }
}