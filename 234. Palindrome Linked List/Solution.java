import java.util.*;

class Solution {

    public boolean isPalindrome(ListNode head) {
        var vals = new ArrayList<Integer>();
        var node = head;
        while (node != null) {
            vals.add(node.val);
            node = node.next;
        }
        int i = 0, j = vals.size() - 1;
        while (i <= j) {
            if (!vals.get(i).equals(vals.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // java Solution.java "1->2" "false" "1->2->2->1" "true"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String head = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: head = %s",
                new Solution().isPalindrome(listNode(head)), expected, head));
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
}

// ~~~ Please don't copy to LeetCode starting from this line
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
