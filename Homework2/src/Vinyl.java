import java.util.ArrayList;

public class Vinyl extends Storage{
    public Vinyl(String name, ArrayList<Song> songs) {
        super(name, songs);
    }

    @Override
    public String toString() {
        return "Vinyl '"  + super.getName() + "'";
    }
    @Override
    public java.lang.String getClassName() {
        return "Vinyl";
    }
}
