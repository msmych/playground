import java.util.*;

class Solution {

    public List<List<String>> wordSquares(String[] words) {
        return null;
    }

    // java Solution.java "[area,lead,wall,lady,ball]" "[[wall,area,lead,lady],[ball,area,lead,lady]]" "[abat,baba,atan,atal]" "[[baba,abat,baba,atan],[baba,abat,baba,atal]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String words = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: words = %s",
                new Solution().wordSquares(stringArr(words)), expected, words));
        }
    }

    private static String[] stringArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        return s.isEmpty() ? new String[0] : s.split(",");
    }
}
