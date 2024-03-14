package uk.matvey.problems.leet0109;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.ListNode;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        var list = toList(head);
        return toBst(list);
    }

    private TreeNode toBst(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        int mid = list.size() / 2;
        var node = new TreeNode(list.get(mid));
        node.left = toBst(list.subList(0, mid));
        node.right = toBst(list.subList(mid + 1, list.size()));
        return node;
    }

    private List<Integer> toList(ListNode head) {
        var list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }
}

class SolutionTest {

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
