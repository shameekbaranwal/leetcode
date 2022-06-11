/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	public boolean hasCycle(ListNode head) {
		ListNode currSlow = head;
		ListNode currFast = head;
		while (true) {
			if (currFast == null || currSlow == null || currFast.next == null || currFast.next.next == null)
				break;
			currFast = currFast.next.next;
			currSlow = currSlow.next;
			if (currFast == currSlow)
				return true;
		}
		return false;

	}
}