import java.util.*;
import java.time.*;
import java.util.stream.*;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

class Twitter {

    private static class User {
        int id;
        Map<Integer, Instant> tweets = new HashMap<>();
        Map<Integer, User> following = new HashMap<>();

        User(int id) {
            this.id = id;
        }

        User(int id, int tweetId) {
            this.id = id;
            this.tweets.put(tweetId, Instant.now());
        }
    }
    
    private final Set<User> users = new HashSet<>();

    public Twitter() {}
    
    public void postTweet(int userId, int tweetId) {
        findUser(userId).ifPresentOrElse(
            user -> user.tweets.put(tweetId, Instant.now()),
            () -> users.add(new User(userId, tweetId)));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        return findUser(userId).stream()
            .flatMap(user -> Stream.concat(
                user.tweets.entrySet().stream(), 
                user.following.values().stream()
                    .filter(followee -> followee.id != user.id)
                    .flatMap(followee -> followee.tweets.entrySet().stream())))
            .sorted(comparing(Map.Entry::getValue, reverseOrder()))
            .map(Map.Entry::getKey)
            .limit(10)
            .collect(toList());
    }
    
    public void follow(int followerId, int followeeId) {
        var follower = findUser(followerId)
            .orElseGet(() -> {
                var user = new User(followerId);
                users.add(user);
                return user;
            });
        var followee = findUser(followeeId)
            .orElseGet(() -> {
                var user = new User(followeeId);
                users.add(user);
                return user;
            });
        follower.following.put(followeeId, followee);
    }
    
    public void unfollow(int followerId, int followeeId) {
        findUser(followerId)
            .ifPresent(follower -> follower.following.remove(followeeId));
    }

    private Optional<User> findUser(int id) {
        return users.stream()
            .filter(user -> user.id == id)
            .findAny();
    }

    public static void main(String... args) {
        var twitter = new Twitter();
        twitter.postTweet(1, 5);
        System.out.println(String.format("Output: %s | Expected: %s", twitter.getNewsFeed(1), "[5]"));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(String.format("Output: %s | Expected: %s", twitter.getNewsFeed(1), "[6, 5]"));
        twitter.unfollow(1, 2);
        System.out.println(String.format("Output: %s | Expected: %s", twitter.getNewsFeed(1), "[5]"));
    }
}
