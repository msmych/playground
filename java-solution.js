class JavaSolution {

    constructor(signature, args) {
        if (!signature) {
            throw new Error('Missing method signature');
        }
        this.signature = signature;
        this.args = args ? args : [];
    }

    get template() {
        let template = `class Solution {\n` + 
        `    public ${this.signature} {\n` +
        `        return ${this.defaultResult};\n` +
        `    }\n` +
        `\n` + 
        `    // java Solution.java ${this.argsVals}\n` +
        `    public static void main(String... args) {\n` +
        `        for (int i = 0; i < args.length; i += ${this.params.length + 1}) {\n` +
        `            ${this.argsToVariables}\n` +
        `            System.out.println(String.format(\n` +
        `                "Output: %s | Expected: %s | Input: ${this.inputString}",\n` +
        `                ${this.outputString}, expected, ${this.inputNames.join(', ')}));\n` +
        `        }\n` +
        `    }\n`;
        if (this.outputType.startsWith('List<')) {
            template = 'import java.util.List;\n\n' + template;
        }
        if (this.inputTypes.includes('ListNode')) {
            template += `\n` +
            `    private static ListNode listNode(String s) {\n` +
            `        if (s.equals("null")) return null;\n` +
            `        String[] elements = s.replace("[", "").replace("]", "").replaceAll("->", ",").split(",");\n` +
            `        ListNode dummy = new ListNode(0);\n` +
            `        ListNode node = dummy;\n` +
            `        for (String element : elements) {\n` +
            `            node.next = new ListNode(Integer.parseInt(element));\n` +
            `            node = node.next;\n` +
            `        }\n` +
            `        return dummy.next;\n` +
            `    }\n`;
        }
        if (this.inputTypes.includes('int[]')) {
            template += `\n` +
            `    private static int[] array(String s) {\n` +
            `        String[] elements = s.substring(1, s.length() - 1).replaceAll(" ", "").split(",");\n` +
            `        int[] arr = new int[elements.length];\n` +
            `        for (int i = 0; i < elements.length; i++)\n` +
            `            arr[i] = Integer.parseInt(elements[i]);\n` +
            `        return arr;\n` +
            `    }\n`;
        }
        if (this.inputTypes.includes('String[]')) {
            template += `\n` +
            `    private static String[] array(String s) {\n` +
            `        s = s.substring(1, s.length() - 1).replaceAll(" ", "");\n` +
            `        return s.isEmpty() ? new String[0] : s.split(",");\n` +
            `    }\n`;
        }
        if (this.inputTypes.includes('int[][]')) {
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
        if (this.inputTypes.includes('char[][]')) {
            template += `\n` +
            `    private static char[][] array(String s) {\n` +
            `        s = s.substring(1, s.length() - 1).replaceAll(" ", "");\n` +
            `        if (s.isEmpty()) return new char[0][0];\n` +
            `        String[] rows = s.substring(1, s.length() - 1).split("\\\\],\\\\[");\n` +
            `        if (rows[0].isEmpty()) return new char[0][0];\n` +
            `        char[][] arr = new char[rows.length][rows[0].split(",").length];\n` +
            `        for (int i = 0; i < arr.length; i++) {\n` +
            `            String[] elements = rows[i].split(",");\n` +
            `            for (int j = 0; j < arr[i].length; j++)\n` +
            `                arr[i][j] = elements[j].charAt(0);\n` +
            `        }\n` +
            `        return arr;\n` +
            `    }\n`;
        }
        if (this.inputTypes.includes('TreeNode')) {
            template += `\n` +
            `    private static TreeNode treeNode(String s) {\n` +
            `        String[] vals = s.substring(1, s.length() - 1).replaceAll(" ", "").split(",");\n` +
            `        if (vals[0].equals("[]")) return null;\n` +
            `        TreeNode[] nodes = new TreeNode[vals.length];\n` +
            `        nodes[0] = new TreeNode(Integer.parseInt(vals[0]));\n` +
            `        for (int i = 1, k = 1; i < vals.length; i += 2) {\n` +
            `            TreeNode parent = nodes[i - k] == null ? nodes[i - --k] : nodes[i - k++];\n` +
            `            parent.left = vals[i].equals("null") ? null : new TreeNode(Integer.parseInt(vals[i]));\n` +
            `            nodes[i] = parent.left;\n` +
            `            if (i + 1 >= vals.length) break;\n` +
            `            parent.right = vals[i + 1].equals("null") ? null : new TreeNode(Integer.parseInt(vals[i + 1]));\n` +
            `            nodes[i + 1] = parent.right;\n` +
            `        }\n` +
            `        return nodes[0];\n` +
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
        } else if (this.outputType === 'ListNode') {
            template += `\n` +
            `    private static String string(ListNode head) {\n` +
            `        if (head == null) return "null";\n` +
            `        String s = "";\n` +
            `        while (head != null) {\n` +
            `            s += head.val + "->";\n` +
            `            head = head.next;\n` +
            `        }\n` +
            `        return s.substring(0, s.length() - 2);\n` +
            `    }\n`;
        } else if (this.outputType === 'TreeNode') {
            template += `\n` +
            `    private static String string(TreeNode root) {\n` +
            `        if (root == null) return "[]";\n` +
            `        String s = "";\n` +
            `        TreeNode[] nodes = new TreeNode[]{root};\n` +
            `        for (boolean hasNodes = true; hasNodes;) {\n` +
            `            hasNodes = false;\n` +
            `            String level = "";\n` +
            `            TreeNode[] next = new TreeNode[2 * nodes.length];\n` +
            `            for (int i = 0; i < nodes.length; i++) {\n` +
            `                level += nodes[i] == null ? "null," : nodes[i].val + ",";\n` +
            `                if (nodes[i] != null) {\n` +
            `                    hasNodes = true;\n` +
            `                    next[2 * i] = nodes[i].left;\n` +
            `                    next[2 * i + 1] = nodes[i].right;\n` +
            `                }\n` +
            `            }\n` +
            `            while (level.endsWith("null,null,")) level = level.substring(0, level.length() - 5);\n` +
            `            s += level;\n` +
            `            nodes = next;\n` +
            `        }\n` +
            `        while (s.endsWith("null,")) s = s.substring(0, s.length() - 5);\n` +
            `        return "[" + s.substring(0, s.length() - 1) + "]";\n` +
            `    }\n`;
        }
        template += '}\n';
        if (this.outputType === 'ListNode' || this.inputTypes.includes('ListNode')) {
            template += `\n` +
            `// ~~~ Please don't copy to LeetCode starting from this line\n` +
            `class ListNode {\n` +
            `    int val;\n` +
            `    ListNode next;\n` +
            `    ListNode(int x) { val = x; }\n` +
            `}\n`;
        }
        if (this.outputType === 'TreeNode' || this.inputTypes.includes('TreeNode')) {
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
            case 'double': return '0.0';
            case 'boolean': return 'false';
            case 'String': return '""';
            default: return 'null';
        }
    }

    get argsVals() {
        return this.args
            .map(arg => `"${arg.replace(/\r?\n|\r/g, "").replace(/#/g, "\\#")}"`)
            .join(' ')
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
            case 'int[][]':
            case 'ListNode':
            case 'TreeNode': return `string(new Solution().${this.methodName}(${this.callingParams}))`;
            default: return `new Solution().${this.methodName}(${this.callingParams})`;
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
            case 'String[]':
            case 'int[][]': 
            case 'char[][]': return `array(${name})`;
            case 'ListNode': return `listNode(${name})`;
            case 'TreeNode': return `treeNode(${name})`;
            default: return name;
        }
    }

    get fileName() {
        return 'Solution.java';
    }
}

module.exports = JavaSolution;
