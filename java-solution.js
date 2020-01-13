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
        `            System.out.println(String.format(\n` +
        `                "Output: %s | Expected: %s | Input: ${this.inputString}",\n` +
        `                ${this.outputString}, expected, ${this.inputNames.join(', ')}));\n` +
        `        }\n` +
        `    }\n`;
        if (this.outputType == 'TreeNode' || this.inputTypes.includes('TreeNode')) {
            template += `\n` +
            `    private static TreeNode treeNode(String s) {\n` +
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
        if (new Set(this.inputTypes).has('int[]')) {
            template += `\n` +
            `    private static int[] array(String s) {\n` +
            `        String[] elements = s.substring(1, s.length() - 1).replaceAll(" ", "").split(",");\n` +
            `        int[] arr = new int[elements.length];\n` +
            `        for (int i = 0; i < elements.length; i++)\n` +
            `            arr[i] = Integer.parseInt(elements[i]);\n` +
            `        return arr;\n` +
            `    }\n`;
        }
        if (new Set(this.inputTypes).has('int[][]')) {
            template += `\n` +
            `    private static int[][] array(String s) {\n` +
            `        s = s.substring(1, s.length() - 1).replaceAll(" ", "");\n` +
            `        if (s.isEmpty()) return new int[0][0];\n` +
            `        String[] rows = s.substring(1, s.length() - 1).split("\\\\],\\\\[");\n` +
            `        if (rows[0].isEmpty()) return new int[0][0];\n` +
            `        int[][] arr = new int[rows.length][rows[0].split(",").length];\n` +
            `        for (int i = 0; i < arr.length; i++) {\n` +
            `            String[] elements = rows[i].split(",");\n` +
            `            for (int j = 0; j < arr[i].length; j++)\n` +
            `                arr[i][j] = Integer.parseInt(elements[j]);\n` +
            `        }\n` +
            `        return arr;\n` +
            `    }\n`;
        }
        if (this.outputType === 'int[]') {
            template += `\n` +
            `    private static String string(int[] arr) {\n` +
            `        String s = "";\n` +
            `        for (int n : arr) s += "," + n;\n` +
            `        if (!s.isEmpty()) s = s.substring(1);\n` +
            `        return "[" + s + "]";\n` +
            `    }\n`;
        } else if (this.outputType === 'int[][]') {
            template += `\n` +
            `    private static String string(int[][] arr) {\n` +
            `        String s = "";\n` +
            `        for (int[] row : arr) {\n` +
            `            String r = "";\n` +
            `            for (int n : row) r += "," + n;\n` +
            `            if (row.length > 0) r = r.substring(1);\n` +
            `            s += ",[" + r + "]";\n` +
            `        }\n` +
            `        if (arr.length > 0) s = s.substring(1);\n` +
            `        return "[" + s + "]";\n` +
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
            `}\n`;
        }
        return template;
    }

    get outputType() {
        return this.signature.split(' ')[0];
    }

    get methodName() {
        return this.signature.split(' ')[1].split('(')[0];
    }

    get params() {
        return this.signature
            .substring(this.signature.indexOf('(') + 1, this.signature.indexOf(')'))
            .split(', ');
    }

    get inputTypes() {
        return this.params.map(param => param.split(' ')[0]);
    }

    get inputNames() {
        return this.params.map(param => param.split(' ')[1]);
    }

    get defaultResult() {
        switch (this.signature.split(' ')[0]) {
            case 'int': return '0';
            case 'int[]': return 'new int[0]';
            case 'int[][]': return 'new int[0][0]';
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

    get inputString() {
        return this.inputNames.map(name => `${name} = %s`).join(', ');
    }

    get outputString() {
        switch (this.outputType) {
            case 'int[]': 
            case 'int[][]': return `string(solution.${this.methodName}(${this.callingParams}))`;
            default: return `solution.${this.methodName}(${this.callingParams})`;
        }
    }

    get callingParams() {
        return this.params
            .map(param => this.callingParam(...param.split(' ')))
            .join(', ');
    }

    callingParam(type, name) {
        switch (type) {
            case 'int': return `Integer.parseInt(${name})`;
            case 'int[]': 
            case 'int[][]': return `array(${name})`;
            case 'TreeNode': return `treeNode(${name})`;
            default: return name;
        }
    }

    get fileName() {
        return 'Solution.java';
    }
}

module.exports = JavaSolution;