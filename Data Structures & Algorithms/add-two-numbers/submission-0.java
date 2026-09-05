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
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode curr1 = l1;
        ListNode curr2 = l2;

        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (curr1 != null && curr2 != null) {
            int sum = curr1.val + curr2.val + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);      
            curr = curr.next;
            curr1 = curr1.next;
            curr2 = curr2.next;      
        }

        while (curr2 != null) {
            int sum = curr2.val + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr2 = curr2.next;
            curr = curr.next;
        }

        while (curr1 != null) {
            int sum = curr1.val + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr1 = curr1.next;
            curr = curr.next;
        }

        if (carry != 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }

    // private ListNode reverseNode(ListNode node) {
    //     ListNode prev = null;
    //     ListNode curr = node;
    //     while (curr != null) {
    //         ListNode temp = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = temp;
    //     }

    //     return prev;
    // }
}
