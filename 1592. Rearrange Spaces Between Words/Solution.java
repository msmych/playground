import java.util.*;

class Solution {

    public String reorderSpaces(String text) {
        var words = new ArrayList<StringBuilder>();
        words.add(new StringBuilder());
        var spaces = 0;
        for (var c : text.toCharArray()) {
            if (c == ' ') {
                if (words.get(words.size() - 1).length() > 0) {
                    words.add(new StringBuilder());
                }
                spaces++;
            } else {
                words.get(words.size() - 1).append(c);
            }
        }
        if (words.get(words.size() - 1).length() == 0) {
            words.remove(words.size() - 1);
        }
        var sb = new StringBuilder();
        for (var i = 0; i < words.size() - 1; i++) {
            sb.append(words.get(i));
            for (var j = 0; j < spaces / (words.size() - 1); j++) {
                sb.append(' ');
            }
        }
        sb.append(words.get(words.size() - 1));
        for (var i = 0; i < (words.size() > 1 ? spaces % (words.size() - 1) : spaces); i++) {
            sb.append(' ');
        }
        return sb.toString();
    }

    // java Solution.java "  this   is  a sentence " "this   is   a   sentence" " practice   makes   perfect" "practice   makes   perfect " "hello   world" "hello   world" "  walks  udp package   into  bar a" "walks  udp  package  into  bar  a " "a" "a" "  hello" "hello  "
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String text = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: text = %s",
                new Solution().reorderSpaces(text), expected, text));
        }
    }
}
