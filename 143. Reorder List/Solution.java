import java.util.*;

class Solution {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        var nodes = new ArrayList<ListNode>();
        var dummy = new ListNode(0);
        dummy.next = head;
        var node = dummy.next;
        while (node != null) {
            nodes.add(node);
            node = node.next;
        }
        node = dummy.next;
        for (var i = 1; i < nodes.size(); i++) {
            if ((i & 1) == 0) {
                node.next = nodes.get(i / 2);
            } else {
                node.next = nodes.get(nodes.size() - i / 2 - 1);
            }
            node = node.next;
        }
        node.next = null;
    }

    // java Solution.java "1->2->3->4" "1->4->2->3" "1->2->3->4->5" "1->5->2->4->3"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            var head = listNode(args[i]);
            var expected = args[i + 1];
            new Solution().reorderList(head);
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: head = %s",
                string(head), expected, args[i]));
        }
    }

    private static ListNode listNode(String s) {
        if (s.equals("null")) return null;
        var elements = s.replace("[", "").replace("]", "").replaceAll("->", ",").split(",");
        var dummy = new ListNode(0);
        var node = dummy;
        for (var el : elements) {
            node.next = new ListNode(Integer.parseInt(el));
            node = node.next;
        }
        return dummy.next;
    }

    private static String string(ListNode head) {
        if (head == null) return "null";
        String s = "";
        while (head != null) {
            s += head.val + "->";
            head = head.next;
        }
        return s.substring(0, s.length() - 2);
    }
}

// ~~~ Please don't copy to LeetCode starting from this line
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
