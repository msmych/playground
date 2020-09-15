class Solution {

    public Node inorderSuccessor(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return leftMost(node.right);
        }
        return greaterParent(node.parent, node.val);
    }
    
    private Node leftMost(Node node) {
        return node.left == null ? node : leftMost(node.left);
    }
    
    private Node greaterParent(Node parent, int val) {
        if (parent == null) {
            return null;
        }
        return parent.val > val ? parent : greaterParent(parent.parent, val);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
