package uk.matvey.problems.leet0019

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import uk.matvey.problems.leet.ListNode

class SolutionTest {

    @Test
    fun case1() {
        val head = ListNode.listNode(1, 2, 3, 4, 5)

        val result = Solution().removeNthFromEnd(head, 2)

        assertThat(result).isEqualTo(ListNode.listNode(1, 2, 3, 5))
    }

    @Test
    fun case2() {
        val head = ListNode.listNode(1)

        val result = Solution().removeNthFromEnd(head, 1)

        assertThat(result).isEqualTo(ListNode.listNode())
    }

    @Test
    fun case3() {
        val head = ListNode.listNode(1, 2)

        val result = Solution().removeNthFromEnd(head, 1)

        assertThat(result).isEqualTo(ListNode.listNode(1))
    }
}