import java.util.ArrayList;

public class VinylPlayer extends Device{
    public VinylPlayer(String name, ArrayList<String> storagesName) {
        super(name, storagesName);
    }
    @Override
    public String toString() {
        return "VinylPlayer '" + super.getName() + "'";
    }
}