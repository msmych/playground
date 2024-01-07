package uk.matvey.play.leet1531.kotlin1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun case1() {
        assertThat(Solution().getLengthOfOptimalCompression("aaabcccd", 2)).isEqualTo(4)
    }

    @Test
    fun case2() {
        assertThat(Solution().getLengthOfOptimalCompression("aabbaa", 2)).isEqualTo(2)
    }

    @Test
    fun case3() {
        assertThat(Solution().getLengthOfOptimalCompression("aaaaaaaaaaa", 0)).isEqualTo(3)
    }
}