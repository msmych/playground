package uk.matvey.problems.leet1367;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.ListNode;
import uk.matvey.problems.leet.TreeNode;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private ListNode head;

    public boolean isSubPath(ListNode head, TreeNode root) {
        this.head = head;
        return isNextSubPath(root, Set.of(head));
    }

    private boolean isNextSubPath(TreeNode node, Set<ListNode> listNodes) {
        if (node == null) {
            return false;
        }
        var nextListNodes = listNodes.stream()
            .filter(listNode -> listNode.val == node.val)
            .map(listNode -> listNode.next)
            .collect(Collectors.toSet());
        if (nextListNodes.stream().anyMatch(Objects::isNull)) {
            return true;
        }
        nextListNodes = nextListNodes.stream()
            .filter(Objects::nonNull)
            .collect(Collectors.toSet());
        nextListNodes.add(head);
        return isNextSubPath(node.left, nextListNodes) || isNextSubPath(node.right, nextListNodes);
    }
}

class SolutionTest {

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
