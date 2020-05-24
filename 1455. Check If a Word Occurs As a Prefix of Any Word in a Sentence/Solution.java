import static java.util.stream.IntStream.*;

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        var words = sentence.split(" ");
        return range(0, words.length)
            .filter(i -> words[i].startsWith(searchWord))
            .map(i -> i + 1)
            .findFirst()
            .orElse(-1);
    }

    // java Solution.java "i love eating burger" "burg" "4" "this problem is an easy problem" "pro" "2" "i am tired" "you" "-1" "i use triple pillow" "pill" "4" "hello from the other side" "they" "-1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String sentence = args[i], searchWord = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: sentence = %s, searchWord = %s",
                new Solution().isPrefixOfWord(sentence, searchWord), expected, sentence, searchWord));
        }
    }
}
