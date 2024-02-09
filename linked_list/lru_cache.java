
// Source: https://leetcode.com/problems/lru-cache/
import java.util.HashMap;

// Definition for a Node.
class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    ListNode() {
    }

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }

    ListNode(int key, int val, ListNode next, ListNode prev) {
        this.key = key;
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class LRUCache {
    HashMap<Integer, ListNode> cache = new HashMap<Integer, ListNode>();
    int cap = 0;
    ListNode left = new ListNode(0, 0);
    ListNode right = new ListNode(0, 0);

    public LRUCache(int capacity) {
        cap = capacity;

        left.next = right;
        right.prev = left;
    }

    // remove the node from the list
    private void remove(ListNode node) {
        ListNode pre = node.prev;
        ListNode nxt = node.next;
        pre.next = nxt;
        nxt.prev = pre;
    }

    // insert the node at the end of the list
    private void insert(ListNode node) {
        ListNode pre = right.prev;
        ListNode nxt = right;
        pre.next = node;
        nxt.prev = node;
        node.prev = pre;
        node.next = nxt;
    }

    public int get(int key) {
        ListNode node = cache.get(key);
        if (node != null) {
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        ListNode node = new ListNode(key, value);
        ListNode prev_node = cache.put(key, node);
        if (prev_node != null) {
            remove(prev_node);
        }
        insert(node);

        if (cap < cache.size()) {
            ListNode lft = left.next;
            remove(lft);
            cache.remove(lft.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */