const createSolution = require('./solution');

test('should generate numDistinct solution template', () => {
    const solution = createSolution('java', 'int numDistinct(String s, String t)');
    expect(solution.template).toMatch('class Solution');
    expect(solution.template).toMatch('public int numDistinct(String s, String t)');
    expect(solution.template).toMatch('return 0');
    expect(solution.template).toMatch('// java Solution.java')
    expect(solution.template).toMatch('public static void main(String... args)');
    expect(solution.template).toMatch('Solution solution = new Solution();');
});
