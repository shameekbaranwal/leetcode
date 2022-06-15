/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	public ListNode swapNodes(ListNode head, int k) {
		ListNode kth = head;
		for (int i = 1; i < k; i++)
			kth = kth.next;

		int val = kth.val;

		ListNode curr = kth;
		ListNode klast = head;
		while (curr.next != null) {
			klast = klast.next;
			curr = curr.next;
		}

		kth.val = klast.val;
		klast.val = val;

		return head;
	}
}