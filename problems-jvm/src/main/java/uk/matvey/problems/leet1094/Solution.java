package uk.matvey.problems.leet1094;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private static class Position {
        int position;
        int passengers;
        boolean isPickUp;

        Position(int position, int passengers, boolean isPickUp) {
            this.position = position;
            this.passengers = passengers;
            this.isPickUp = isPickUp;
        }
    }

    public boolean carPooling(int[][] trips, int capacity) {
        var positions = new ArrayList<Position>();
        for (var trip : trips) {
            positions.add(new Position(trip[1], trip[0], true));
            positions.add(new Position(trip[2], trip[0], false));
        }
        positions.sort((p1, p2) -> {
            if (p1.position != p2.position) {
                return p1.position > p2.position ? 1 : -1;
            }
            if (!p1.isPickUp && p2.isPickUp) {
                return -1;
            }
            if (p1.isPickUp && !p2.isPickUp) {
                return 1;
            }
            return 0;
        });
        var passengers = 0;
        for (var p : positions) {
            if (p.isPickUp) {
                passengers += p.passengers;
            } else {
                passengers -= p.passengers;
            }
            if (passengers > capacity) {
                return false;
            }
        }
        return true;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var trips = new int[][]{{2, 1, 5}, {3, 3, 7}};

        boolean result = new Solution().carPooling(trips, 4);

        assertThat(result).isFalse();
    }

    @Test
    public void case2() {
        var trips = new int[][]{{2,1,5}, {3,3,7}};

        boolean result = new Solution().carPooling(trips, 5);

        assertThat(result).isTrue();
    }

    @Test
    public void case3() {
        var trips = new int[][]{{2,1,5},{3,5,7}};

        boolean result = new Solution().carPooling(trips, 3);

        assertThat(result).isTrue();
    }

    @Test
    public void case4() {
        var trips = new int[][]{{3,2,7},{3,7,9},{8,3,9}};

        boolean result = new Solution().carPooling(trips, 11);

        assertThat(result).isTrue();
    }
}
