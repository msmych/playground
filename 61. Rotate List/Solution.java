class Solution {

    private final ListNode firstDummy = new ListNode(0);
    private final ListNode secondDummy = new ListNode(0);

    private ListNode first = firstDummy;
    private ListNode second = secondDummy;
    
    public ListNode rotateRight(ListNode head, int k) {
        var n = countNodes(head);
        if (n == 0) {
            return null;
        }
        k = k % n;
        head = setSecondGetHead(head, n - k);
        getFirst(head);
        first.next = secondDummy.next;
        return firstDummy.next;
    }
    
    private int countNodes(ListNode head) {
        var node = head;
        var n = 0;
        for (; node != null; n++) {
            node = node.next;
        }
        return n;
    }

    private ListNode setSecondGetHead(ListNode head, int last) {
        for (var i = 0; i < last; i++) {
            second.next = new ListNode(head.val);
            second = second.next;
            head = head.next;
        }
        return head;
    }

    private void getFirst(ListNode head) {
        while (head != null) {
            first.next = new ListNode(head.val);
            first = first.next;
            head = head.next;
        }
    }

    // java Solution.java "1->2->3->4->5" "2" "4->5->1->2->3" "0->1->2" "4" "2->0->1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String head = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: head = %s, k = %s",
                string(new Solution().rotateRight(listNode(head), Integer.parseInt(k))), expected, head, k));
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
