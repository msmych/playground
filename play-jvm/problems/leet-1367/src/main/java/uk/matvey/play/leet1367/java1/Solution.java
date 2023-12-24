package uk.matvey.play.leet1367.java1;

import uk.matvey.play.types.ListNode;
import uk.matvey.play.types.TreeNode;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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
        Set<ListNode> nextListNodes = listNodes.stream()
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
