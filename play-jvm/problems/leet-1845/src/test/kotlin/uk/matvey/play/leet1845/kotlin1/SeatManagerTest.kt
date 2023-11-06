package uk.matvey.play.leet1845.kotlin1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SeatManagerTest {

    @Test
    fun case1() {
        val seatManager = SeatManager(5)

        assertThat(seatManager.reserve()).isEqualTo(1)
        assertThat(seatManager.reserve()).isEqualTo(2)
        seatManager.unreserve(2)
        assertThat(seatManager.reserve()).isEqualTo(2)
        assertThat(seatManager.reserve()).isEqualTo(3)
        assertThat(seatManager.reserve()).isEqualTo(4)
        assertThat(seatManager.reserve()).isEqualTo(5)
        seatManager.unreserve(5)
    }
}
