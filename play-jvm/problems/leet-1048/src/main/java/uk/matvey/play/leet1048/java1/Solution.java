package uk.matvey.play.leet1048.java1;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class Solution {
    private Map<Integer, List<String>> wordsByLength;
    private final Map<Set<String>, Boolean> predecessorsMemo = new HashMap<>();
    private final Map<MemoKey, Integer> longestWordChainMemo = new HashMap<>();

    private static class MemoKey {
        String word;
        int i;

        public MemoKey(String word, int i) {
            this.word = word;
            this.i = i;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MemoKey memoKey = (MemoKey) o;
            return i == memoKey.i && Objects.equals(word, memoKey.word);
        }

        @Override
        public int hashCode() {
            return Objects.hash(word, i);
        }
    }

    public int longestStrChain(String[] words) {
        wordsByLength = Arrays.stream(words).collect(groupingBy(String::length));
        var sortedLengths = wordsByLength.keySet().stream().sorted().toList();
        var maxLen = sortedLengths.stream().mapToInt(i -> i).max().getAsInt();
        var max = 0;
        for (var len : sortedLengths) {
            if (maxLen - len < max) {
                break;
            }
            var localMax = wordsByLength.get(len).stream()
                .mapToInt(word -> longestWordChainStep(word, len + 1))
                .max()
                .orElse(0)
                + 1;
            if (localMax > max) {
                max = localMax;
            }
        }
        return max;
    }

    private int longestWordChainStep(String word, int i) {
        MemoKey memoKey = new MemoKey(word, i);
        if (longestWordChainMemo.containsKey(memoKey)) {
            return longestWordChainMemo.get(memoKey);
        }
        if (!wordsByLength.containsKey(i)) {
            return 0;
        }
        var nextMax = 0;
        for (var next : wordsByLength.get(i)) {
            if (!isPredecessor(word, next)) {
                continue;
            }
            var localNextMax = longestWordChainStep(next, i + 1) + 1;
            if (localNextMax > nextMax) {
                nextMax = localNextMax;
            }
        }
        longestWordChainMemo.put(memoKey, nextMax);
        return nextMax;
    }

    private boolean isPredecessor(String word, String next) {
        if (next.length() - word.length() != 1) {
            return false;
        }
        var memoKey = Set.of(word, next);
        if (predecessorsMemo.containsKey(memoKey)) {
            return predecessorsMemo.get(memoKey);
        }
        for (int i = 0; i < next.length(); i++) {
            String other = next.substring(0, i) + next.substring(i + 1);
            if (word.equals(other)) {
                predecessorsMemo.put(memoKey, true);
                return true;
            }
        }
        predecessorsMemo.put(memoKey, false);
        return false;
    }
}
