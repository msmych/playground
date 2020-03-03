import java.util.Set;

import static java.util.Collections.singleton;
import static java.util.stream.Collectors.toSet;

class Solution {

    private ListNode head;

    public boolean isSubPath(ListNode head, TreeNode root) {
        this.head = head;
        return isNextSubPath(root, singleton(head));
    }

    private boolean isNextSubPath(TreeNode node, Set<ListNode> listNodes) {
        if (node == null) {
            return false;
        }
        Set<ListNode> nextListNodes = listNodes.stream()
            .filter(listNode -> listNode.val == node.val)
            .map(listNode -> listNode.next)
            .collect(toSet());
        if (nextListNodes.stream().anyMatch(listNode -> listNode == null)) {
            return true;
        }
        nextListNodes = nextListNodes.stream()
            .filter(listNode -> listNode != null)
            .collect(toSet());
        nextListNodes.add(head);
        return isNextSubPath(node.left, nextListNodes) || isNextSubPath(node.right, nextListNodes);
    }

    // java Solution.java "[4,2,8]" "[1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]" "true" "[1,4,2,6]" "[1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]" "true" "[1,4,2,6,8]" "[1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String head = args[i], root = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: head = %s, root = %s",
                new Solution().isSubPath(listNode(head), treeNode(root)), expected, head, root));
        }
    }

    private static ListNode listNode(String s) {
        if (s.equals("null")) return null;
        String[] elements = s.replace("[", "").replace("]", "").replaceAll("->", ",").split(",");
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        for (String element : elements) {
            node.next = new ListNode(Integer.parseInt(element));
            node = node.next;
        }
        return dummy.next;
    }

    private static TreeNode treeNode(String s) {
        String[] vals = s.substring(1, s.length() - 1).replaceAll(" ", "").split(",");
        if (vals[0].equals("[]")) return null;
        TreeNode[] nodes = new TreeNode[vals.length];
        nodes[0] = new TreeNode(Integer.parseInt(vals[0]));
        for (int i = 1, k = 1; i < vals.length; i += 2) {
            TreeNode parent = nodes[i - k] == null ? nodes[i - --k] : nodes[i - k++];
            parent.left = vals[i].equals("null") ? null : new TreeNode(Integer.parseInt(vals[i]));
            nodes[i] = parent.left;
            if (i + 1 >= vals.length) break;
            parent.right = vals[i + 1].equals("null") ? null : new TreeNode(Integer.parseInt(vals[i + 1]));
            nodes[i + 1] = parent.right;
        }
        return nodes[0];
    }
}

// ~~~ Please don't copy to LeetCode starting from this line
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
