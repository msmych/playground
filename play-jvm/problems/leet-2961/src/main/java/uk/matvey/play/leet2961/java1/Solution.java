package uk.matvey.play.leet2961.java1;

import java.util.List;
import java.util.stream.IntStream;

public class Solution {

    private static final int[] P2 = new int[]{6, 2, 4, 8};
    private static final int[] P3 = new int[]{1, 3, 9, 7};
    private static final int[] P4 = new int[]{6, 4};
    private static final int[] P7 = new int[]{1, 7, 9, 3};
    private static final int[] P8 = new int[]{6, 8, 4, 2};
    private static final int[] P9 = new int[]{1, 9};

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        return IntStream.range(0, variables.length)
                .filter(i -> Math.pow(lastDigitOfPower(variables[i][0], variables[i][1]), variables[i][2] == 0 ? 0 : variables[i][2] % 4) % variables[i][3] == target)
                .boxed()
                .toList();
    }

    private int lastDigitOfPower(int n, int power) {
        final var d = n % 10;
        if (power == 0) {
            return d;
        }
        return switch (d) {
            case 2 -> P2[power % 4];
            case 3 -> P3[power % 4];
            case 4 -> P4[power % 2];
            case 7 -> P7[power % 4];
            case 8 -> P8[power % 4];
            case 9 -> P9[power % 2];
            default -> d;
        };
    }
}
