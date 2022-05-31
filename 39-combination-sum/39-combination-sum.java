
/*
	https://leetcode.com/problems/combination-sum/
*/

import java.util.*;

class Solution {
	List<List<Integer>> combinationSum(int[] numbers, int targetSum) {
		if (targetSum < 0)
			return new LinkedList<List<Integer>>();
		if (targetSum == 0) {
			List<List<Integer>> l = new LinkedList<List<Integer>>();
			l.add(new LinkedList<Integer>());
			return l;
		}

		List<List<Integer>> listsAddingToTarget = new LinkedList<List<Integer>>();

		for (int num : numbers) {
			List<List<Integer>> l = combinationSum(numbers, targetSum - num);

			for (List<Integer> subList : l) {
				subList.add(num);
				listsAddingToTarget.add(subList);
			}

		}

		return removeDuplicates(listsAddingToTarget);
	}

	List<List<Integer>> removeDuplicates(List<List<Integer>> l1) {
		List<List<Integer>> l2 = new LinkedList<List<Integer>>();
		Map<String, Boolean> m = new HashMap<String, Boolean>();
		Iterator<List<Integer>> i = l1.iterator();
		while (i.hasNext()) {
			List<Integer> l = i.next();
			Collections.sort(l);
			String s = l.toString();
			if (m.containsKey(s))
				continue;

			m.put(s, true);
			l2.add(l);
		}

		return l2;
	}

}