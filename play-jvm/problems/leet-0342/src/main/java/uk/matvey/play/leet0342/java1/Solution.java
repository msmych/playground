package uk.matvey.play.leet0342.java1;

class Solution {
    public boolean isPowerOfFour(int n) {
        return Integer.toString(n, 4).matches("^10*$");
    }
}
