import java.util.*;

class Solution {

    public ListNode removeElements(ListNode head, int val) {
        return toHead(toListExcludingValue(head, val));
    }

    private List<ListNode> toListExcludingValue(ListNode node, int val) {
        var nodes = new ArrayList<ListNode>();
        while (node != null) {
            if (node.val != val) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    private ListNode toHead(List<ListNode> list) {
        if (list.isEmpty()) {
            return null;
        }
        var node = list.get(0);
        for (var i = 0; i < list.size(); i++) {
            var n = node;
            for (var j = 1; j < i; j++) {
                n = n.next;
            }
            n.next = list.get(i);
            n.next.next = null;
        }
        return node;
    }

    // java Solution.java "1->2->6->3->4->5->6" "6" "1->2->3->4->5"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String head = args[i], val = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: head = %s, val = %s",
                string(new Solution().removeElements(listNode(head), Integer.parseInt(val))), expected, head, val));
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
