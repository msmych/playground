package uk.matvey.play.leet1424.java1;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Solution {
    private static class Diagonal {
        int sum, row, val;

        Diagonal(int sum, int row, int val) {
            this.sum = sum;
            this.row = row;
            this.val = val;
        }
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        var diagonals = new HashSet<Diagonal>();
        for (var i = 0; i < nums.size(); i++) {
            var row = nums.get(i);
            for (var j = 0; j < row.size(); j++) {
                diagonals.add(new Diagonal(i + j, i, row.get(j)));
            }
        }
        return diagonals.stream()
            .sorted(Comparator.comparingInt((Diagonal d) -> d.sum)
                .thenComparing(Comparator.comparingInt((Diagonal d) -> d.row).reversed()))
            .mapToInt(d -> d.val)
            .toArray();
    }

}
