import java.util.*;

public class BSTIterator {

    private final Queue<Integer> vals = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        traverse(root);
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        vals.offer(node.val);
        traverse(node.right);
    }

    public boolean hasNext() {
        return !vals.isEmpty();
    }

    public int next() {
        return vals.poll();
    }
}

// ~~~ Please don't copy to LeetCode starting from this line\n` +
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
