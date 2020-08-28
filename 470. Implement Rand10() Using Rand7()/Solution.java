import java.util.*;

import static java.util.stream.Collectors.*;
import static java.util.stream.IntStream.*;

class Solution extends SolBase {

    public int rand10() {
        int a = -1, b = -1, r7 = rand7();
        while (r7 > 2) {
            r7 = rand7();
        }
        a = r7;
        r7 = rand7();
        while (r7 > 5) {
            r7 = rand7();
        }
        b = r7;
        return 5 * (a - 1) + b;
    }

    public static void main(String... args) {
        var s = new Solution();
        System.out.println(generate(s::rand10).limit(1000).boxed().collect(groupingBy(i -> i, counting())));
    }
}

// ~~~
class SolBase {
    
    private Random rand = new Random();

    int rand7() {
        return rand.nextInt(7) + 1;
    }
}
