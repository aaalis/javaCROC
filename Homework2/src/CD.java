import java.util.ArrayList;

public class CD extends Storage{
    public CD(String name, ArrayList<Song> songs) {
        super(name, songs);
    }

    @Override
    public String toString() {
        return "CD '" + super.getName() + "'";
    }
    @Override
    public java.lang.String getClassName() { return "CD"; }
}
