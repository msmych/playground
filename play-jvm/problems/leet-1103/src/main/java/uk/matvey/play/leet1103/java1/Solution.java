package uk.matvey.play.leet1103.java1;

public class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        var distribution = new int[num_people];
        int c = 1, i = 0;
        while (candies >= c) {
            for (i = 0; i < num_people && candies >= c; i++) {
                distribution[i] += c;
                candies -= c++;
            }
        }
        distribution[i % num_people] += candies;
        return distribution;
    }
}
