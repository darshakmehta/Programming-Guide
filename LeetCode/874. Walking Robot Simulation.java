class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        boolean [][]a = new boolean[3001][3001];
        
        for(int i = 0; i < obstacles.length; i++) {
            a[obstacles[i][0]][obstacles[i][1]] = true;
        }
        char c = 'N';
        int j = 0;
        int i = 0;
        for(int k = 0; k < commands.length ; k++) {
            if(commands[k] > 0) {
                int trace = commands[k];
                if(c == 'N') {
                    while(i >= 0 && j >= 0 && trace-- > 0) {
                        if(!a[i][j]) {
                            j++;
                        } else {
                            j--;
                            break;
                        }
                    }
                } else if(c == 'E') {
                    
                    while(i >= 0 && j >= 0 && trace-- > 0) {
                        
                        if(!a[i][j]) {
                            i++;
                        } else {
                            i--;
                            break;
                        }
                    }
                    
                    
                } else if(c == 'S') {
                    while(i >= 0 && j >= 0 && trace-- > 0) {
                        if(!a[i][j]) {
                            j--;
                        } else {
                            j++;
                            break;
                        }
                    }
                } else if(c == 'W') {
                    while(i >= 0 && j >= 0 && trace-- > 0) {
                        if(!a[i][j]) {
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
        }
        return (Math.abs(i * i) + Math.abs(j  * j));
    }
}