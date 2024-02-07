// Source: https://leetcode.com/problems/add-two-numbers/
// Definition for singly-linked list.
// piblic class ListNode {
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0, null);
        ListNode dummy = res;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int carry = 0;
        int temp = 0;

        while (cur1 != null || cur2 != null) {
            temp = (cur1 != null ? cur1.val : 0) + (cur2 != null ? cur2.val : 0);
            temp = temp + carry;
            carry = temp / 10;
            dummy.next = new ListNode(temp % 10, null);
            cur1 = cur1 != null ? cur1.next : null;
            cur2 = cur2 != null ? cur2.next : null;
            dummy = dummy.next;
        }
        if (carry > 0) {
            dummy.next = new ListNode(carry, null);
        }
        return res.next;
    }
}