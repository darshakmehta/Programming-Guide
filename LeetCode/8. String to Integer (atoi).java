import java.util.regex.*;
class Solution {
    public int myAtoi(String str) {
        str=str.trim();
        String s="0";
        Pattern p = Pattern.compile("[+-]{0,1}?[0-9]+");
        Matcher m = p.matcher(str);
        
        if(m.find())
        {
            if(m.start()==0)
                s=m.group();            
        }
        try
        {
            return Integer.parseInt(s);
        }
        catch(Exception e)
        {
            if(s.charAt(0)=='-')
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }
    }
}