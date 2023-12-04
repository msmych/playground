package uk.matvey.play.leet1316.java1;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int distinctEchoSubstrings(String text) {
        Set<String> echoes = new HashSet<>();
        for (int i = 1; i <= text.length() / 2; i++) {
            for (int j = 0; j + 2 * i <= text.length(); j++) {
                String echo = text.substring(j, j + i);
                if (!echoes.contains(echo) && echo.equals(text.substring(j + i, j + 2 * i))) {
                    echoes.add(echo);
                }
            }
        }
        return echoes.size();
    }
}
