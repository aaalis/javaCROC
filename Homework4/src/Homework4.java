import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Homework4 {
    public static void main(String[] args) {
        int amount = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]))){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                while (line.contains("  ")) {
                    line = line.replace("  "," ");
                }
                String[] wordsLine = line.split("\\s+");
                amount += wordsLine.length;
            }
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException();
        }
        catch (IOException ioException) {
            System.out.println("Не удалось открыть файл");
        }
        if (amount != 0)
            System.out.println(amount);
    }
}
