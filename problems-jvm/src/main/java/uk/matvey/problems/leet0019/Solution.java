package uk.matvey.problems.leet0019;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.ListNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        var dummy = new ListNode(0);
        dummy.next = head;
        var first = dummy;
        var second = dummy;
        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var head = ListNode.listNode(1, 2, 3, 4, 5);

        var result = new Solution().removeNthFromEnd(head, 2);

        assertThat(result).isEqualTo(ListNode.listNode(1, 2, 3, 5));
    }

    @Test
    void case2() {
        var head = ListNode.listNode(1);

        var result = new Solution().removeNthFromEnd(head, 1);

        assertThat(result).isEqualTo(ListNode.listNode());
    }

    @Test
    void case3() {
        var head = ListNode.listNode(1, 2);

        var result = new Solution().removeNthFromEnd(head, 1);

        assertThat(result).isEqualTo(ListNode.listNode(1));
    }
}
