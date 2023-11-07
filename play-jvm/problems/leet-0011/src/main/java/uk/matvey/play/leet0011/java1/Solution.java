package uk.matvey.play.leet0011.java1;

public class Solution {
    public int maxArea(int[] height) {
        var maxArea = 0;
        for (var i = 0; i < height.length - 1; i++) {
            for (var j = i + 1; j < height.length; j++) {
                var area = (j - i) * Math.min(height[i], height[j]);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}
