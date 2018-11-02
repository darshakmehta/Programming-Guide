class Solution {
    
    List<String> list = new ArrayList<String>();
    
    public void backtrack(StringBuffer sb, int open, int close, int n) {
        if(sb.length() == n * 2) {
            list.add(sb.toString());
            System.out.println(sb.toString()); //Print all the possible solutions
            return;
        }
        
        if(open < n) {
            backtrack(sb.append("("), open + 1, close, n);
            sb.setLength(sb.length() - 1);
        }
        if(close < open) {
            backtrack(sb.append(")"),open, close+1,n);
            sb.setLength(sb.length() - 1);
        }
        
    }
    public List<String> generateParenthesis(int n) {
        
        backtrack(new StringBuffer(""), 0, 0, n);
        return list;
    }
}

/*

It is an application of Catalan Numbers [Catalan numbers are a sequence of natural numbers that occurs in many interesting counting problems]
- Count the number of expressions containing n pairs of parentheses which are correctly matched. For n = 3, possible expressions are ((())), ()(()), ()()(), (())(), (()()).
- Number of ways to insert n pairs of parentheses in a word of n+1 letters, e.g., for n=2 there are 2 ways: ((ab)c) or (a(bc)). For n=3 there are 5 ways, ((ab)(cd)), (((ab)c)d), ((a(bc))d), (a((bc)d)), (a(b(cd))).
The first few Catalan numbers for n = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 

Illustration: 

For example: n = 3

((()))
(()())
(())()
()(())
()()()

Algorithm:
1. First we use n open bracket, followed by n close bracket
2. Now when we backtrack, we remove all closed brackets and last open bracket and again fill the string
Therefore,
((())) => (() => (()()) and so on

*/