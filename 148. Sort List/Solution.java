import java.util.*;

import static java.util.Comparator.*;

class Solution {

    public ListNode sortList(ListNode head) {
        var queue = new PriorityQueue<Integer>(naturalOrder());
        while (head != null) {
            queue.offer(head.val);
            head = head.next;
        }
        var dummy = new ListNode(0);
        var node = dummy;
        while (!queue.isEmpty()) {
            node.next = new ListNode(queue.poll());
            node = node.next;
        }
        return dummy.next;
    }

    // java Solution.java "4->2->1->3" "1->2->3->4" "-1->5->3->4->0" "-1->0->3->4->5"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String head = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: head = %s",
                string(new Solution().sortList(listNode(head))), expected, head));
        }
    }

    private static ListNode listNode(String s) {
        if (s.equals("null") || s.equals("[]")) return null;
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
