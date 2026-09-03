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
    public void reorderList(ListNode head) {
        ListNode first = head;
        ListNode second = head;

        while (second.next != null && second.next.next != null) {
            first = first.next;
            second = second.next.next;
        }

        second = first.next;
        first.next = null;

        ListNode prev = null;
        ListNode curr = second;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        second = prev;
        first = head;

        // System.out.println("first -> " + first.val);
        // System.out.print("second -> " + second.val);

        while (first != null && second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
}
