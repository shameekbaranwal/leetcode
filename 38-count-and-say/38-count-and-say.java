class Solution {
	public String countAndSay(int n) {
		if (n == 1)
			return "1";

		String prev = countAndSay(n - 1);
		return say(prev);
	}

	public String say(String s) {
		int len = s.length();
		String result = "";
		int current = s.charAt(0) - '0', count = 1;

		if (len == 1)
			return (count + "" + current);

		for (int i = 1; i < len; i++) {
			int num = s.charAt(i) - '0';

			if (i == s.length() - 1) {
				if (num != current) {
					result += (count + "" + current);
					count = 1;
					current = num;
				} else
					count++;
				result += (count + "" + current);
				break;
			}

			if (num != current) {
				result += (count + "" + current);
				current = num;
				count = 0;
			}
			count++;
		}

		return result;

	}
}