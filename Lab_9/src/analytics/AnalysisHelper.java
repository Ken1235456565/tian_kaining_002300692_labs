/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package analytics;

/**
 *
 * @author harshalneelkamal
 */

import data.DataStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Comment;
import model.Post;
import model.User;


public class AnalysisHelper {
    // Q1: Find Average number of likes per comment.
    public void getAverageLikesPerComments() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        int likeNumber = 0;
        int commentNumber = comments.size();
        for (Comment c : comments.values()) {
            likeNumber += c.getLikes();
        }
        
        System.out.println("Q1: Average number of likes per comments: " + likeNumber / commentNumber);
    }
    
    // Q2: Find the post with the most liked comment
    public void getPostWithMostLikedComment() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        Comment mostLikedComment = null;
        
        for (Comment c : comments.values()) {
            if (mostLikedComment == null || c.getLikes() > mostLikedComment.getLikes()) {
                mostLikedComment = c;
            }
        }
        
        if (mostLikedComment != null) {
            int postId = mostLikedComment.getPostId();
            Post post = DataStore.getInstance().getPosts().get(postId);
            System.out.println("Q2: Post with the most liked comment: Post " + post.getPostId() 
                    + " (Comment had " + mostLikedComment.getLikes() + " likes)");
        }
    }
    
    // Q3: Find the post with the most comments
    public void getPostWithMostComments() {
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        Post mostCommentedPost = null;
        
        for (Post p : posts.values()) {
            if (mostCommentedPost == null || p.getComments().size() > mostCommentedPost.getComments().size()) {
                mostCommentedPost = p;
            }
        }
        
        if (mostCommentedPost != null) {
            System.out.println("Q3: Post with the most comments: Post " + mostCommentedPost.getPostId() 
                    + " (" + mostCommentedPost.getComments().size() + " comments)");
        }
    }
    
    // Q4: Find 5 least active users based on total number of posts
    public void getLeastActiveUsersByPostCount() {
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        
        // Count posts per user
        HashMap<Integer, Integer> postNumbers = new HashMap<>();
        for (Post p : posts.values()) {
            int userId = p.getUserId();
            if (postNumbers.containsKey(userId)) {
                postNumbers.put(userId, postNumbers.get(userId) + 1);
            } else {
                postNumbers.put(userId, 1);
            }
        }
        
        // Create a list of users to sort
        ArrayList<User> userList = new ArrayList<>(users.values());
        
        // Sort users by post count
        Collections.sort(userList, new UserMapComparator(postNumbers));
        
        // Print 5 least active users
        System.out.println("Q4: 5 least active users based on post count:");
        int count = 0;
        for (User user : userList) {
            if (count >= 5) break;
            
            Integer postCount = postNumbers.get(user.getId());
            if (postCount == null) postCount = 0;
            
            System.out.println("User: " + user.getFirstName() + " " + user.getLastName() 
                    + ", Post count: " + postCount);
            count++;
        }
    }
    
    // Q5: Find 5 least active users based on total number of comments
    public void getLeastActiveUsersByCommentCount() {
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        
        // Create a list of users to sort
        ArrayList<User> userList = new ArrayList<>(users.values());
        
        // Create a map of comment counts
        HashMap<Integer, Integer> commentNumbers = new HashMap<>();
        for (User user : users.values()) {
            commentNumbers.put(user.getId(), user.getComments().size());
        }
        
        // Sort users by comment count
        Collections.sort(userList, new UserMapComparator(commentNumbers));
        
        // Print 5 least active users
        System.out.println("Q5: 5 least active users based on comment count:");
        int count = 0;
        for (User user : userList) {
            if (count >= 5) break;
            System.out.println("User: " + user.getFirstName() + " " + user.getLastName() 
                    + ", Comment count: " + user.getComments().size());
            count++;
        }
    }
    
    // Q6 & Q7: Find users based on overall activity (posts + comments + likes)
    public void getUsersByOverallActivity() {
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        
        // Calculate overall activity for each user
        HashMap<Integer, Integer> overallActivity = new HashMap<>();
        
        // Add comment count and likes
        for (Comment c : comments.values()) {
            int userId = c.getUserId();
            int activityPoints = 1 + c.getLikes(); // 1 for comment + number of likes
            
            if (overallActivity.containsKey(userId)) {
                overallActivity.put(userId, overallActivity.get(userId) + activityPoints);
            } else {
                overallActivity.put(userId, activityPoints);
            }
        }
        
        // Add post count
        for (Post p : posts.values()) {
            int userId = p.getUserId();
            
            if (overallActivity.containsKey(userId)) {
                overallActivity.put(userId, overallActivity.get(userId) + 1); // 1 point per post
            } else {
                overallActivity.put(userId, 1);
            }
        }
        
        // Create a list of users to sort
        ArrayList<User> userList = new ArrayList<>(users.values());
        
        // Sort users by overall activity
        Collections.sort(userList, new UserMapComparator(overallActivity));
        
        // Q6: Print 5 least active users overall
        System.out.println("Q6: 5 least active users based on overall activity:");
        int count = 0;
        for (User user : userList) {
            if (count >= 5) break;
            
            Integer activity = overallActivity.get(user.getId());
            if (activity == null) activity = 0;
            
            System.out.println("User: " + user.getFirstName() + " " + user.getLastName() 
                    + ", Overall activity: " + activity);
            count++;
        }
        
        // Q7: Print 5 most active users overall
        System.out.println("Q7: 5 most active users based on overall activity:");
        count = 0;
        for (int i = userList.size() - 1; i >= 0; i--) {
            if (count >= 5) break;
            
            User user = userList.get(i);
            Integer activity = overallActivity.get(user.getId());
            if (activity == null) activity = 0;
            
            System.out.println("User: " + user.getFirstName() + " " + user.getLastName() 
                    + ", Overall activity: " + activity);
            count++;
        }
    }
    
    // Comparator for sorting users based on a metric stored in a map
    private class UserMapComparator implements Comparator<User> {
        private Map<Integer, Integer> map;
        
        public UserMapComparator(Map<Integer, Integer> map) {
            this.map = map;
        }
        
        @Override
        public int compare(User o1, User o2) {
            Integer v1 = map.get(o1.getId());
            Integer v2 = map.get(o2.getId());
            
            // Handle null values (users with no activity)
            if (v1 == null) v1 = 0;
            if (v2 == null) v2 = 0;
            
            return v1.compareTo(v2);
        }
    }
}
