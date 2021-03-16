import java.util.ArrayList;

public abstract class Device {

    private String name;
    private ArrayList<String> storagesName; // Содержит названия носителей, которые устройство можно воспроизвести

    public Device(String name, ArrayList<String> storagesName) {
        this.name = name;
        this.storagesName = storagesName;
    }
    public Device(String name) {
        this.name = name;
    }
    public Device() { }

    public void setStoragesName(ArrayList<String> storagesName) {
        this.storagesName = storagesName;
    }
    public ArrayList<String> getStoragesName() {
        return this.storagesName;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String play(Storage storage) {
        if (storagesName.contains(storage.getClassName())) {
            return toString() + " воспроизводит " + storage.songs.get(0).toString() + "с устройства " + storage.toString();
        } else {
            return toString() + " не может воспроизвести с устройства " + storage.toString();
        }
    }
}