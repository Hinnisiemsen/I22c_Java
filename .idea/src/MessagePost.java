

public class MessagePost extends Post {
    private String message;   // an arbitrarily long, multi-line message

    public MessagePost(String author, String text)    {
        super(author);
        message = text;
    }
    public String getText()    {
        return message;
    }
    protected void displaySpecial() {
        super.display();
        System.out.println(message);
    }
}
