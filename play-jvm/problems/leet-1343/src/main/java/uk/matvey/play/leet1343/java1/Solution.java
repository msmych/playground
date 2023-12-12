package uk.matvey.play.leet1343.java1;

import java.util.stream.IntStream;

public class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        double average = IntStream.range(0, k)
            .mapToDouble(i -> (double) arr[i])
            .average()
            .getAsDouble();
        int num = 0;
        if (average >= threshold) {
            num++;
        }
        for (int i = k; i < arr.length; i++) {
            average += (double) (arr[i] - arr[i - k]) / (double) k;
            if (average >= threshold) {
                num++;
            }
        }
        return num;
    }
}
