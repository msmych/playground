import java.util.*;

class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        var list = new ArrayList<ListNode>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        for (var i = 0; i <= (n - m) / 2; i++) {
            var node = list.get(m - 1 + i);
            list.set(m - 1 + i, list.get(n - 1 - i));
            list.set(n - 1 - i, node);
        }
        return toListNode(list);
    }

    private ListNode toListNode(List<ListNode> list) {
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

    // java Solution.java "1->2->3->4->5" "2" "4" "1->4->3->2->5"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String head = args[i], m = args[i + 1], n = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: head = %s, m = %s, n = %s",
                string(new Solution().reverseBetween(listNode(head), Integer.parseInt(m), Integer.parseInt(n))), expected, head, m, n));
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
