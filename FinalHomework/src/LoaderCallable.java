import java.util.List;
import java.util.concurrent.Callable;

/**
 * Класс, позволяющий читать данные из файлов в многопоточном режиме
 */
public class LoaderCallable implements Callable<List<? extends Entity>> {
    private String nameFile;
    private Class<? extends Entity[]> clss;

    public LoaderCallable(String nameFile, Class<? extends Entity[]> clss) {
        this.nameFile = nameFile;
        this.clss = clss;
    }

    @Override
    public List<? extends Entity> call(){
        return FileIO.loadFromJson(nameFile,clss);
    }
}
