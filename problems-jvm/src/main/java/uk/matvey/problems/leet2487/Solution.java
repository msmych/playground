package uk.matvey.problems.leet2487;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.ListNode;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public ListNode removeNodes(ListNode head) {
        var list = new ArrayList<Integer>();
        var node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        int i = list.size() - 1;
        int max = list.get(i);
        node = new ListNode(max);
        for (i--; i >= 0; i--) {
            int v = list.get(i);
            if (v >= max) {
                var prev = new ListNode(v);
                prev.next = node;
                node = prev;
            }
            if (v > max) {
                max = v;
            }
        }
        return node;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var head = ListNode.listNode(5, 2, 13, 3, 8);

        var result = new Solution().removeNodes(head);

        assertThat(result).isEqualTo(ListNode.listNode(13, 8));
    }

    @Test
    void case2() {
        var head = ListNode.listNode(1, 1, 1, 1);

        var result = new Solution().removeNodes(head);

        assertThat(result).isEqualTo(ListNode.listNode(1, 1, 1, 1));
    }
}
