import java.util.*;

class Solution {
	List<List<Integer>> l;
	int[] candidates;
	int target;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		l = new ArrayList<List<Integer>>();
		this.candidates = candidates;
		this.target = target;
		dfs(0, new ArrayList<Integer>(), 0);
		return l;
	}

	public void dfs(int pointer, List<Integer> curr, int total) {
		if (total == target) {
			l.add(curr);
			return;
		}
		if (total > target || pointer == candidates.length)
			return;

		List<Integer> n = new ArrayList<Integer>(curr);
		n.add(candidates[pointer]);
		dfs(pointer, n, total + candidates[pointer]);

		dfs(pointer + 1, curr, total);
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 6, 7 };
		Solution obj = new Solution();
		System.out.println(obj.combinationSum(arr, 7));
	}
}