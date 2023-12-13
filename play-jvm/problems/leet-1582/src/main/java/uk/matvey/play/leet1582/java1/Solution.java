package uk.matvey.play.leet1582.java1;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution {
    public int numSpecial(int[][] mat) {
        var special = 0;
        Set<Integer> excludedRows = new HashSet<>();
        var excludedCols = new HashSet<Integer>();
        for (var i = 0; i < mat.length; i++) {
            if (excludedRows.contains(i)) {
                continue;
            }
            for (var j = 0; j < mat[i].length; j++) {
                if (excludedCols.contains(j)) {
                    continue;
                }
                if (mat[i][j] == 0) {
                    continue;
                }
                int row = i, col = j;
                if (IntStream.range(0, mat.length).filter(k -> k != row).anyMatch(k -> mat[k][col] == 1)) {
                    excludedRows.add(i);
                    continue;
                }
                if (IntStream.range(0, mat[i].length).filter(k -> k != col).anyMatch(k -> mat[row][k] == 1)) {
                    excludedCols.add(j);
                    continue;
                }
                special++;
            }
        }
        return special;
    }
}
