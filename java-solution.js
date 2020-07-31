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
        `        return${this.defaultResult};\n` +
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
        if (this.outputType.startsWith('List<') || 
                this.inputTypes.includes('List<Boolean>') ||
                this.inputTypes.includes('List<List<Integer>>') || 
                this.inputTypes.includes('List<List<String>>')) {
            template = 'import java.util.*;\n\n' + template; 
        }
        if (this.inputTypes.includes('ListNode[]')) {
            template += this.listNodeArr();
            template += this.listNode();
        }
        if (this.inputTypes.includes('ListNode')) {
            template += this.listNode();
        }
        if (this.inputTypes.includes('int[]')) {
            template += `\n` +
            `    private static int[] intArr(String s) {\n` +
            `        s = s.substring(1, s.length() - 1).replaceAll(" ", "");\n` +
            `        if (s.isEmpty()) return new int[0];\n` +
            `        String[] elements = s.split(",");\n` +
            `        int[] arr = new int[elements.length];\n` +
            `        for (int i = 0; i < elements.length; i++)\n` +
            `            arr[i] = Integer.parseInt(elements[i]);\n` +
            `        return arr;\n` +
            `    }\n`;
        }
        if (this.inputTypes.includes('char[]')) {
            template += this.intArr();
        }
        if (this.inputTypes.includes('String[]')) {
            template += `\n` +
            `    private static String[] stringArr(String s) {\n` +
            `        s = s.substring(1, s.length() - 1).replaceAll(" ", "");\n` +
            `        return s.isEmpty() ? new String[0] : s.split(",");\n` +
            `    }\n`;
        }
        if (this.inputTypes.includes('int[][]')) {
            template += this.intArrArr();
        }
        if (this.inputTypes.includes('char[][]')) {
            template += `\n` +
            `    private static char[][] charArrArr(String s) {\n` +
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
        if (this.inputTypes.includes('List<String>')) {
            template += this.stringList();
        }
        if (this.inputTypes.includes('List<Boolean>')) {
            template += `\n` +
            `    private static List<Boolean> booleanList(String s) {\n` +
            `        s = s.substring(1, s.length() - 1).replaceAll(" ", "");\n` +
            `        if (s.isEmpty()) return new ArrayList<>();\n` +
            `        var elements = s.split(",");\n` +
            `        var list = new ArrayList<Boolean>();\n` +
            `        for (var element : elements) {\n` +
            `            list.add(element.equals("true"));\n` +
            `        }\n` +
            `        return list;\n` +
            `    }\n`;
        }
        if (this.inputTypes.includes('List<List<Integer>>')) {
            template += `\n` +
            `    private static List<List<Integer>> integerListList(String s) {\n` +
            `        s = s.substring(1, s.length() - 1).replaceAll(" ", "");\n` +
            `        if (s.isEmpty()) return new ArrayList<>();\n` +
            `        var rows = s.substring(1, s.length() - 1).split("\\],\\[");\n` +
            `        if (rows[0].isEmpty()) return new ArrayList<>();\n` +
            `        var list = new ArrayList<List<Integer>>();\n` +
            `        for (int i = 0; i < rows.length; i++) {\n` +
            `            var elements = rows[i].split(",");\n` +
            `            var row = new ArrayList<Integer>();\n` +
            `            for (int j = 0; j < elements.length; j++)\n` +
            `            row.add(Integer.parseInt(elements[j]));\n` +
            `            list.add(row);\n` +
            `        }\n` +
            `        return list;\n` +
            `    }\n`;
        }
        if (this.inputTypes.includes('List<List<String>>')) {
            template += `\n` +
            `    private static List<List<String>> stringListList(String s) {\n` +
            `        s = s.substring(1, s.length() - 1).replaceAll(" ", "");\n` +
            `        if (s.isEmpty()) return List.of();\n` +
            `        var rows = s.substring(1, s.length() - 1).split("\\\\],\\\\[");\n` +
            `        if (rows[0].isEmpty()) return List.of();\n` +
            `        var list = new ArrayList<List<String>>();\n` +
            `        for (var i = 0; i < rows.length; i++) {\n` +
            `            var elements = rows[i].split(",");\n` +
            `            var row = new ArrayList<String>();\n` +
            `            for (var j = 0; j < elements.length; j++)\n` +
            `                row.add(elements[j]);\n` +
            `            list.add(row);\n` +
            `        }\n` + 
            `        return list;\n` +
            `    }\n`;
        }
        if (this.inputTypes.includes('TreeNode')) {
            template = 'import java.util.*;\n\n' + template;
            template += `\n` +
            `    private static TreeNode treeNode(String s) {\n` +
            `        s = s.replace("[", "").replace("]", "").replaceAll(" ", "");\n` +
            `        if (s.isEmpty()) return null;\n` +
            `        String[] elements = s.split(",");\n` +
            `        TreeNode[] nodes  = new TreeNode[elements.length];\n` +
            `        Stack<TreeNode> stack = new Stack<>();\n` +
            `        for (int i = elements.length - 1, n = 0; i >= 0; i--, n++) {\n` +
            `            TreeNode node = (elements[i].equals("null")) ? null : new TreeNode(Integer.parseInt(elements[i]));\n` +
            `            nodes[elements.length - n - 1] = node;\n` +
            `            stack.push(node);\n` +
            `        }\n` +
            `        TreeNode root = stack.pop();\n` +
            `        for (TreeNode node : nodes) {\n` +
            `            if (node != null) {\n` +
            `                if (!stack.empty()) node.left = stack.pop();\n` +
            `                if (!stack.empty()) node.right = stack.pop();\n` +
            `            }\n` +
            `        }\n` +
            `        return root;\n` +
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
        } else if (this.outputType === 'String[]') {
            template += `\n` +
            `    private static String string(String[] arr) {\n` +
            `        var s = "";\n` +
            `        for (var e : arr) s += "," + e;\n` +
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
        } else if (this.outputType === 'char[][]') {
            template += this.charArrArrString();
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
            `// ~~~ Please don't copy to LeetCode starting from this line\n` +
            `class TreeNode {\n` +
            `    int val;\n` +
            `    TreeNode left;\n` +
            `    TreeNode right;\n` +
            `    TreeNode(int x) { val = x; }\n` +
            `}\n`;
        }
        return template;
    }

    intArr() {
        return `\n` +
        `    private static char[] charArr(String s) {\n` +
        `        s = s.substring(1, s.length() - 1).replaceAll(" ", "");\n` +
        `        if (s.isEmpty()) return new char[0];\n` +
        `        var els = s.split(",");\n` +
        `        var arr = new char[els.length];\n` +
        `        for (var i = 0; i < els.length; i++) arr[i] = els[i].charAt(0);\n` +
        `        return arr;\n` +
        `    }\n`; 
    }

    intArrArr() {
        return `\n` +
        `    private static int[][] intArrArr(String s) {\n` +
        `        s = s.replace(" ", "");\n` +
        `        if (s.equals("[[]]")) return new int[0][0];\n` +
        `        var rows = s.substring(1, s.length() - 1).split("\\\\],\\\\[");\n` +
        `        var arr = new int[rows.length][];\n` +
        `        for (var i = 0; i < arr.length; i++) {\n` +
        `            var row = rows[i].replace("[", "").replace("]", "");\n` +
        `            if (row.isEmpty()) {\n` +
        `                arr[i] = new int[0];\n` +
        `                continue;\n` +
        `            }\n` +
        `            var els = row.split(",");\n` +
        `            arr[i] = new int[els.length];\n` +
        `            for (var j = 0; j < arr[i].length; j++) arr[i][j] = Integer.parseInt(els[j]);\n` +
        `        }\n` +
        `        return arr;\n` +
        `    }\n`
    }

    listNodeArr() {
        return `\n` +
        `    private static ListNode[] listNodeArr(String s) {\n` +
        `        s = s.substring(1, s.length() - 1).replaceAll(" ", "");\n` +
        `        if (s.isEmpty()) return new ListNode[0];\n` +
        `        var elements = s.split(",");\n` +
        `        var arr = new ListNode[elements.length];\n` +
        `        for (var i = 0; i < arr.length; i++) arr[i] = listNode(elements[i]);\n` +
        `        return arr;\n` +
        `    }\n`;
    }

    listNode() {
        return `\n` +
        `    private static ListNode listNode(String s) {\n` +
        `        if (s.equals("null")) return null;\n` +
        `        var elements = s.replace("[", "").replace("]", "").replaceAll("->", ",").split(",");\n` +
        `        var dummy = new ListNode(0);\n` +
        `        var node = dummy;\n` +
        `        for (var el : elements) {\n` +
        `            node.next = new ListNode(Integer.parseInt(el));\n` +
        `            node = node.next;\n` +
        `        }\n` +
        `        return dummy.next;\n` +
        `    }\n`;
    }

    charArrArrString() {
        return `\n` +
        `    private static String string(char[][] arr) {\n` +
        `        var s = "";\n` +
        `        for (var row : arr) {\n` +
        `            var r = "";\n` +
        `            for (var c : row) r += "," + c;\n` +
        `            if (row.length > 0) r = r.substring(1);\n` +
        `            s += ",[" + r + "]";\n` +
        `        }\n` +
        `        if (arr.length > 0) s = s.substring(1);\n` +
        `        return "[" + s + "]";\n` +
        `    }\n`;
    }

    stringList() {
        return `\n` + 
        `    private static List<String> stringList(String s) {\n` +
        `        s = s.substring(1, s.length() - 1).replaceAll(" ", "");\n` +
        `        if (s.isEmpty()) return new ArrayList<>();\n` +
        `        var els = s.split(",");\n` +
        `        var list = new ArrayList<String>();\n` +
        `        for (var el : els) list.add(el);\n` +
        `        return list;\n` +
        `    }\n`;
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
            case 'int': return ' 0';
            case 'int[]': return ' new int[0]';
            case 'int[][]': return ' new int[0][0]';
            case 'double': return ' 0.0';
            case 'boolean': return ' false';
            case 'String': return ' ""';
            case 'void': return '';
            default: return ' null';
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
            case 'String[]':
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
            case 'double': return `Double.parseDouble(${name})`;
            case 'int[]': return `intArr(${name})`; 
            case 'char[]': return `charArr(${name})`;
            case 'String[]': return `stringArr(${name})`;
            case 'int[][]': return `intArrArr(${name})`;
            case 'ListNode[]': return `listNodeArr(${name})`;
            case 'char[][]': return `charArrArr(${name})`;
            case 'List<String>': return `stringList(${name})`;
            case 'List<Boolean>': return `booleanList(${name})`;
            case 'List<List<Integer>>': return `integerListList(${name})`;
            case 'List<List<String>>': return `stringListList(${name})`;
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
