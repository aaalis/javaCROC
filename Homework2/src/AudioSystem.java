import java.util.ArrayList;

public class AudioSystem extends Device{
    public AudioSystem(String name, ArrayList<String> storagesName) {
        super(name, storagesName);
    }
    @Override
    public String toString() {
        return "AudioSystem '"+super.getName() + "'";
    }
}
