class Solution
{
    String printSequence(String S)
    {
        Map<Character, String> locationMap = new HashMap<Character, String>();

        locationMap.put('A', "2");
        locationMap.put('B', "22");
        locationMap.put('C', "222");

        locationMap.put('D', "3");
        locationMap.put('E', "33");
        locationMap.put('F', "333");

        locationMap.put('G', "4");
        locationMap.put('H', "44");
        locationMap.put('I', "444");

        locationMap.put('J', "5");
        locationMap.put('K', "55");
        locationMap.put('L', "555");

        locationMap.put('M', "6");
        locationMap.put('N', "66");
        locationMap.put('O', "666");

        locationMap.put('P', "7");
        locationMap.put('Q', "77");
        locationMap.put('R', "777");
        locationMap.put('S', "7777");

        locationMap.put('T', "8");
        locationMap.put('U', "88");
        locationMap.put('V', "888");

        locationMap.put('W', "9");
        locationMap.put('X', "99");
        locationMap.put('Y', "999");
        locationMap.put('Z', "9999");

        locationMap.put(' ', "0");

        StringBuilder result = new StringBuilder();
        char[] arr = S.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            result.append(locationMap.get(arr[i]));
        }
        return result.toString();
    }
}
