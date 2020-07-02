class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        var dummy = new ListNode(0);
        dummy.next = head;
        var first = dummy;
        var second = dummy;
        for (var i = 0; i < n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    // java Solution.java "1->2->3->4->5" "2" "1->2->3->5"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String head = args[i], n = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: head = %s, n = %s",
                string(new Solution().removeNthFromEnd(listNode(head), Integer.parseInt(n))), expected, head, n));
        }
    }

    private static ListNode listNode(String s) {
        if (s.equals("null")) return null;
        String[] elements = s.replace("[", "").replace("]", "").replaceAll("->", ",").split(",");
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        for (String element : elements) {
            node.next = new ListNode(Integer.parseInt(element));
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
