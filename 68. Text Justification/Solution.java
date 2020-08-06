import java.util.*;

class Solution {

    private String[] words;
    private int maxWidth;
    private List<String> line;

    public List<String> fullJustify(String[] words, int maxWidth) {
        this.words = words;
        this.maxWidth = maxWidth;
        var justified = new ArrayList<String>();
        var i = 0;
        while (i < words.length && isNotLast(0, i)) {
            line = new ArrayList<>();
            do {
                if (!line.isEmpty()) {
                    line.add(" ");
                }
                line.add(words[i]);
            } while (isJustifiableNotLast(getLineLength(), ++i));
            while (getLineLength() < maxWidth) {
                if (line.size() == 1) {
                    line.add(" ");
                }
                for (var k = 1; k < line.size() && getLineLength() < maxWidth; k += 2) {
                    line.set(k, line.get(k) + " ");
                }
            }
            justified.add(String.join("", line));
        }
        var last = new StringBuilder(String.join(" ", Arrays.copyOfRange(words, i, words.length)));
        while (last.length() < maxWidth) {
            last.append(" ");
        }
        justified.add(last.toString());
        return justified;
    }

    private boolean isJustifiableNotLast(int occupied, int i) {
        return getLineLength() + 1 + words[i].length() <= maxWidth && isNotLast(occupied, i);
    }

    private int getLineLength() {
        return line.stream().mapToInt(String::length).sum();
    }

    private boolean isNotLast(int occupied, int i) {
        var length = occupied == 0 ? words[i].length() : occupied + 1 + words[i].length();
        for (var k = i + 1; k < words.length; k++) {
            length += 1 + words[k].length();
            if (length > maxWidth) {
                return true;
            }
        }
        return false;
    }

    // java Solution.java "[This,is,an,example,of,text,justification.]" "16" "[This    is    an,example  of text,justification.  ]" "[What,must,be,acknowledgment,shall,be]" "16" "[What   must   be,acknowledgment  ,shall be        ]" "[Science,is,what,we,understand,well,enough,to,explain,to,a,computer.,Art,is,everything,else,we,do]" "20" "[Science  is  what we,understand      well,enough to explain to,a  computer.  Art is,everything  else  we,do                  ]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String words = args[i], maxWidth = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: words = %s, maxWidth = %s",
                new Solution().fullJustify(stringArr(words), Integer.parseInt(maxWidth)), expected, words, maxWidth));
        }
    }

    private static String[] stringArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        return s.isEmpty() ? new String[0] : s.split(",");
    }
}
