package uk.matvey.problems.leet0948;

import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        var deque = new ArrayDeque<Integer>();
        Arrays.stream(tokens).sorted().forEach(deque::offer);
        while (!deque.isEmpty()) {
            if (power >= deque.peek()) {
                power -= deque.pop();
                score++;
            } else if (score > 0 && deque.size() > 1 && power + deque.getLast() >= deque.getFirst()) {
                power += deque.removeLast();
                score--;
            } else {
                break;
            }
        }
        return score;
    }
}
