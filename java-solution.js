class JavaSolution {

    constructor(signature) {
        this.signature = signature;
    }

    get template() {
        let template = `class Solution {\n` + 
        `    public ${this.signature} {\n` +
        `        return ${this.defaultResult};\n` +
        `    }\n` +
        `\n` + 
        `    // java Solution.java\n` +
        `    public static void main(String... args) {\n` +
        `        Solution solution = new Solution();\n` +
        `    }\n` + 
        `}\n`
        if (this.outputType == 'TreeNode' || this.inputTypes.includes('TreeNode')) {
            template += `\n` +
            `class TreeNode {\n` +
            `    int val;\n` +
            `    TreeNode left;\n` +
            `    TreeNode right;\n` +
            `    TreeNode(int x) { val = x; }\n` +
            `\n` +
            `    static TreeNode deserialize(String s) {\n` +
            `        String[] vals = s.split(",");\n` +
            `        if (vals[0].equals("null")) {\n` +
            `            return null;\n` +
            `        }\n` +
            `        TreeNode node = new TreeNode(Integer.parseInt(vals[0]));\n` +
            `        TreeNode[] nodes = new TreeNode[vals.length];\n` +
            `        nodes[0] = node;\n` +
            `        int k = 1;\n` +
            `        for (int i = 1; i < vals.length - 1; i += 2) {\n` +
            `            TreeNode parent = nodes[i - k];\n` +
            `            k++;\n` +
            `            if (parent == null) {\n` +
            `                continue;\n` +
            `            }\n` +
            `            parent.left = vals[i].equals("null") ? null : new TreeNode(Integer.parseInt(vals[i]));\n` +
            `            nodes[i] = parent.left;\n` +
            `            parent.right = vals[i + 1].equals("null") ? null : new TreeNode(Integer.parseInt(vals[i + 1]));\n` +
            `            nodes[i + 1] = parent.right;\n` + 
            `        }\n` +
            `        return nodes[0];\n` +
            `    }\n` +
            `}\n`
        }
        return template;
    }

    get outputType() {
        return this.signature.split(' ')[0];
    }

    get inputTypes() {
        return this.signature.substring(this.signature.indexOf('(') + 1, this.signature.indexOf(')'))
            .split(',')
            .map(param => param.split(' ')[0]);
    }

    get defaultResult() {
        if (this.signature.startsWith('int ')) {
            return '0';
        }
        return 'null';
    }

    get fileName() {
        return 'Solution.java';
    }
}

module.exports = JavaSolution;