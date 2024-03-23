package uk.matvey.problems.leet0143;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.ListNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        var nodes = new ArrayList<ListNode>();
        var dummy = new ListNode(0);
        dummy.next = head;
        var node = dummy.next;
        while (node != null) {
            nodes.add(node);
            node = node.next;
        }
        node = dummy.next;
        for (int i = 1; i < nodes.size(); i++) {
            if ((i & 1) == 0) {
                node.next = nodes.get(i / 2);
            } else {
                node.next = nodes.get(nodes.size() - i / 2 - 1);
            }
            node = node.next;
        }
        node.next = null;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var head = ListNode.listNode(1, 2, 3, 4);

        new Solution().reorderList(head);

        assertThat(head).isEqualTo(ListNode.listNode(1, 4, 2, 3));
    }

    @Test
    void case2() {
        var head = ListNode.listNode(1, 2, 3, 4, 5);

        new Solution().reorderList(head);

        assertThat(head).isEqualTo(ListNode.listNode(1, 5, 2, 4, 3));
    }
}