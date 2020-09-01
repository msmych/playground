import static java.lang.Math.*;

public class Solution extends Reader4 {

    public int read(char[] buf, int n) {
        var buf4 = new char[4];
        var chars = 0;
        while (chars < n) {
            var chars4 = min(read4(buf4), n - chars);
            for (var j = 0; j < chars4; j++) {
                buf[chars + j] = buf4[j];
            }
            chars += chars4;
            if (chars4 < 4) {
                break;
            }
        }
        return min(n, chars);
    }
}

class Reader4 {

    int read4(char[] buf4) {
        return 0;
    }
}
