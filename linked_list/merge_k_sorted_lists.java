// Source: https://leetcode.com/problems/merge-k-sorted-lists/
// Definition for singly-linked list.

import java.util.ArrayList;
import java.util.List;

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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        while (lists.length > 1) {
            List<ListNode> mergedList = new ArrayList<>();
            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = ((i + 1) < lists.length) ? lists[i + 1] : null;
                ListNode res = mergeSort(l1, l2);
                mergedList.add(res);
            }
            lists = mergedList.toArray(new ListNode[0]);
        }
        return lists[0];
    }

    private ListNode mergeSort(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 == null) {
            tail.next = l2;
        } else {
            tail.next = l1;
        }
        return dummy.next;
    }
}