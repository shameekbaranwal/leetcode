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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

		ListNode result = new ListNode();
		ListNode current = new ListNode();
		ListNode zeroNode = new ListNode(0);
		zeroNode.next = zeroNode;

		boolean atFirstNode = true;
        
        if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		while (true) {
			if ((l1 == zeroNode && l2 == zeroNode))
				break;

			int val = l1.val + l2.val + carry;
			int dig = (val % 10);

			carry = val > 9 ? 1 : 0;

			ListNode n = new ListNode(dig);

			if (atFirstNode) {
				result = n;
				atFirstNode = false;
			} else
				current.next = n;

			current = n;
			l1 = l1.next;
			l2 = l2.next;

			if (l1 == null)
				l1 = zeroNode;

			if (l2 == null)
				l2 = zeroNode;
		}

		if (carry == 1) {
			ListNode c = new ListNode(1);
			current.next = c;
		}

		return result;
    }
}