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
        `        for (int i = 0; i < args.length; i += ${this.params.length + 1}) {\n` +
        `            ${this.argsToVariables}\n` +
        `        }\n` +
        `    }\n`;
        if (this.outputType == 'TreeNode' || this.inputTypes.includes('TreeNode')) {
            template += `\n` +
            `    private static TreeNode deserialize(String s) {\n` +
            `        String[] vals = s.substring(1, s.length() - 1).split(",");\n` +
            `        if (vals[0].equals("null")) return null;\n` +
            `        TreeNode[] nodes = new TreeNode[vals.length];\n` +
            `        nodes[0] = new TreeNode(Integer.parseInt(vals[0]));\n` +
            `        for (int i = 1, k = 1; i < vals.length - 1; i += 2) {\n` +
            `            TreeNode parent = nodes[i - k++];\n` +
            `            if (parent == null) continue;\n` +
            `            parent.left = vals[i].equals("null")\n` +
            `                ? null : new TreeNode(Integer.parseInt(vals[i]));\n` +
            `            nodes[i] = parent.left;\n` +
            `            parent.right = vals[i + 1].equals("null")\n` +
            `                ? null : new TreeNode(Integer.parseInt(vals[i + 1]));\n` +
            `            nodes[i + 1] = parent.right;\n` +
            `        }\n` +
            `        return nodes[0];\n` +
            `    }\n`;
        }
        template += '}\n';
        if (this.outputType == 'TreeNode' || this.inputTypes.includes('TreeNode')) {
            template += `\n` +
            `class TreeNode {\n` +
            `    int val;\n` +
            `    TreeNode left;\n` +
            `    TreeNode right;\n` +
            `    TreeNode(int x) { val = x; }\n` +
            `}\n`
        }
        return template;
    }

    get outputType() {
        return this.signature.split(' ')[0];
    }

    get params() {
        return this.signature
            .substring(this.signature.indexOf('(') + 1, this.signature.indexOf(')'))
            .split(', ');
    }

    get inputTypes() {
        return this.params.map(param => param.split(' ')[0]);
    }

    get defaultResult() {
        switch (this.signature.split(' ')[0]) {
            case 'int': return '0';
            case 'int[]': return 'new int[0]';
            default: return 'null';
        }
    }

    get argsToVariables() {
        const params = this.params.map(param => param.split(' ')[1]);
        let s = `String ${params[0]} = args[i]`;
        for (let i = 1; i < params.length; i++) {
            s += `, ${params[i]} = args[i + ${i}]`;
        }
        return s + `, expected = args[i + ${params.length}];`;
    }

    get fileName() {
        return 'Solution.java';
    }
}

module.exports = JavaSolution;