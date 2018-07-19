//Write your code here
BigDecimal big[] = new BigDecimal[n];
SortedSet<BigDecimal> set = new SortedSet<BigDecimal>().descendingSet();
for(int i = 0; i < n; i++) {
    big[i] = new BigDecimal(s[i]);
    set.add(big[i]);
}

Iterator<BigDecimal> it = set.iterator();
int j = 0;
while(it.hasNext()) {
    BigDecimal b = it.next();
    s[j++] = b.toString();
}


/* Following logic fails to have the same length of the strings as per input */

//Write your code here
List<BigDecimal> list = new ArrayList<BigDecimal>();
for(int i = 0; i < n; i++) {
    BigDecimal bd = new BigDecimal(s[i]);
    list.add(bd);
}
Collections.sort(list, Collections.reverseOrder());

for(int i = 0; i < list.size(); i++) {
    s[i] = list.get(i).toString();
}

/*** Perfect Solution to avoid distortion of input string; write your own comparator ***/
 
// we are passing the range of element 0, n because array is of size n + 2
Arrays.sort(s, 0, n, new Comparator<String>(){ 
    @Override
    public int compare(String s1, String s2) {
        BigDecimal a = new BigDecimal(s1);
        BigDecimal b = new BigDecimal(s2);
        return b.compareTo(a); //descending order
    }
});