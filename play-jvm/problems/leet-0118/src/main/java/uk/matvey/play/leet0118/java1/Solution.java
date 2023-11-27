package uk.matvey.play.leet0118.java1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int numRows;

    public List<List<Integer>> generate(int numRows) {
        this.numRows = numRows;
        return generateNext(List.of(), 0);
    }

    private List<List<Integer>> generateNext(List<Integer> previous, int i) {
        if (i == numRows) {
            return new ArrayList<>();
        }
        var triangle = new ArrayList<List<Integer>>();
        var row = new ArrayList<Integer>();
        for (var j = 0; j <= i; j++) {
            row.add(j == 0 || j == i ? 1 : previous.get(j - 1) + previous.get(j));
        }
        triangle.add(row);
        triangle.addAll(generateNext(row, i + 1));
        return triangle;
    }
}
