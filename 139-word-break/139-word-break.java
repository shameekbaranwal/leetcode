import java.util.*;

class Solution {
	HashSet<String> set;
	String s;
	int len;
	int dp[];

	public boolean wordBreak(String s, List<String> wordDict) {
		set = new HashSet<>(wordDict);
		this.s = s;
		this.len = s.length();
		dp = new int[len];
		return wordBreakRecursive(0);
	}

	public boolean wordBreakRecursive(int index) {
		if (index == len)
			return true;

		if (dp[index] != 0)
			return dp[index] == 1 ? true : false;

		StringBuilder substr = new StringBuilder("");
		for (int i = index; i < len; i++) {
			substr.append(s.charAt(i));
			if (dp[i] == 1) {
				dp[index] = 1;
				return true;
			}
			if (set.contains(substr.toString())) {
				if (wordBreakRecursive(i + 1)) {
					dp[index] = 1;
					return true;
				}
			}
		}

		dp[index] = -1;
		return false;
	}

	public static void check(boolean actual, boolean expected, int tc) {
		System.out.print("TEST CASE " + tc + "  - ");
		System.out.println(expected == actual ? "PASSED (" + actual + ")"
				: "FAILED\nExpected: " + expected + "\nActual: " + actual);
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		check(obj.wordBreak("applepenapple", List.of("apple", "pen")), true, 1);
		check(obj.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")), false, 2);
	}
}