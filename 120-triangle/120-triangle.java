import java.util.*;

class Solution {
	static List<List<Integer>> triangle;
	static int rows;
	static Map<String, Integer> map;

	public static int minimumTotal(List<List<Integer>> tr) {
		triangle = tr;
		rows = tr.size();
		map = new HashMap<>();
		return minTot(0, 0);
	}

	public static String key(int row, int index) {
		return row + "," + index;
	}

	public static int minTot(int row, int index) {
		if (row == rows)
			return 0;

		if (map.containsKey(key(row, index)))
			return map.get(key(row, index));

		int s1 = 0;
		int s2 = 0;

		if (map.containsKey(key(row + 1, index)))
			s1 = map.get(key(row + 1, index));
		else
			s1 = minTot(row + 1, index);

		if (map.containsKey(key(row + 1, index + 1)))
			s2 = map.get(key(row + 1, index + 1));
		else
			s2 = minTot(row + 1, index + 1);

		map.put(key(row, index), triangle.get(row).get(index) + Math.min(s1, s2));
		return map.get(key(row, index));
	}

	public static void assertEquals(

			int actual,
			int expected,
			int tc) {
		System.out.print("TEST CASE " + tc + "  - ");
		System.out.println(expected == actual ? "PASSED (" + actual + ")"
				: "FAILED\nExpected: " + expected + "\nActual: " + actual);
	}

	public static void main(String[] args) {
		assertEquals(minimumTotal(List.of(List.of(2), List.of(3, 4), List.of(6, 5,
				7),
				List.of(4, 1, 8, 3))), 11, 1);
		assertEquals(minimumTotal(List.of(List.of(-10))), -10, 2);
	}
}