import java.util.ArrayList;

public class NewsFeed  {
    private ArrayList<IPost> posts;

    public NewsFeed() {
        posts = new ArrayList<>();
    }

    public void addPost(IPost post) {
        posts.add(post);
    }

    public void show() {
        for(IPost post : posts) {
            post.display();
            System.out.println();   // empty line between posts
        }
    }
}

