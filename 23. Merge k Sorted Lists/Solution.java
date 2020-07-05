class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        var dummy = new ListNode(0);
        var node = dummy;
        while (notEmpty(lists)) {
            node.next = new ListNode(getMin(lists));
            node = node.next;
        }
        return dummy.next;
    }

    private boolean notEmpty(ListNode[] lists) {
        for (var list : lists)
            if (list != null)
            return true;
        return false;
    }

    private int getMin(ListNode[] lists) {
        int min = Integer.MAX_VALUE, minIndex = 0;
        for (var i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < min) {
                min = lists[i].val;
                minIndex = i;
            }
        }
        lists[minIndex] = lists[minIndex].next;
        return min;
    }

    // java Solution.java "[1->4->5,1->3->4,2->6]" "1->1->2->3->4->4->5->6"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String lists = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: lists = %s",
                string(new Solution().mergeKLists(array(lists))), expected, lists));
        }
    }

    private static ListNode[] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new ListNode[0];
        var elements = s.split(",");
        var arr = new ListNode[elements.length];
        for (var i = 0; i < arr.length; i++) arr[i] = listNode(elements[i]);
        return arr;
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
