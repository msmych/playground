import java.util.*;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

class ValidWordAbbr {

    private final Map<String, List<String>> dictionary;

    public ValidWordAbbr(String[] dictionary) {
        this.dictionary = stream(dictionary).collect(groupingBy(this::abbreviation)); 
    }

    private String abbreviation(String s) {
        if (s.length() <= 2) {
            return s;
        }
        return s.charAt(0) + "" + (s.length() - 2) + "" + s.charAt(s.length() - 1);
    }
    
    public boolean isUnique(String word) {
        var abbr = abbreviation(word);
        return !dictionary.containsKey(abbr) || dictionary.get(abbr).stream().allMatch(word::equals);
    }

    public static void main(String... args) {
        var validWordAbbr = new ValidWordAbbr(new String[]{ "deer","door","cake","card" });
        System.out.println(String.format("Output: %s | Expected: %s", validWordAbbr.isUnique("dear"), false));
        System.out.println(String.format("Output: %s | Expected: %s", validWordAbbr.isUnique("cart"), true));
        System.out.println(String.format("Output: %s | Expected: %s", validWordAbbr.isUnique("cane"), false));
        System.out.println(String.format("Output: %s | Expected: %s", validWordAbbr.isUnique("make"), true));
    }
}
