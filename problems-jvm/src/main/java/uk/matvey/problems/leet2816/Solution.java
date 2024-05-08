package uk.matvey.problems.leet2816;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.ListNode;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public ListNode doubleIt(ListNode head) {
        var list = new ArrayList<Integer>();
        var node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        int carry = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int n = list.get(i) * 2 + carry;
            var prev = new ListNode(n % 10);
            prev.next = node;
            node = prev;
            carry = n < 10 ? 0 : 1;
        }
        if (carry > 0) {
            var prev = new ListNode(carry);
            prev.next = node;
            node = prev;
        }
        return node;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var head = ListNode.listNode(1, 8, 9);

        var result = new Solution().doubleIt(head);

        assertThat(result).isEqualTo(ListNode.listNode(3, 7, 8));
    }

    @Test
    void case2() {
        var head = ListNode.listNode(9, 9, 9);

        var result = new Solution().doubleIt(head);

        assertThat(result).isEqualTo(ListNode.listNode(1, 9, 9, 8));
    }
}
