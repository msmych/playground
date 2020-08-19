import java.util.*;

class Solution {

    private final List<Character> VOWELS = List.of('a', 'e', 'i', 'o', 'u');

    public String toGoatLatin(String S) {
        var sb = new StringBuilder();
        var words = S.split(" ");
        for (var i = 0; i < words.length; i++) {
            var word = words[i];
            var first = word.charAt(0);
            if (VOWELS.contains(Character.toLowerCase(first))) {
                sb.append(word);
            } else {
                sb.append(word.substring(1)).append(first);
            }
            sb.append("ma");
            for (var a = 0; a <= i; a++) {
                sb.append('a');
            }
            if (i < words.length - 1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    // java Solution.java "I speak Goat Latin" "Imaa peaksmaaa oatGmaaaa atinLmaaaaa" "The quick brown fox jumped over the lazy dog" "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String S = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: S = %s",
                new Solution().toGoatLatin(S), expected, S));
        }
    }
}
