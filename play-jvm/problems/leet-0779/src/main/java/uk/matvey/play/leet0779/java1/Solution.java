package uk.matvey.play.leet0779.java1;

class Solution {
    private int k, size = 1;

    public int kthGrammar(int N, int K) {
        for (int i = 1; i < N; i++) {
            size *= 2;
        }
        k = K;
        return next(N, "");
    }

    private int next(int n, String previous) {
        if (n == 0)
            return previous.charAt(k - 1) - '0';
        if (previous.isEmpty())
            return next(n - 1, "0");
        if (previous.length() > 1) {
            if (k <= size / 2)
                previous = previous.substring(0, 1);
            else {
                previous = previous.substring(1);
                k -= size / 2;
            }
            size /= 2;
        }
        return next(n - 1, previous.equals("0") ? "01" : "10");
    }
}
