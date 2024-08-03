package sf;

import java.util.*;

public class E355 {
    class Twitter {

        public class Tweet{
            //文章类
            int id;
            int time;
            Tweet Next;

            public Tweet(int id, int time, Tweet next) {
                this.id = id;
                this.time = time;
                Next = next;
            }

            public int getId() {
                return id;
            }

            public int getTime() {
                return time;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setTime(int time) {
                this.time = time;
            }

        }

        public class User{
            //用户类
            int id;
            Set<Integer> followees = new HashSet<>();
            Tweet head = new Tweet(-1,-1,null);

            public User(int id) {
                this.id = id;
            }
        }

        private final Map<Integer,User> map = new HashMap<>();
        private int time;
        public void postTweet(int userId, int tweetId) {
            //创建文章

            User user = map.computeIfAbsent(userId, User::new);
            user.head.Next = new Tweet(tweetId, time++, user.head.Next);

        }

        public List<Integer> getNewsFeed(int userId) {
            //实际就是合并k个有序链表问题
            //解法一：两两合并
            //解法二：堆排序
            //解法二解答
            User user = map.get(userId);
            if (user==null){
                return List.of();
            }

            //比较器默认还是小顶堆，需要改,reversed()反转，原本由小到大，反转后由大到小
            PriorityQueue<Tweet> heap = new PriorityQueue<>(Comparator.comparingInt(Tweet::getTime).reversed());

            int count = 0;
            if (user.head.Next!=null){
                heap.offer(user.head.Next);
            }

            List<Integer> res = new ArrayList<>();
            for (Integer id : user.followees) {
                if (map.get(id).head.Next!=null){
                    heap.offer(map.get(id).head.Next);
                }
            }
            while(!heap.isEmpty()&&count<10){
                Tweet max = heap.poll();
                res.add(max.id);
                if (max.Next!=null){
                    heap.offer(max.Next);
                }
                count++;
            }
            return res;
        }

        public void follow(int followerId, int followeeId) {
            //添加关注
            User user = map.computeIfAbsent(followerId, User::new);
            User followee = map.computeIfAbsent(followeeId, User::new);
            user.followees.add(followee.id);

        }

        public void unfollow(int followerId, int followeeId) {
            //取消关注
            User user = map.get(followerId);
            if (user!=null){
                user.followees.remove(followeeId);
            }
        }
    }
}
