class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<String>(); //To store Unique Email Address
          
        for(String s : emails) {
            String str[] = s.split("@"); //Split by @ to find the local names
            String r = str[0].replace(".",""); //Replace '.' by "" in the local name
            String arr[] = r.split("\\+"); // Split the local name by '+' to ignore the later part after '+'

            String newstring = arr[0]+"@"+str[1]; 
            // Join the First part of local name after splitting by '+' and second part of splitting by '@' and dont forget to join them by @
            
            if(!set.contains(newstring)) // check if set does not contain
                set.add(newstring);
        }
        return set.size(); //Number of Unique Email Address
    }
}