package uk.matvey.play.leet1367.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.ListNode;
import uk.matvey.play.types.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var head = ListNode.listNode(4, 2, 8);
        var root = TreeNode.treeNode(1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3);

        final var result = new Solution().isSubPath(head, root);

        assertThat(result).isTrue();
    }

    @Test
    public void case2() {
        var head = ListNode.listNode(1, 4, 2, 6);
        var root = TreeNode.treeNode(1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3);

        final var result = new Solution().isSubPath(head, root);

        assertThat(result).isTrue();
    }

    @Test
    public void case3() {
        var head = ListNode.listNode(1, 4, 2, 6, 8);
        var root = TreeNode.treeNode(1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3);

        final var result = new Solution().isSubPath(head, root);

        assertThat(result).isFalse();
    }
}
