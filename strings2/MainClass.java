package strings2;

import java.util.Arrays;

public class MainClass {
	
	
	static int longestSubstringDistinctChars(char[] s) {
		int i = 0, j = 0;
		int index[] = new int[256];
		Arrays.fill(index, -1);
		int ans = 0;
		while(j < s.length) {
			int lastPos = index[s[j]];
			boolean isPresent = true;
			if(lastPos == -1 || lastPos < i) {
				isPresent = false;
			}
			if(isPresent) {
				i = lastPos+1;
			}
			int curWindoSize = j-i+1;
			ans = Math.max(ans, curWindoSize);
			index[s[j]] = j;
			j++;
		}
		return ans;
	}
	
	static boolean rotationalStrings(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		String doubleString = s1+s1;
		return doubleString.contains(s2);
	}
	
	static void patternMatching(String s, String p) {
		int n = s.length();
		int m = p.length();
		
//					0123456789
//		String s = "abcabdabdabda";
//		String p = "bda"
//					012
//		
//		i = 7
//		j = 3
//		
		for(int i = 0; i<=n-m; i++) {
			int j = 0;
			for(; j<m; j++) {
				if(s.charAt(i+j) != p.charAt(j)) {
					break;
				}
			}
			if(j == m) {
				System.out.println("pattern found at "+i);
			}
		}
	}
	

	public static void main(String[] args) {
		String s = "abcdcapbbbc";
//		String p = "bda";
		
//		patternMatching(s, p);
		
		System.out.println(longestSubstringDistinctChars(s.toCharArray()));
	}

}
