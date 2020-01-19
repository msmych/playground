const JavaSolution = require('./java-solution');

test('should generate numDistinct solution template', () => {
    const solution = new JavaSolution('int numDistinct(String s, String t)', ['rabbbit', 'rabbit', '3', 'babgbag', 'bag', '5']);
    expect(solution.template).toMatch('class Solution');
    expect(solution.template).toMatch('public int numDistinct(String s, String t)');
    expect(solution.template).toMatch('return 0;');
    expect(solution.template).toMatch('// java Solution.java "rabbbit" "rabbit" "3" "babgbag" "bag" "5"')
    expect(solution.template).toMatch('public static void main(String... args)');
    expect(solution.template).toMatch('String s = args[i], t = args[i + 1], expected = args[i + 2]');
    expect(solution.template).toMatch('"Output: %s | Expected: %s | Input: s = %s, t = %s"');
    expect(solution.template).toMatch('new Solution().numDistinct(s, t), expected, s, t');
});

test('should generate sumEvenGrandparent solution template', () => {
    const solution = new JavaSolution('int sumEvenGrandparent(TreeNode root)');
    expect(solution.template).toMatch('public int sumEvenGrandparent(TreeNode root)');
    expect(solution.template).toMatch('return 0;');
    expect(solution.template).toMatch('// java Solution.java');
    expect(solution.template).toMatch('for (int i = 0; i < args.length; i += 2)');
    expect(solution.template).toMatch('String root = args[i], expected = args[i + 1]');
    expect(solution.template).toMatch('"Output: %s | Expected: %s | Input: root = %s"');
    expect(solution.template).toMatch('new Solution().sumEvenGrandparent(treeNode(root)), expected, root');
    expect(solution.template).toMatch('private static TreeNode treeNode(String s)');
    expect(solution.template).toMatch('class TreeNode');
});

test('should generate twoSum solution template', () => {
    const solution = new JavaSolution('int[] twoSum(int[] nums, int target)');
    expect(solution.template).toMatch('public int[] twoSum(int[] nums, int target)');
    expect(solution.template).toMatch('return new int[0];');
    expect(solution.template).toMatch('for (int i = 0; i < args.length; i += 3)');
    expect(solution.template).toMatch('String nums = args[i], target = args[i + 1], expected = args[i + 2]');
    expect(solution.template).toMatch('System.out.println(String.format(');
    expect(solution.template).toMatch('"Output: %s | Expected: %s | Input: nums = %s, target = %s"');
    expect(solution.template).toMatch('string(new Solution().twoSum(array(nums), Integer.parseInt(target))), expected, nums, target');
    expect(solution.template).toMatch('private static int[] array(String s)');
    expect(solution.template).toMatch('private static String string(int[] arr)');
});

test('should generate matrixBlockSum solution template', () => {
    const solution = new JavaSolution('int[][] matrixBlockSum(int[][] mat, int K)');
    expect(solution.template).toMatch('int[][] matrixBlockSum(int[][] mat, int K)');
    expect(solution.template).toMatch('return new int[0][0];');
    expect(solution.template).toMatch('string(new Solution().matrixBlockSum(array(mat), Integer.parseInt(K))), expected, mat, K))');
    expect(solution.template).toMatch('private static int[][] array(String s)');
    expect(solution.template).toMatch('private static String string(int[][] arr)');
});

test('should generate printVertically solution template', () => {
    const solution = new JavaSolution('List<String> printVertically(String s)');
    expect(solution.template).toMatch('import java.util.List');
    expect(solution.template).toMatch('import java.util.ArrayList');
    expect(solution.template).toMatch('List<String> printVertically(String s)');
    expect(solution.template).toMatch('return new ArrayList<>();');
});
