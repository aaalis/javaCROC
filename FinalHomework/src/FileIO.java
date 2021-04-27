import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс, содержащий методы для работы с файлами
 */
public class FileIO {
    /**
     * Метод чтения данных из файла формата json
     * @param path - название/путь файла
     * @param clss - класс, на основе которого данные в файле будут создаваться в необходимый тип данных
     * @return
     */
    public static List<? extends Entity> loadFromJson(String path, Class <? extends Entity[]> clss) {
        Gson gson = new Gson();

        File file = new File(path);

        List<? extends Entity> result = new ArrayList<>();

        if (file.exists()) {
            try(FileReader fileReader = new FileReader(path)) {
                result = Arrays.stream(gson.fromJson(fileReader, clss)).collect(Collectors.toList());
            } catch (IOException e) {
                System.out.println("Не удалось прочесть данные с файла " + path);
            }
        }

        return result;
    }

    /**
     * Метод, позволяющий сохранять переданную коллекцию в формате json
     * @param list - список, который будет сериализоваться в json формат
     * @param path - название/путь файла
     */
    public static void saveToJson(List<?> list, String path) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter fileWriter = new FileWriter(path,false)) {
            fileWriter.write(gson.toJson(list));
        }
        catch (IOException e) {
            System.out.println("Не удалось записать в файл " + path);
        }
    }
}
