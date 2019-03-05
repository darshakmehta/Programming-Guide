class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> set = new HashSet<String>(); // To store Unique Email Address
        
        for(String s : emails) {
            String[] arr = s.split("@"); // Split by @ to find the local names and domain name
            String localName = s.split("\\+")[0]; // Split the local name by '+' to ignore the later part after '+'
            
            localName = localName.replace(".", ""); // Replace '.' by "" in the local name
            set.add(localName + "@" + arr[1]); // Join the First part of local name after splitting by '+' and second part of splitting by '@' and dont forget to join them by @
        }
        
        return set.size(); // Number of Unique Email Address
    }
}

/**

Remember:

Line 8: java.util.regex.PatternSyntaxException: Dangling meta character '+' near index 0

*/