class Twitter {
    Map<Integer, List<int[]>> tweets;
    Map<Integer, Set<Integer>> following;
    int time;
    public Twitter() {
        time = 0;
        tweets = new HashMap<>();
        following  = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        List<int[]> newList = tweets.getOrDefault(userId, new ArrayList<>());
        newList.add(new int[]{time++,tweetId});
        tweets.put(userId, newList);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        List<int[]> tweetList = tweets.getOrDefault(userId, new ArrayList<>());
        List<int[]> newList = new ArrayList<>(tweetList);
    
        // List<Integer> follow = new ArrayList<>(following.getOrDefault(userId, new HashSet<>()));
        // for(int i=0;i<follow.size();i++)
        for(int followeeId : following.getOrDefault(userId, new HashSet<>())){
            newList.addAll(tweets.getOrDefault(followeeId, new ArrayList<>()));
        }
        System.out.println("NewsFeed" + newList);
        newList.sort((a,b)->b[0]-a[0]);
        for(int i=0;i<Math.min(10,newList.size());i++){
            newsFeed.add(newList.get(i)[1]);
        }
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId!=followeeId){
            Set<Integer> followingSet = following.getOrDefault(followerId, new HashSet<>());
            followingSet.add(followeeId);
            following.put(followerId, followingSet);
        }
        System.out.println(following.get(followerId));
    }
    
    public void unfollow(int followerId, int followeeId) {
        following.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
        // followingSet.remove(followeeId);
        // following.put(followerId, followingSet);

        System.out.println("Unfollow" + following.get(followerId));
    }
}
