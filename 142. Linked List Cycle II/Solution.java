import java.util.*;

class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        var node = head;
        var nodes = new HashSet<ListNode>();
        nodes.add(node);
        node = node.next;
        while (node != null) {
            if (nodes.contains(node)) {
                return node;
            }
            nodes.add(node);
            node = node.next;
        }
        return null;
    }

}

// ~~~ Please don't copy to LeetCode starting from this line
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
