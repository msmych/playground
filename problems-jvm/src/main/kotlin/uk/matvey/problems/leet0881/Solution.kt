package uk.matvey.problems.leet0881

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Solution {

    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var i = 0
        var j = people.size - 1
        var count = 0
        while (i <= j) {
            if (people[j] + people[i] <= limit) {
                i++
            }
            j--
            count++
        }
        return count
    }
}

class SolutionTest {

    @Test
    fun case1() {
        assertThat(Solution().numRescueBoats(intArrayOf(1, 2), 3)).isEqualTo(1)
    }

    @Test
    fun case2() {
        assertThat(Solution().numRescueBoats(intArrayOf(3, 2, 2, 1), 3)).isEqualTo(3)
    }

    @Test
    fun case3() {
        assertThat(Solution().numRescueBoats(intArrayOf(3, 5, 3, 4), 5)).isEqualTo(4)
    }

    @Test
    fun case4() {
        assertThat(Solution().numRescueBoats(intArrayOf(2, 4), 5)).isEqualTo(2)
    }
}
