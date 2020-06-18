class TreeAncestor {

    public TreeAncestor(int n, int[] parent) {
        
    }
    
    public int getKthAncestor(int node, int k) {
        return 0;        
    }

    public static void main(String... args) {
        var ancestor = new TreeAncestor(7, new int[]{-1,0,0,1,1,2,2});
        System.out.println(String.format("Output: %s | Expected: %s", ancestor.getKthAncestor(3, 1), 1));
        System.out.println(String.format("Output: %s | Expected: %s", ancestor.getKthAncestor(5, 2), 0));
        System.out.println(String.format("Output: %s | Expected: %s", ancestor.getKthAncestor(6, 3), -1));
    }
}
