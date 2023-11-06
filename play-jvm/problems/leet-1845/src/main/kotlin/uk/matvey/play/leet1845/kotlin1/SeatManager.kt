package uk.matvey.play.leet1845.kotlin1

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
