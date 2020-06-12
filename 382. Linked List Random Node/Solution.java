import java.util.*;

import static java.util.stream.IntStream.*;
import static java.util.stream.Collectors.*;

class Solution {

    private final ListNode head;
    private final int length;
    private final Random random = new Random();

    public Solution(ListNode head) {
        this.head = head;
        var n = 1;
        for (var node = head.next; node != null; n++) {
            node = node.next;
        }
        length = n;
    }
    
    public int getRandom() {
        var n = random.nextInt(length);
        if (n == 0) {
            return head.val;
        }
        if (n == 1) {
            return head.next.val;
        } 
        var node = head.next;
        for (; n > 1; n--) {
            node = node.next;
        }
        return node.val;
    }

    public static void main(String... args) {
        var solution = new Solution(listNode("[1,2,3]"));
        System.out.println(generate(solution::getRandom).limit(1000).boxed().collect(groupingBy(n -> n, summingInt(n -> 1))));
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
}

// ~~~ Please don't copy to LeetCode starting from this line
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
