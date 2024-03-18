package uk.matvey.problems.leet1171;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.ListNode;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            int val = head.val;
            if (val == 0) {
                head = head.next;
                continue;
            }
            list.add(val);
            for (int i = list.size() - 2; i >= 0; i--) {
                val += list.get(i);
                if (val == 0) {
                    list = list.subList(0, i);
                    break;
                }
            }
            head = head.next;
        }
        var dummy = new ListNode(0);
        var next = dummy;
        for (Integer n : list) {
            next.next = new ListNode(n);
            next = next.next;
        }
        return dummy.next;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var head = ListNode.listNode(1, 2, -3, 3, 1);

        var result = new Solution().removeZeroSumSublists(head);

        assertThat(result).isEqualTo(ListNode.listNode(3, 1));
    }

    @Test
    void case2() {
        var head = ListNode.listNode(1, 2, 3, -3, 4);

        var result = new Solution().removeZeroSumSublists(head);

        assertThat(result).isEqualTo(ListNode.listNode(1, 2, 4));
    }

    @Test
    void case3() {
        var head = ListNode.listNode(1, 2, 3, -3, -2);

        var result = new Solution().removeZeroSumSublists(head);

        assertThat(result).isEqualTo(ListNode.listNode(1));
    }
}
