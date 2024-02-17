package uk.matvey.play.leet1642.kotlin1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    
    @Test
    fun case1() {
        val heights = intArrayOf(4, 2, 7, 6, 9, 14, 12)
        
        val result = Solution().furthestBuilding(heights, 5, 1)
        
        assertThat(result).isEqualTo(4)
    }
    
    @Test
    fun case2() {
        val heights = intArrayOf(4, 12, 2, 7, 3, 18, 20, 3, 19)
        
        val result = Solution().furthestBuilding(heights, 10, 2)
        
        assertThat(result).isEqualTo(7)
    }
    
    @Test
    fun case3() {
        val heights = intArrayOf(14, 3, 19, 3)
        
        val result = Solution().furthestBuilding(heights, 17, 0)
        
        assertThat(result).isEqualTo(3)
    }
}
