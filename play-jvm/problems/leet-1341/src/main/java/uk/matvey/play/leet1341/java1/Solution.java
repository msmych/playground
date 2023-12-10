package uk.matvey.play.leet1341.java1;

import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        return IntStream.range(0, mat.length)
                .mapToObj(i -> soldiers(i, mat[i]))
                .sorted(Comparator.comparingInt(s -> s[1]))
                .limit(k)
                .mapToInt(s -> s[0])
                .toArray();
    }

    private int[] soldiers(int index, int[] row) {
        int count = 0;
        for (int i = 0; i < row.length && row[i] == 1; i++) {
            count++;
        }
        return new int[]{index, count};
    }
}
