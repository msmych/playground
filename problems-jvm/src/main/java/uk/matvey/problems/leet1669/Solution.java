package uk.matvey.problems.leet1669;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.ListNode;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        var dummy = new ListNode(0);
        var node = dummy;
        for (int i = 0; i < a; i++) {
            node.next = new ListNode(list1.val);
            node = node.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            node.next = new ListNode(list2.val);
            node = node.next;
            list2 = list2.next;
        }
        for (int i = a; i < b; i++) {
            list1 = list1.next;
        }
        node.next = list1.next;
        return dummy.next;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var list1 = ListNode.listNode(10, 1, 13, 6, 9, 5);
        var list2 = ListNode.listNode(1000000, 1000001, 1000002);

        ListNode result = new Solution().mergeInBetween(list1, 3, 4, list2);

        assertThat(result).isEqualTo(ListNode.listNode(10, 1, 13, 1000000, 1000001, 1000002, 5));
    }

    @Test
    public void case2() {
        var list1 = ListNode.listNode(0, 1, 2, 3, 4, 5, 6);
        var list2 = ListNode.listNode(1000000, 1000001, 1000002, 1000003, 1000004);

        ListNode result = new Solution().mergeInBetween(list1, 2, 5, list2);

        assertThat(result).isEqualTo(ListNode.listNode(0, 1, 1000000, 1000001, 1000002, 1000003, 1000004, 6));
    }
}
