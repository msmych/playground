class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode node = dummy;
            while (true) {
                if (node.next == null) {
                    node.next = new ListNode(head.val);
                    break;
                } else if (head.val <= node.next.val) {
                    ListNode n = node.next;
                    node.next = new ListNode(head.val);
                    node.next.next = n;
                    break;
                }
                node = node.next;
            }
            head = head.next;
        }
        return dummy.next;
    }

    // java Solution.java "4->2->1->3" "1->2->3->4" "-1->5->3->4->0" "-1->0->3->4->5"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String head = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: head = %s",
                string(new Solution().insertionSortList(listNode(head))), expected, head));
        }
    }

    private static ListNode listNode(String s) {
        if (s.equals("null")) return null;
        String[] elements = s.split("->");
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
