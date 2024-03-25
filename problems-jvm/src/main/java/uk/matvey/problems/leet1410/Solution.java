package uk.matvey.problems.leet1410;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

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
        var parsed = new StringBuilder(Arrays.stream(text.split(special.getKey()))
            .map(part -> parse(part, specials.entrySet().stream()
                .filter(e -> e.getKey() != special.getKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))))
            .collect(Collectors.joining(special.getValue())));
        while (text.endsWith(special.getKey())) {
            parsed.append(special.getValue());
            text = text.substring(0, text.length() - special.getKey().length());
        }
        return parsed.toString();
    }
}

class SolutionTest {

    @Test
    void case1() {
        var text = "&amp; is an HTML entity but &ambassador; is not.";

        String result = new Solution().entityParser(text);

        assertThat(result).isEqualTo("& is an HTML entity but &ambassador; is not.");
    }

    @Test
    void case2() {
        var text = "and I quote: &quot;...&quot;";

        String result = new Solution().entityParser(text);

        assertThat(result).isEqualTo("and I quote: \"...\"");
    }

    @Test
    void case3() {
        var text = "&amp;gt;";

        String result = new Solution().entityParser(text);

        assertThat(result).isEqualTo("&gt;");
    }

    @Test
    void case4() {
        var text = "qYsoGgv9q &gt;&gt;&apos;&lt;&lt;";

        String result = new Solution().entityParser(text);

        assertThat(result).isEqualTo("qYsoGgv9q >>'<<");
    }

    @Test
    void case5() {
        var text = "&frasl;usr";

        String result = new Solution().entityParser(text);

        assertThat(result).isEqualTo("/usr");
    }
}
