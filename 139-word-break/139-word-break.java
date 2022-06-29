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
		dp = new int[len + 1];
		dp[len] = 1;
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

			if (dp[i + 1] == -1)
				continue;

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
}