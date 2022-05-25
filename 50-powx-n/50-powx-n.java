class Solution {
    	public static double myPow(double a, long b) {
		if (a == 1)
			return 1;

		if (b < 0)
			return (1 / myPow(a, -b));

		double result = 1;
		while (b > 0) {
			if (b % 2 == 1)
				result *= a;

			a *= a;
			b /= 2;
		}
		return result;
	}
}