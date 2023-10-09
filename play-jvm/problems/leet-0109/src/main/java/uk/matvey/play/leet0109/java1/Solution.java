package uk.matvey.play.leet0109.java1;

import uk.matvey.play.types.ListNode;
import uk.matvey.play.types.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
