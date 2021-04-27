import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * Класс, содержащий коллекции , созданные из прочитаных из файлов данных
 */
public class Data {

    public List<Good> goodList;
    public List<Seller> sellerList;
    public List<Contract> contractList;
    public List<SellerAssortment> sellerAssortmentList;

    private final List<MyTuple<String,Class>> myTuples = Arrays.asList(
                    new MyTuple<>("json/input/Goods.json",Good[].class),
                    new MyTuple<>("json/input/Sellers.json",Seller[].class),
                    new MyTuple<>("json/input/Contracts.json",Contract[].class),
                    new MyTuple<>("json/input/SellersAssortment.json",SellerAssortment[].class));

    public Data() throws InterruptedException {
        List<List<? extends Entity>> lists = parallelLoad();
        this.goodList = (List<Good>) lists.get(0);
        this.sellerList = (List<Seller>) lists.get(1);
        this.contractList = (List<Contract>) lists.get(2);
        this.sellerAssortmentList = (List<SellerAssortment>) lists.get(3);

    }

    /**
     * Метод для многопоточного прочтения данных из файлов
     * @return Возвращает список коллекций с десериализованными сущностями
     */
    private List<List<? extends Entity>> parallelLoad() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(myTuples.size());

        List<LoaderCallable> loaderCallables = myTuples.stream().
                map(x->new LoaderCallable(x.getNameFile(), x.getClss())).
                collect(Collectors.toList());

        List<List<? extends Entity>> lists = service.invokeAll(loaderCallables).stream().map(x-> {
            try {
                return x.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());

        service.shutdown();
        return lists;
    }
}
