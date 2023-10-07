import java.util.ArrayList;

public abstract class Post implements IPost {
    private String username;
    private long timestamp;
    private int likes;
    private ArrayList<String> comments;
    public Post(String author) {
        this.username = author;
        timestamp = System.currentTimeMillis();
        likes = 0;
        comments = new ArrayList<>();
    }
    public void like() {
        likes++;
    }
    public void unlike()    {
        if (likes > 0) {
            likes--;
        }
    }
    protected String timeString(long time){
        long current = System.currentTimeMillis();
        long pastMillis = current - time;      // time passed in milliseconds
        long seconds = pastMillis/1000;
        long minutes = seconds/60;
        if(minutes > 0) {
            return minutes + " minutes ago";
        }
        else {
            return seconds + " seconds ago";
        }
    }
    public long getTimeStamp() {
        return timestamp;
    }
    public void addComment(String text)  {
        comments.add(text);
    }
    public void display() {
        System.out.println(username);
        this.displaySpecial();
        System.out.print(timeString(timestamp));
        if(likes > 0) {
            System.out.println("  -  " + likes + " people like this.");
        } else {
            System.out.println();
        }
        if(comments.isEmpty()) {
            System.out.println("   No comments.");
        } else {
            System.out.println("   " + comments.size() + " comment(s). Click here to view.");
        }
    }
    protected void displaySpecial() {

    }
}
