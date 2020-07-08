import java.util.*;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        var valsQueue = new LinkedList<Stack<Integer>>();
        var node = head;
        while (hasNextK(node, k)) {
            var vals = new Stack<Integer>();
            for (var i = 0; i < k; i++) {
                vals.push(node.val);
                node = node.next;
            }
            valsQueue.offer(vals);
        }
        var tail = new LinkedList<Integer>();
        while (node != null) {
            tail.offer(node.val);
            node = node.next;
        }
        var dummy = new ListNode(0);
        var reversed = dummy;
        while (!valsQueue.isEmpty()) {
            var vals = valsQueue.poll();
            while (!vals.isEmpty()) {
                reversed.next = new ListNode(vals.peek());
                vals.pop();
                reversed = reversed.next;
            }
        }
        while (!tail.isEmpty()) {
            reversed.next = new ListNode(tail.poll());
            reversed = reversed.next;
        }
        return dummy.next;
    }

    private boolean hasNextK(ListNode head, int k) {
        var node = head;
        var count = 0;
        while (node != null) {
            count++;
            if (count >= k) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    // java Solution.java "1->2->3->4->5" "2" "2->1->4->3->5" "1->2->3->4->5" "3" "3->2->1->4->5"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String head = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: head = %s, k = %s",
                string(new Solution().reverseKGroup(listNode(head), Integer.parseInt(k))), expected, head, k));
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
