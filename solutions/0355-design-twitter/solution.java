class Twitter {

     // defines userId --> List of Tweets
    Map<Integer, List<Tweet>> tweets;
    Map<Integer, Set<Integer>> followeeMap;
    static int timeStamp;
    int feedMax;

    public Twitter() {
        tweets = new HashMap<>();
        followeeMap = new HashMap<>();
        feedMax = 10;
        timeStamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new LinkedList<Tweet>());
            // follow it self
            follow(userId, userId);
        }
        // add new tweet if already tweeted
        tweets.get(userId).add(0, new Tweet(tweetId, timeStamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        // PQ for recent tweets
        PriorityQueue<Tweet> feedheap = new PriorityQueue<>((t1, t2) -> t1.timePosted - t2.timePosted);

        // find followees
        Set<Integer> myFollowees = followeeMap.get(userId);
        if (myFollowees != null) {
            for (int followeeId : myFollowees) {
                List<Tweet> followeeTweet = tweets.get(followeeId);
                if (followeeTweet == null) {
                    continue;
                }

                for (Tweet tweet : followeeTweet) {
                    if (feedheap.size() < feedMax) {
                        feedheap.add(tweet);
                    } else {
                        if (tweet.timePosted <= feedheap.peek().timePosted){
                            break; // no need to add as tweets are older
                        } else {feedheap.add(tweet);
                            feedheap.poll();
                            
                        }
                    }
                }
            }
        }

        List<Integer> myFeed = new LinkedList<>();
        while (!feedheap.isEmpty()) {
            myFeed.add(0,feedheap.poll().id);
        }

        return myFeed;
    }

    public void follow(int followerId, int followeeId) {
        if (!followeeMap.containsKey(followerId)) {
            followeeMap.put(followerId, new HashSet<>());
        }
        followeeMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!followeeMap.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        followeeMap.get(followerId).remove(followeeId);
    }

    static class Tweet {
        int id;
        int timePosted;

        public Tweet(int id, int timePosted) {
            this.id = id;
            this.timePosted = timePosted;
        }

                @Override
        public String toString() {
            return "Tweet{" +
                    "id=" + id +
                    ", timePosted=" + timePosted +
                    '}';
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
