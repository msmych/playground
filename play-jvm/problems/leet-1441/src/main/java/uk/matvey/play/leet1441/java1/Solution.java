package uk.matvey.play.leet1441.java1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> buildArray(int[] target, int n) {
        var arr = new ArrayList<String>();
        for (int i = 0, e = 1; i < target.length && e <= n; e++) {
            arr.add("Push");
            if (target[i] == e) {
                i++;
            } else {
                arr.add("Pop");
            }
        }
        return arr;
    }
}
