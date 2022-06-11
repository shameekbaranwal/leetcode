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
	public ListNode deleteMiddle(ListNode head) {
		if (head == null || head.next == null)
			return null;

		if (head.next.next == null) {
			head.next = null;
			return head;
		}

		ListNode current = head.next.next;
		ListNode midPrev = head;
		boolean f = true;

		while (current != null) {
			f = !f;
			current = current.next;

			if (f) 
				midPrev = midPrev.next;
			
		}

		midPrev.next = midPrev.next.next;
		return head;
	}
}