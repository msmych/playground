package uk.matvey.play.leet0119.java1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        return nextRow(new ArrayList<>(), rowIndex);
    }

    private List<Integer> nextRow(List<Integer> previous, int rowIndex) {
        if (rowIndex < 0) {
            return previous;
        }
        var row = new ArrayList<Integer>();
        for (var i = 0; i <= previous.size(); i++) {
            row.add(i == 0 || i == previous.size() ? 1 : previous.get(i - 1) + previous.get(i));
        }
        return nextRow(row, rowIndex - 1);
    }
}
