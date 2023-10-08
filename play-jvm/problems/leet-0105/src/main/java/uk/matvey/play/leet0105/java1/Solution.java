package uk.matvey.play.leet0105.java1;

import uk.matvey.play.types.TreeNode;

import java.util.Arrays;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int rootValue = preorder[0], rootIndex = -1;
        for (var i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }
        var nextPreorder = Arrays.copyOfRange(preorder, 1, preorder.length);
        if (rootIndex == -1) {
            return buildTree(nextPreorder, inorder);
        }
        var node = new TreeNode(rootValue);
        node.left = buildTree(nextPreorder, Arrays.copyOf(inorder, rootIndex));
        node.right = buildTree(nextPreorder, Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length));
        return node;
    }

}
