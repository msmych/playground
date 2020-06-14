class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var sum = new ListNode(0);
        var next = sum;
        sum.next = next;
        var shift = false;
        while (hasNext(l1, l2, shift)) {
            ListNode listNode1 = l1 != null ? l1 : new ListNode(0);
            ListNode listNode2 = l2 != null ? l2 : new ListNode(0);

            var number = listNode1.val + listNode2.val;
            if (shift) { 
                number++;
            }
            shift = number >= 10;

            l1 = listNode1.next;
            l2 = listNode2.next;

            next.val = number % 10;
            next.next = hasNext(l1, l2, shift) ? new ListNode(0) : null;
            next = next.next;
        }
        return sum;
    }

    private boolean hasNext(ListNode l1, ListNode l2, boolean shift) {
        return l1 != null || l2 != null || shift;
    }

    // java Solution.java "[2,4,3]" "[5,6,4]" "[7,0,8]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String l1 = args[i], l2 = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: l1 = %s, l2 = %s",
                string(new Solution().addTwoNumbers(listNode(l1), listNode(l2))), expected, l1, l2));
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
