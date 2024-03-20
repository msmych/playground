package uk.matvey.problems.leet1845

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.PriorityQueue

class SeatManager(n: Int) {

    private val seats = PriorityQueue<Pair<Int, Int>>(compareBy { (start, _) -> start })

    init {
        seats += 1 to n
    }

    fun reserve(): Int {
        val (start, end) = seats.poll()
        if (start + 1 <= end) {
            seats.offer(start + 1 to end)
        }
        return start
    }

    fun unreserve(seatNumber: Int) {
        val left = seats.find { (_, end) -> seatNumber == end + 1 }
        val right = seats.find { (start, _) -> seatNumber == start - 1 }
        if (left != null && right != null) {
            seats.remove(left)
            seats.remove(right)
            seats.offer(left.first to right.second)
        } else if (left != null) {
            seats.remove(left)
            seats.offer(left.first to seatNumber)
        } else if (right != null) {
            seats.remove(right)
            seats.offer(seatNumber to right.second)
        } else {
            seats.offer(seatNumber to seatNumber)
        }
    }
}

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
