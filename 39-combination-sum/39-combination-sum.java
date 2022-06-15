import java.util.*;

class Solution {
	List<List<Integer>> l;
	int[] candidates;
	int target;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		this.l = new ArrayList<List<Integer>>();
		this.candidates = candidates;
		this.target = target;
		dfs(0, new ArrayList<Integer>(), 0);
		return l;
	}

	public void dfs(int pointer, List<Integer> curr, int total) {
		if (total == target) {
			List<Integer> n = new ArrayList<>(curr);
			l.add(n);
			return;
		}
		if (total > target || pointer == candidates.length) {
			return;
		}

		curr.add(candidates[pointer]);
		dfs(pointer, curr, total + candidates[pointer]);

		curr.remove(curr.size() - 1);
		dfs(pointer + 1, curr, total);
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 6, 7 };
		Solution obj = new Solution();
		System.out.println(obj.combinationSum(arr, 7));
	}
}