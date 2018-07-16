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