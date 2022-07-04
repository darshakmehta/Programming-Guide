class Solution{
    public String removeConsecutiveCharacter(String s){
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        sb.append(arr[0]);

        for (int i = 1; i < s.length(); i++) {
            if (arr[i] != arr[i - 1]) {
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }
}
