import static java.lang.Math.min;
import static java.lang.Math.max;

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return area(A, B, C, D) + area(E, F, G, H) - intersection(A, B, C, D, E, F, G, H);
    }

    private int area(int x1, int y1, int x2, int y2) {
        return (x2 - x1) * (y2 - y1);
    }

    private int intersection(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (G > A && F < D && E < C && H > B || 
            E < C && F < D && G > A && H > B || 
            G > A && H > B && E < C && F < D || 
            E < C && H > B && G > A && F < D) {
            return area(max(A, E), max(B, F), min(C, G), min(D, H));
        }
        return 0;
    }

    // java Solution.java "-3" "0" "3" "4" "0" "-1" "9" "2" "45" -2 -2 2 2 3 3 4 4 17
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 9) {
            String A = args[i], B = args[i + 1], C = args[i + 2], D = args[i + 3], E = args[i + 4], F = args[i + 5], G = args[i + 6], H = args[i + 7], expected = args[i + 8];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: A = %s, B = %s, C = %s, D = %s, E = %s, F = %s, G = %s, H = %s",
                new Solution().computeArea(Integer.parseInt(A), Integer.parseInt(B), Integer.parseInt(C), Integer.parseInt(D), Integer.parseInt(E), Integer.parseInt(F), Integer.parseInt(G), Integer.parseInt(H)), expected, A, B, C, D, E, F, G, H));
        }
    }
}
