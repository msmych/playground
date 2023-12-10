package uk.matvey.play.leet1342.java1;

public class Solution {
    public int numberOfSteps (int num) {
        int steps = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            steps++;
        }
        return steps;
    }
}
