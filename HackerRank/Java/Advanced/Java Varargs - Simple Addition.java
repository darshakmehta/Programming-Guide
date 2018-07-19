class Add {
    public void add(int ...a) {
        StringBuilder sb = new StringBuilder("");
        int sum = 0;
        for(int i : a) {
            sb.append(i + "+");
            sum+=i;
        }
        int x = sb.lastIndexOf("+");
        sb.deleteCharAt(x);
        sb.append("="+sum);
        System.out.println(sb.toString());
    }   
} 