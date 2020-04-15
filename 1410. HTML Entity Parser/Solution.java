import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;

class Solution {
    public String entityParser(String text) {
        var specials = new HashMap<String, String>();
        specials.put("&quot;", "\"");
        specials.put("&apos;", "'");
        specials.put("&amp;", "&");
        specials.put("&gt;", ">");
        specials.put("&lt;", "<");
        specials.put("&frasl;", "/");
        return parse(text, specials);
    }

    private String parse(String text, Map<String, String> specials) {
        if (specials.isEmpty()) {
            return text;
        }
        var special = specials.entrySet().iterator().next();
        var parsed = stream(text.split(special.getKey()))
                .map(part -> parse(part, specials.entrySet().stream()
                    .filter(e -> e.getKey() != special.getKey())
                    .collect(toMap(Map.Entry::getKey, Map.Entry::getValue))))
            .collect(joining(special.getValue()));
        while (text.endsWith(special.getKey())) {
            parsed += special.getValue();
            text = text.substring(0, text.length() - special.getKey().length());
        }
        return parsed;
    }

    // java Solution.java "&amp; is an HTML entity but &ambassador; is not." "& is an HTML entity but &ambassador; is not." "and I quote: &quot;...&quot;" "and I quote: \"...\""  "&amp;gt;" "&gt;" "qYsoGgv9q &gt;&gt;&apos;&lt;&lt;" "qYsoGgv9q >>'<<" "&frasl;usr" "/usr"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String text = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: text = %s",
                new Solution().entityParser(text), expected, text));
        }
    }
}
