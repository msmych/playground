const JavaSolution = require('./java-solution');

test('should generate numDistinct solution template', () => {
    const solution = new JavaSolution('int numDistinct(String s, String t)');
    expect(solution.template).toMatch('class Solution');
    expect(solution.template).toMatch('public int numDistinct(String s, String t)');
    expect(solution.template).toMatch('return 0;');
    expect(solution.template).toMatch('// java Solution.java')
    expect(solution.template).toMatch('public static void main(String... args)');
    expect(solution.template).toMatch('Solution solution = new Solution();');
});

test('should generate sumEvenGrandparent solution template', () => {
    const solution = new JavaSolution('int sumEvenGrandparent(TreeNode root)');
    expect(solution.template).toMatch('public int sumEvenGrandparent(TreeNode root)');
    expect(solution.template).toMatch('return 0;');
    expect(solution.template).toMatch('// java Solution.java');
    expect(solution.template).toMatch('private static TreeNode deserialize(String s)');
    expect(solution.template).toMatch('class TreeNode');
});

test('should generate twoSum solution template', () => {
    const solution = new JavaSolution('int[] twoSum(int[] nums, int target)');
    expect(solution.template).toMatch('public int[] twoSum(int[] nums, int target)');
    expect(solution.template).toMatch('return new int[0];');
    expect(solution.template).toMatch('for (int i = 0; i < args.length; i += 3)');
    expect(solution.template).toMatch('String nums = args[i], target = args[i + 1], expected = args[i + 2];');
});