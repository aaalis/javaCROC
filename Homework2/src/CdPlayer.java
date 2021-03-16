import java.util.ArrayList;

public class CdPlayer extends Device{
    public CdPlayer(String name, ArrayList<String> storagesName) {
        super(name, storagesName);
    }
    @Override
    public String toString() {
        return "CdPlayer '"+super.getName() + "'";
    }
}
