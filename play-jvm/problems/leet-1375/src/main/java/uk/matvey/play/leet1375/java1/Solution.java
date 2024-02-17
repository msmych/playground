package uk.matvey.play.leet1375.java1;

import java.util.HashSet;
import java.util.stream.IntStream;

public class Solution {

    public int numTimesAllBlue(int[] light) {
        int num = light[0] == 1 ? 1 : 0;
        var bulbs = new HashSet<Integer>();
        bulbs.add(light[0]);
        int max = light[0];
        for (int i = 1; i < light.length; i++) {
            bulbs.add(light[i]);
            if (light[i] > max) {
                max = light[i];
            }
            if (IntStream.range(1, max).allMatch(bulbs::contains)) {
                num++;
            }
        }
        return num;
    }
}
