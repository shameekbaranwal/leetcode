class Solution {
	public int distributeCandies(int[] candyType) {
		List<Integer> list = new ArrayList<Integer>(candyType.length);
		for (int i : candyType)
			list.add(i);

		return Math.min((new HashSet<Integer>(list)).size(), candyType.length / 2);
	}

}