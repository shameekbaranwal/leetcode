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
public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || head.next == null)
			return null;

		ListNode nth = head;
		for (int i = 0; i < n; i++)
			nth = nth.next;

		if (nth == null)
			return head.next;

		ListNode nlast = head;
		while (nth.next != null) {
			nth = nth.next;
			nlast = nlast.next;
		}
		nlast.next = nlast.next.next;

		return head;
	}

}