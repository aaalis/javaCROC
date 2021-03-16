public class Song {

    private String name;
    private String author;

    public Song(String author, String name) {
        this.author = author;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return author + " '" + name + "' ";
    }
}