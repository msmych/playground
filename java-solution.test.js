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
    expect(solution.template).toMatch('int sumEvenGrandparent(TreeNode root)');
    expect(solution.template).toMatch('return 0;');
    expect(solution.template).toMatch('// java Solution.java')
    expect(solution.template).toMatch('class TreeNode');
    expect(solution.template).toMatch('static TreeNode deserialize(String s)');
});