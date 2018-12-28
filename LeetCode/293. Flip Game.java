class Solution {

	public List<String> generatePossibleNextMoves(String s) {
		List<String> result = new ArrayList<String>();
		char[] ch = s.toCharArray();

		for( int i = 0; i < ch.length; i++ ) {
			if( ch[i] == ch[i + 1] && ch[i] == '+' ) {
				ch[i] = '-';
				ch[i + 1] = '-';
				result.add(new String(ch));
				ch[i] = '+';
				ch[i + 1] = '+';
			}
		}

		return result;
	}
}