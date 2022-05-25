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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resultHead = new ListNode();
        ListNode current = resultHead;
        
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        while(list1 != null && list2 != null) {
            ListNode r = new ListNode();
            if (list1.val < list2.val) {
                r = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                r = new ListNode(list2.val);
                list2 = list2.next;
            }
            current.next = r;
            current = current.next;
        }
        
        if (list1 != null)
            current.next = list1;
        if (list2 != null)
            current.next = list2;
        
        return resultHead.next;
    }
}