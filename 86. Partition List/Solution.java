class Solution {

    public ListNode partition(ListNode head, int x) {
        var dummyHead = new ListNode(0);
        dummyHead.next = new ListNode(0);
        var nextHead = dummyHead.next;
        var dummyTail = new ListNode(0);
        dummyTail.next = new ListNode(0);
        var nextTail = dummyTail.next;
        while (head != null) {
            if (head.val < x) {
                nextHead.next = head;
                nextHead = nextHead.next;
            } else {
                nextTail.next = head;
                nextTail = nextTail.next;
            }
            head = head.next;
        }
        nextTail.next = null;
        nextHead.next = dummyTail.next.next;
        return dummyHead.next.next;
    }

    // java Solution.java "1->4->3->2->5->2" "3" "1->2->2->4->3->5"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String head = args[i], x = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: head = %s, x = %s",
                string(new Solution().partition(listNode(head), Integer.parseInt(x))), expected, head, x));
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
