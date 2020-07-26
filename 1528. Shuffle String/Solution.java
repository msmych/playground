class Solution {
    public String restoreString(String s, int[] indices) {
        var sb = new StringBuilder(s);
        for (var i = 0; i < indices.length; i++) {
            sb.setCharAt(indices[i], s.charAt(i));
        }
        return sb.toString();
    }

    // java Solution.java "codeleet" "[4,5,6,7,0,2,1,3]" "leetcode" "abc" "[0,1,2]" "abc" "aiohn" "[3,1,4,2,0]" "nihao" "aaiougrt" "[4,0,2,6,7,3,1,5]" "arigatou" "art" "[1,0,2]" "rat"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String s = args[i], indices = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s, indices = %s",
                new Solution().restoreString(s, array(indices)), expected, s, indices));
        }
    }

    private static int[] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
