class Solution {

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            var inserted = new Node(insertVal);
            inserted.next = inserted;
            return inserted;
        }
        var node = head;
        while (true) {
            if (node.next == head) {
                var inserted = new Node(insertVal, head);
                node.next = inserted;
                return head;
            }
            if (insertVal >= node.val && insertVal <= node.next.val || node.val > node.next.val && (insertVal >= node.val || insertVal <= node.next.val)) {
                var inserted = new Node(insertVal, node.next);
                node.next = inserted;
                return head;
            }
            node = node.next;
        }
    }
}

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}
