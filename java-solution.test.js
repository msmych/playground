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
    expect(solution.template).toMatch(`// ~~~ Please don't copy to LeetCode starting from this line`);
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
    expect(solution.template).toMatch('string(new Solution().twoSum(intArray(nums), Integer.parseInt(target))), expected, nums, target');
    expect(solution.template).toMatch('private static int[] intArray(String s)');
    expect(solution.template).toMatch('private static String string(int[] arr)');
});

test('should generate matrixBlockSum solution template', () => {
    const solution = new JavaSolution('int[][] matrixBlockSum(int[][] mat, int K)');
    expect(solution.template).toMatch('int[][] matrixBlockSum(int[][] mat, int K)');
    expect(solution.template).toMatch('return new int[0][0];');
    expect(solution.template).toMatch('string(new Solution().matrixBlockSum(int2dArray(mat), Integer.parseInt(K))), expected, mat, K))');
    expect(solution.template).toMatch('private static int[][] int2dArray(String s)');
    expect(solution.template).toMatch('private static String string(int[][] arr)');
});

test('should generate printVertically solution template', () => {
    const solution = new JavaSolution('List<String> printVertically(String s)');
    expect(solution.template).toMatch('import java.util.*');
    expect(solution.template).toMatch('List<String> printVertically(String s)');
});

test('should generate removeLeafNodes solution template', () => {
    const solution = new JavaSolution('TreeNode removeLeafNodes(TreeNode root, int target)');
    expect(solution.template).toMatch('import java.util.*;');
    expect(solution.template).toMatch('TreeNode removeLeafNodes(TreeNode root, int target)');
    expect(solution.template).toMatch('string(new Solution().removeLeafNodes(treeNode(root), Integer.parseInt(target))), expected, root, target))');
    expect(solution.template).toMatch('private static String string(TreeNode root)');
});

test('should generate insertionSortList solution template', () => {
    const solution = new JavaSolution('ListNode insertionSortList(ListNode head)');
    expect(solution.template).toMatch('ListNode insertionSortList(ListNode head)');
    expect(solution.template).toMatch('string(new Solution().insertionSortList(listNode(head))), expected, head))');
    expect(solution.template).toMatch('private static ListNode listNode(String s)');
    expect(solution.template).toMatch('private static String string(ListNode head)');
    expect(solution.template).toMatch(`// ~~~ Please don't copy to LeetCode starting from this line`);
    expect(solution.template).toMatch('class ListNode');
});

test('should generate largestNumber solution template', () => {
    const solution = new JavaSolution('String largestNumber(int[] nums)');
    expect(solution.template).toMatch('String largestNumber(int[] nums)');
    expect(solution.template).toMatch('return "";');
});

test('should generate checkIfExist solution template', () => {
    const solution = new JavaSolution('boolean checkIfExist(int[] arr)');
    expect(solution.template).toMatch('boolean checkIfExist(int[] arr)');
    expect(solution.template).toMatch('return false');
});

test('should generate angleClock solution template', () => {
    const solution = new JavaSolution('double angleClock(int hour, int minutes)');
    expect(solution.template).toMatch('double angleClock(int hour, int minutes)');
    expect(solution.template).toMatch('return 0.0');
});

test('should generate maxStudents solution template', () => {
    const solution = new JavaSolution('int maxStudents(char[][] seats)');
    expect(solution.template).toMatch('int maxStudents(char[][] seats)');
    expect(solution.template).toMatch('new Solution().maxStudents(char2dArray(seats)), expected, seats))');
    expect(solution.template).toMatch('private static char[][] char2dArray(String s)');
});

test('should generate rankTeams solution template', () => {
    const solution = new JavaSolution('String rankTeams(String[] votes)');
    expect(solution.template).toMatch('String rankTeams(String[] votes)');
    expect(solution.template).toMatch('new Solution().rankTeams(stringArray(votes)), expected, votes))');
    expect(solution.template).toMatch('private static String[] stringArray(String s)');
});

test('should generate displayTable solution template', () => {
    const solution = new JavaSolution('List<List<String>> displayTable(List<List<String>> orders)');
    expect(solution.template).toMatch('import java.util.*');
    expect(solution.template).toMatch('List<List<String>> displayTable(List<List<String>> orders)');
    expect(solution.template).toMatch('new Solution().displayTable(list(orders)), expected, orders))');
    expect(solution.template).toMatch('private static List<List<String>> list(String s)');
});

test('should generate findDiagonalOrder solution template', () => {
    const solution = new JavaSolution('int[] findDiagonalOrder(List<List<Integer>> nums)');
    expect(solution.template).toMatch('import java.util.*');
    expect(solution.template).toMatch('int[] findDiagonalOrder(List<List<Integer>> nums)');
    expect(solution.template).toMatch('string(new Solution().findDiagonalOrder(list(nums))), expected, nums))');
    expect(solution.template).toMatch('private static List<List<Integer>> list(String s)');
});

test('should generate minTime solution template', () => {
    const solution = new JavaSolution('int minTime(int n, int[][] edges, List<Boolean> hasApple)');
    expect(solution.template).toMatch('import java.util.*');
    expect(solution.template).toMatch('int minTime(int n, int[][] edges, List<Boolean> hasApple)');
    expect(solution.template).toMatch('new Solution().minTime(Integer.parseInt(n), int2dArray(edges), list(hasApple)), expected, n, edges, hasApple))');
    expect(solution.template).toMatch('private static List<Boolean> list(String s)');
});

test('should generate getFolderNames solution template', () => {
    const solution = new JavaSolution('String[] getFolderNames(String[] names)');
    expect(solution.template).toMatch('String[] getFolderNames(String[] names)');
    expect(solution.template).toMatch('string(new Solution().getFolderNames(stringArray(names)))');
    expect(solution.template).toMatch('private static String string(String[] arr)');
});
    
test('should generate mergeKLists solution template', () => {
    const solution = new JavaSolution('ListNode mergeKLists(ListNode[] lists)');
    expect(solution.template).toMatch('ListNode mergeKLists(ListNode[] lists)');
    expect(solution.template).toMatch('string(new Solution().mergeKLists(listNodeArray(lists)))');
    expect(solution.template).toMatch('private static ListNode[] listNodeArray(String s)');
    expect(solution.template).toMatch('private static ListNode listNode(String s)');
});

test('should generate nextPermutation solution template', () => {
    const solution = new JavaSolution('void nextPermutation(int[] nums)');
    expect(solution.template).toMatch('void nextPermutation(int[] nums)');
    expect(solution.template).toMatch('return;');
});

test('should generate myPow solution template', () => {
    const solution = new JavaSolution('double myPow(double x, int n)');
    expect(solution.template).toMatch('double myPow(double x, int n)');
    expect(solution.template).toMatch('new Solution().myPow(Double.parseDouble(x), Integer.parseInt(n))');
    expect(solution.template).toMatch('return 0.0');
});

test('should generate leastInterval solution template', () => {
    const solution = new JavaSolution('int leastInterval(char[] tasks, int n)');
    expect(solution.template).toMatch('int leastInterval(char[] tasks, int n)');
    expect(solution.template).toMatch('new Solution().leastInterval(charArray(tasks), Integer.parseInt(n))');
    expect(solution.template).toMatch('private static char[] charArray(String s)');
});
