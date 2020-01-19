import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> printVertically(String s) {
        return new ArrayList<>();
    }

    // java Solution.java "HOW ARE YOU" "[HAY,ORO,WEU]" "TO BE OR NOT TO BE" "[TBONTB,OEROOE,   T]" "CONTEST IS COMING" "[CIC,OSO,N M,T I,E N,S G,T]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().printVertically(s), expected, s));
        }
    }
}
