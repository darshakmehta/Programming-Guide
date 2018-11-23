class Solution {
    
    private  class LogComparator implements Comparator<String> {
        @Override
        public int compare(String log1, String log2) {
            String logOneIdentifier = log1.substring(0, log1.indexOf(" "));
            String logTwoIdentifier = log2.substring(0, log2.indexOf(" "));
            String completeLogWord1 = log1.substring(log1.indexOf(" ") + 1);
            String completeLogWord2 = log2.substring(log2.indexOf(" ") + 1);
            int c = completeLogWord1.compareTo(completeLogWord2);
            if(c != 0) return c;
            return logOneIdentifier.compareTo(logTwoIdentifier);
        }
    }
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<String>();
        List<String> numberLogs = new ArrayList<String>();
        
        for(String log : logs) {
            String[] temp = log.split(" ");
            if(Character.isDigit(temp[1].charAt(0))) {
                numberLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }
    
        Collections.sort(letterLogs, new LogComparator());
        
        String[] result = new String[logs.length];
        int i = 0;
        for(String log : letterLogs) {
            result[i++] = log;
        }
        for(String log : numberLogs) {
            result[i++] = log;
        }
        return result;
    }
}