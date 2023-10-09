package uk.matvey.play.leet0109.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.ListNode;
import uk.matvey.play.types.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var head = ListNode.listNode(-10, -3, 0, 5, 9);

        TreeNode result = new Solution().sortedListToBST(head);

        assertThat(result).isEqualTo(TreeNode.treeNode(0, -3, 9, -10, null, 5));
    }

    @Test
    public void case2() {
        var head = ListNode.listNode();

        TreeNode result = new Solution().sortedListToBST(head);

        assertThat(result).isEqualTo(TreeNode.treeNode());
    }

    @Test
    public void case3() {
        var head = ListNode.listNode(0);

        TreeNode result = new Solution().sortedListToBST(head);

        assertThat(result).isEqualTo(TreeNode.treeNode(0));
    }

    @Test
    public void case4() {
        var head = ListNode.listNode(1, 3);

        TreeNode result = new Solution().sortedListToBST(head);

        assertThat(result).isEqualTo(TreeNode.treeNode(3, 1));
    }
}
