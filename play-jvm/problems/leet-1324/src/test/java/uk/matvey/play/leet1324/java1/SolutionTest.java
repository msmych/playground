package uk.matvey.play.leet1324.java1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        List<String> result = new Solution().printVertically("HOW ARE YOU");

        assertThat(result).containsExactly("HAY", "ORO", "WEU");
    }

    @Test
    public void case2() {
        List<String> result = new Solution().printVertically("TO BE OR NOT TO BE");

        assertThat(result).containsExactly("TBONTB", "OEROOE", "   T");
    }

    @Test
    public void case3() {
        List<String> result = new Solution().printVertically("CONTEST IS COMING");

        assertThat(result).containsExactly("CIC", "OSO", "N M", "T I", "E N", "S G", "T");
    }
}
