package uk.matvey.play.leet1441.java1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var target = new int[]{1, 3};

        List<String> result = new Solution().buildArray(target, 3);

        assertThat(result).containsExactly("Push", "Push", "Pop", "Push");
    }

    @Test
    public void case2() {
        var target = new int[]{1, 2, 3};

        List<String> result = new Solution().buildArray(target, 3);

        assertThat(result).containsExactly("Push", "Push", "Push");
    }

    @Test
    public void case3() {
        var target = new int[]{1, 2};

        List<String> result = new Solution().buildArray(target, 4);

        assertThat(result).containsExactly("Push", "Push");
    }
}
