package uk.matvey.problems.leet0206;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.ListNode;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        var node = head;
        while (node != null) {
            var next = node.next;
            node.next = previous;
            previous = node;
            node = next;
        }
        return previous;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var head = ListNode.listNode(1, 2, 3, 4, 5);

        var result = new Solution().reverseList(head);

        assertThat(result).isEqualTo(ListNode.listNode(5, 4, 3, 2, 1));
    }
}
