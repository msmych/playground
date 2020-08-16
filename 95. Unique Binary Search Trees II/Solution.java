import java.util.*;

import static java.util.stream.IntStream.*;
import static java.util.stream.Collectors.*;

class Solution {

    public List<TreeNode> generateTrees(int n) {
        return next(range(1, n + 1).boxed().collect(toSet()));
    }

    private List<TreeNode> next(Set<Integer> vals) {
        if (vals.isEmpty()) {
            return new ArrayList<>();
        }
        if (vals.size() == 1) {
            return List.of(new TreeNode(vals.iterator().next()));
        }
        var trees = new ArrayList<TreeNode>();
        for (var val : vals) {
            var nextVals = vals.stream().filter(v -> v != val).collect(groupingBy(v -> v > val));
            List<TreeNode> leftTrees = nextVals.containsKey(false) ? next(new HashSet<>(nextVals.get(false))) : new ArrayList<>();
            List<TreeNode> rightTrees = nextVals.containsKey(true) ? next(new HashSet<>(nextVals.get(true))) : new ArrayList<>();
            if (leftTrees.isEmpty() && rightTrees.isEmpty()) {
                trees.add(new TreeNode(val));
            } else if (leftTrees.isEmpty()) {
                trees.addAll(rightTrees.stream()
                    .map(right -> {
                        var tree = new TreeNode(val);
                        tree.right = right;
                        return tree;
                    }).collect(toList()));
            } else if (rightTrees.isEmpty()) {
                trees.addAll(leftTrees.stream()
                    .map(left -> {
                        var tree = new TreeNode(val);
                        tree.left = left;
                        return tree;
                    }).collect(toList()));
            } else {
                for (var left : leftTrees) {
                    for (var right : rightTrees) {
                        var tree = new TreeNode(val);
                        tree.left = left;
                        tree.right = right;
                        trees.add(tree);
                    }
                }
            }
        }
        return trees;
    }

    // java Solution.java "3" "[[1,null,3,2],[3,2,null,1],[3,1,null,null,2],[2,1,3],[1,null,2,null,3]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                string(new Solution().generateTrees(Integer.parseInt(n))), expected, n));
        }
    }

    private static String string(List<TreeNode> list) {
        var s = "";
        for (var node : list) {
            s += "," + string(node);
        }
        return "[" + s.substring(1) + "]";
    }

    private static String string(TreeNode root) {
        if (root == null) return "[]";
        String s = "";
        TreeNode[] nodes = new TreeNode[]{root};
        for (boolean hasNodes = true; hasNodes;) {
            hasNodes = false;
            String level = "";
            TreeNode[] next = new TreeNode[2 * nodes.length];
            for (int i = 0; i < nodes.length; i++) {
                level += nodes[i] == null ? "null," : nodes[i].val + ",";
                if (nodes[i] != null) {
                    hasNodes = true;
                    next[2 * i] = nodes[i].left;
                    next[2 * i + 1] = nodes[i].right;
                }
            }
            while (level.endsWith("null,null,")) level = level.substring(0, level.length() - 5);
            s += level;
            nodes = next;
        }
        while (s.endsWith("null,")) s = s.substring(0, s.length() - 5);
        return "[" + s.substring(0, s.length() - 1) + "]";
    }
}

// ~~~ Please don't copy to LeetCode starting from this line\n` +
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
