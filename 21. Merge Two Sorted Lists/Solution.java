class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        var dummy = new ListNode(0);
        if (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                dummy.next.next = mergeTwoLists(l1.next, l2);
            } else {
                dummy.next = l2;
                dummy.next.next = mergeTwoLists(l1, l2.next);
            }
        } else {
            dummy.next = l1 != null ? l1 : l2;
        }
        return dummy.next;
    }

    // java Solution.java "1->2->4" "1->3->4" "1->1->2->3->4->4"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String l1 = args[i], l2 = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: l1 = %s, l2 = %s",
                string(new Solution().mergeTwoLists(listNode(l1), listNode(l2))), expected, l1, l2));
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
