package uk.matvey.play.leet0236.java1;

import uk.matvey.play.types.TreeNode;

public class Solution {
    private int p, q;
    private TreeNode lca;
    private int level = Integer.MAX_VALUE;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p.val;
        this.q = q.val;
        search(root, 0);
        return lca;
    }

    private SearchResult search(TreeNode node, int level) {
        if (node == null) {
            return SearchResult.NONE;
        }
        SearchResult left = search(node.left, level + 1), right = search(node.right, level + 1);
        if (left == SearchResult.PQ || right == SearchResult.PQ) {
            return SearchResult.PQ;
        } else if (left == SearchResult.NONE && right == SearchResult.NONE) {
            if (node.val == p) {
                return SearchResult.P;
            }
            if (node.val == q) {
                return SearchResult.Q;
            }
            return SearchResult.NONE;
        } else if (left == SearchResult.P && right == SearchResult.Q || left == SearchResult.Q && right == SearchResult.P) {
            updateLca(node, level);
            return SearchResult.PQ;
        } else {
            if (node.val == p) {
                if (left == SearchResult.Q || right == SearchResult.Q) {
                    updateLca(node, level);
                    return SearchResult.PQ;
                }
                return SearchResult.P;
            }
            if (node.val == q) {
                if (left == SearchResult.P || right == SearchResult.P) {
                    updateLca(node, level);
                    return SearchResult.PQ;
                }
                return SearchResult.Q;
            }
            return left == SearchResult.NONE ? right : left;
        }
    }

    private void updateLca(TreeNode node, int level) {
        if (level < this.level) {
            lca = node;
            this.level = level;
        }
    }

    private enum SearchResult {NONE, P, Q, PQ}
}
