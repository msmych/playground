import java.util.*;

class Solution {

    private int distance;
    private int good = 0;

    public int countPairs(TreeNode root, int distance) {
        this.distance = distance; 
        nextGood(root, 0);
        return good;
    }

    private Map<Integer, Integer> nextGood(TreeNode node, int level) {
        if (node == null) {
            return new HashMap<>();
        }
        if (node.left == null && node.right == null) {
            var leafs = new HashMap<Integer, Integer>();
            leafs.put(level, 1);
            return leafs;
        }
        var left = nextGood(node.left, level + 1);
        var right = nextGood(node.right, level + 1);
        for (var leftLeaf : left.entrySet()) {
            for (var rightLeaf : right.entrySet()) {
                if (leftLeaf.getKey() - level + rightLeaf.getKey() - level <= distance) {
                    good += leftLeaf.getValue() * rightLeaf.getValue();
                }
            }
        }
        for (var rightLeaf : right.entrySet()) {
            left.merge(rightLeaf.getKey(), rightLeaf.getValue(), Integer::sum);
        }
        return left;
    }

    // java Solution.java "[1,2,3,null,4]" "3" "1" "[1,2,3,4,5,6,7]" "3" "2" "[7,1,4,6,null,5,3,null,null,null,null,null,2]" "3" "1" "[100]" "1" "0" "[1,1,1]" "2" "1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String root = args[i], distance = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s, distance = %s",
                new Solution().countPairs(treeNode(root), Integer.parseInt(distance)), expected, root, distance));
        }
    }

    private static TreeNode treeNode(String s) {
        s = s.replace("[", "").replace("]", "").replaceAll(" ", "");
        if (s.isEmpty()) return null;
        String[] elements = s.split(",");
        TreeNode[] nodes  = new TreeNode[elements.length];
        Stack<TreeNode> stack = new Stack<>();
        for (int i = elements.length - 1, n = 0; i >= 0; i--, n++) {
            TreeNode node = (elements[i].equals("null")) ? null : new TreeNode(Integer.parseInt(elements[i]));
            nodes[elements.length - n - 1] = node;
            stack.push(node);
        }
        TreeNode root = stack.pop();
        for (TreeNode node : nodes) {
            if (node != null) {
                if (!stack.empty()) node.left = stack.pop();
                if (!stack.empty()) node.right = stack.pop();
            }
        }
        return root;
    }
}

// ~~~ Please don't copy to LeetCode starting from this line
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
