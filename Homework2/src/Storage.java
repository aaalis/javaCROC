import java.util.ArrayList;

public abstract class Storage {

    private String name;
    public ArrayList<Song> songs;

    public Storage(String name, ArrayList<Song> songs) {
        this.name = name;
        this.songs = songs;
    }
    public Storage(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }

    public abstract String getClassName();
}