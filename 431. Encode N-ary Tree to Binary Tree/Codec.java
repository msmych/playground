import java.util.*;

class Codec {

    public TreeNode encode(Node root) {
        return encodeNext(root, List.of());
    }
    
    private TreeNode encodeNext(Node node, List<Node> nodes) {
        if (node == null) {
            return null;
        }
        var treeNode = new TreeNode(node.val);
        if (!node.children.isEmpty()) {
            treeNode.left = encodeNext(node.children.get(0), node.children.subList(1, node.children.size()));
        }
        if (!nodes.isEmpty()) {
            treeNode.right = encodeNext(nodes.get(0), nodes.subList(1, nodes.size()));
        }
        return treeNode;
    }
	
    public Node decode(TreeNode root) {
        if (root == null) {
            return null;
        }
        return new Node(root.val, decodeNext(root.left));
    }

    private List<Node> decodeNext(TreeNode treeNode) {
        if (treeNode == null) {
            return List.of();
        }
        var node = new Node(treeNode.val, decodeNext(treeNode.left));
        var nodes = new ArrayList<Node>();
        nodes.add(node);
        nodes.addAll(decodeNext(treeNode.right));
        return nodes;
    } 
}

// ~~~
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
