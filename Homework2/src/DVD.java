import java.util.ArrayList;

public class DVD extends Storage{
    public DVD(String name, ArrayList<Song> songs) {
        super(name, songs);
    }

    @Override
    public String toString() {
        return "DVD '"  + super.getName() + "'";
    }
    @Override
    public java.lang.String getClassName() { return "DVD"; }
}
