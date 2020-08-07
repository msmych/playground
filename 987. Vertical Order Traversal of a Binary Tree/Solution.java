import java.util.*;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

class Solution {

    private final Map<Integer, Map<Integer, List<Integer>>> vals = new HashMap<>();
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        next(root, 0, 0);
        return vals.entrySet().stream()
            .sorted(comparingInt(Map.Entry::getKey))
            .map(Map.Entry::getValue)
            .map(y -> y.entrySet().stream()
                .sorted(comparingInt(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .flatMap(list -> list.stream().sorted(naturalOrder()))
                .collect(toList()))
            .collect(toList());
    }

    private void next(TreeNode node, int x, int y) {
        if (node == null) {
            return;
        }
        vals.putIfAbsent(x, new HashMap<>());
        vals.get(x).putIfAbsent(y, new ArrayList<>());
        vals.get(x).get(y).add(node.val);
        next(node.left, x - 1, y + 1);
        next(node.right, x + 1, y + 1);
    }

    // java Solution.java "[3,9,20,null,null,15,7]" "[[9],[3,15],[20],[7]]" "[1,2,3,4,5,6,7]" "[[4],[2],[1,5,6],[3],[7]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String root = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s",
                new Solution().verticalTraversal(treeNode(root)), expected, root));
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
