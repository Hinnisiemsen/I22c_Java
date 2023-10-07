public class PhotoPost extends Post {
    private String filename;  // the name of the image file
    private String caption;   // a one line image caption


    public PhotoPost(String author, String filename, String caption){
        super(author);
        this.filename = filename;
        this.caption = caption;
    }
    public String getImageFile(){
        return filename;
    }
    public String getCaption() {
        return caption;
    }

    protected void displaySpecial() {
        super.display();
        System.out.println(filename);
        System.out.println(caption);
    }
}
