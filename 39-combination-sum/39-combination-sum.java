
/*
	https://leetcode.com/problems/combination-sum/
*/

import java.util.*;

class Solution {
	// this keeps track of all lists that add up to the key integer.
	Map<Integer, List<List<Integer>>> map;

	List<List<Integer>> combinationSumDP(int targetSum, int[] numbers) {
		// BASE CASE:

		// negative sums cannot be obtained, so the list of lists is empty.
		// picked a linkedlist because only add operations needed, so O(1) complexity
		// for them.
		if (targetSum < 0)
			return new LinkedList<List<Integer>>();

		// 0 sum can be obtained in only one way - by not picking any number from the
		// numbers array.
		// So a list containing one empty list is returned.
		if (targetSum == 0) {
			List<List<Integer>> l = new LinkedList<List<Integer>>();
			l.add(new LinkedList<Integer>());
			return l;
		}

		// If a subtree has been entirely traversed and calculated already, just return
		// the calculated lists.
		if (map.containsKey(targetSum))
			return map.get(targetSum);

		// RECURSIVE CASE:

		// to contain all the valid lists that add up to targetSum
		List<List<Integer>> listsAddingToTarget = new LinkedList<List<Integer>>();

		for (int num : numbers) {
			// l contains the valid lists that add up to the value (targetSum - num)
			List<List<Integer>> l = combinationSumDP(targetSum - num, numbers);

			// keep a track of this
			map.put(targetSum - num, deepClone(l));

			// for all of these lists adding to (targetSum - num) value, if we append (num)
			// to them, then all of them also add up to targetSum.
			for (List<Integer> subList : l) {
				subList.add(num);
				listsAddingToTarget.add(subList);
			}

		}

		map.put(targetSum, deepClone(listsAddingToTarget));

		return listsAddingToTarget;
	}

	List<List<Integer>> combinationSum(int[] numbers, int targetSum) {
		map = new HashMap<Integer, List<List<Integer>>>();

		return removeDuplicates(combinationSumDP(targetSum, numbers));
	}

	// there MUST be an easier way to do this.
	List<List<Integer>> deepClone(List<List<Integer>> l1) {
		List<List<Integer>> l2 = new LinkedList<List<Integer>>();

		Iterator<List<Integer>> i = l1.iterator();
		while (i.hasNext()) {
			List<Integer> l = i.next();
			List<Integer> ll = new LinkedList<Integer>();
			ll.addAll(l);
			l2.add(ll);
		}

		return l2;
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