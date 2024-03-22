package uk.matvey.problems.leet0234;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.ListNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

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
}

class SolutionTest {

    @Test
    void case1() {
        assertThat(new Solution().isPalindrome(ListNode.listNode(1, 2))).isFalse();
    }

    @Test
    void case2() {
        assertThat(new Solution().isPalindrome(ListNode.listNode(1, 2, 2, 1))).isTrue();
    }
}
