class Solution {
	public static void main(String[] args) {
		String text = "abxabcabcaby";
		String pattern = "abcaby";
		char[] patternArr = pattern.toCharArray();
		char[] textArr = text.toCharArray();

		int p = pattern.length();

		int[] patternDp = new int[p];
		patternDp[0] = 0;

		for ( int i = 1, j = 0; i < p; ) {
			if ( patternArr[i] == patternArr[j] ) {
				patternDp[i] = j + 1;
				j++;
				i++;
			} else {
				if (j != 0) {
					j = patternDp[j - 1];
				} else {
					patternDp[i] = 0;
					i++;
				}
			}
		}

		int i = 0;
		int j = 0;
		while ( i < textArr.length && j < patternArr.length ) {
			if ( textArr[i] == patternArr[j] ) {
				i++; j++;
			} else {
				if ( j != 0 ) {
					j = patternDp[j - 1];
				} else {
					i++;
				}
			}
		}

		if ( j == patternArr.length )	
			System.out.println(true);
		else
			System.out.println(false);

	}
}