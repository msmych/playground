package uk.matvey.play.leet2038.kotlin1

class Solution {
    fun winnerOfGame(colors: String): Boolean {
        var aCount = 0
        var bCount = 0
        var i = 0
        while (i < colors.length) {
            var count = 0
            val color = colors[i]
            while (i + count < colors.length && colors[i + count] == color) {
                count++
            }
            if (count >= 3) {
                if (color == 'A') {
                    aCount += count - 2
                } else {
                    bCount += count - 2
                }
            }
            i += count
        }
        return aCount > bCount
    }
}
