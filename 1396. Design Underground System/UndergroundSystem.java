import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

class UndergroundSystem {

    private static class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    private final Map<Integer, CheckIn> checkIns = new HashMap<>();
    private final Map<Set<String>, Set<Integer>> stats = new HashMap<>();

    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t)); 
    }
    
    public void checkOut(int id, String stationName, int t) {
        var checkIn = checkIns.get(id);
        var stations = Set.of(checkIn.station, stationName);
        if (stats.containsKey(stations)) {
            stats.get(stations).add(t - checkIn.time);
        } else {
            Set<Integer> time = new HashSet<>();
            time.add(t - checkIn.time);
            stats.put(stations, time);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return stats.get(Set.of(startStation, endStation)).stream().mapToDouble(n -> n).average().orElse(0.0);
    }

    public static void main(String... args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        System.out.println(String.format("Output: %s | Expected: %s", undergroundSystem.getAverageTime("Paradise", "Cambridge"), 14.0));
        System.out.println(String.format("Output: %s | Expected: %s", undergroundSystem.getAverageTime("Leyton", "Waterloo"), 11.0));
        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println(String.format("Output: %s | Expected: %s", undergroundSystem.getAverageTime("Leyton", "Waterloo"), 11.0));
        undergroundSystem.checkOut(10, "Waterloo", 38);
        System.out.println(String.format("Output: %s | Expected: %s", undergroundSystem.getAverageTime("Leyton", "Waterloo"), 12.0));
    }
}
