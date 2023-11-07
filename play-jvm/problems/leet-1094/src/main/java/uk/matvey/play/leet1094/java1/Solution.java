package uk.matvey.play.leet1094.java1;

import java.util.ArrayList;

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
