class Solution {

    public String reverseWords(String s) {
        var words = s.split(" ");
        int i = 0, j = words.length - 1;
        while (i <= j) {
            String left = words[i], right = words[j];
            words[i] = right;
            words[j] = left;
            i++;
            j--;
        }
        var sb = new StringBuilder();
        if (words.length > 0 && !words[0].isEmpty()) {
            sb.append(words[0]);
        }
        for (var k = 1; k < words.length; k++) {
            if (!words[k].isEmpty()) {
                sb.append(" ").append(words[k]);
            }
        }
        return sb.toString();
    }

    // java Solution.java "the sky is blue" "blue is sky the"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().reverseWords(s), expected, s));
        }
    }
}
