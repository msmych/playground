package uk.matvey.play.leet1348.java1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TweetCounts {

    private final Map<String, List<Integer>> tweetTimes = new HashMap<>();

    public TweetCounts() {
    }

    public void recordTweet(String tweetName, int time) {
        if (tweetTimes.containsKey(tweetName)) {
            tweetTimes.get(tweetName).add(time);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(time);
            tweetTimes.put(tweetName, list);
        }
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int delta = seconds(freq);
        List<Integer> tweets = new ArrayList<>();
        for (int time = startTime; time <= endTime; time += delta) {
            int t = time;
            tweets.add((int) tweetTimes.get(tweetName).stream()
                    .filter(tweetTime -> tweetTime >= t)
                    .filter(tweetTime -> tweetTime <= Math.min(t + delta - 1, endTime))
                    .count());
        }
        return tweets;
    }

    private int seconds(String freq) {
        int time = 1;
        switch (freq) {
            case "day":
                time *= 24;
            case "hour":
                time *= 60;
            case "minute":
                time *= 60;
        }
        return time;
    }
}
