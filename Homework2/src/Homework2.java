import java.util.ArrayList;
import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        //region testData
        ArrayList<String> vinylStorageName = new ArrayList<String>();
        vinylStorageName.add("Vinyl");
        VinylPlayer vinylPlayer = new VinylPlayer("ION Audio Trio LP",vinylStorageName);

        ArrayList<String> cdPlayerStorageName = new ArrayList<String>();
        cdPlayerStorageName.add("CD");
        CdPlayer cdPlayer = new CdPlayer("Lauson CP555",cdPlayerStorageName);

        ArrayList<String> audioSystemStorageName = new ArrayList<String>();
        audioSystemStorageName.add("CD");
        audioSystemStorageName.add("DVD");
        AudioSystem audioSystem = new AudioSystem("LG CM 1560",audioSystemStorageName);

        ArrayList<Device> devices = new ArrayList<Device>();
        devices.add(vinylPlayer);
        devices.add(cdPlayer);
        devices.add(audioSystem);

        Song song1 = new Song("Gorillaz","Feel Good Inc.");
        Song song2 = new Song("Gorillaz","Kids with Guns");
        Song song3 = new Song("Gorillaz","Dirty Harry");
        ArrayList<Song> songVinyl = new ArrayList<Song>();
        songVinyl.add(song1);
        songVinyl.add(song2);
        songVinyl.add(song3);
        Vinyl vinyl = new Vinyl("Demon Days",songVinyl);

        Song song4 = new Song("Dabeull","TR 707");
        Song song5 = new Song("Dabeull","DX7");
        ArrayList<Song> songCd = new ArrayList<Song>();
        songCd.add(song4);
        songCd.add(song5);
        CD cd = new CD("Dabeull", songCd);

        Song song6 = new Song("Crystal Castles", "Crimewave");
        ArrayList<Song> songDvd = new ArrayList<Song>();
        songDvd.add(song6);
        DVD dvd = new DVD("Electronic music", songDvd);

        ArrayList<Storage> storages = new ArrayList<Storage>();
        storages.add(vinyl);
        storages.add(cd);
        storages.add(dvd);

        //endregion

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберете устройство воспроизведения");
        int i = 1;
        for (Device device : devices) {
            System.out.println(i + "." + device.toString());
            i++;
        }
        int inputDevice= Integer.parseInt(scanner.nextLine());

        System.out.println("Выберете носитель");
        int j = 1;
        for (Storage storage : storages) {
            System.out.println(j + "." + storage.toString());
            j++;
        }
        int inputStorage= Integer.parseInt(scanner.nextLine());
        System.out.println(devices.get(inputDevice-1).play(storages.get(inputStorage-1)));
    }
}