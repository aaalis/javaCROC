import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 7 вариант
 *
 * Задание 1.
 * Для каждого товара вывести в файл продавца, у которого наименьшая цена на этот товар, и саму
 * цену на этот товар у этого продавца.
 *
 * Задание 2.
 * Вывести в файл топ 5 дат, в которые было продано наибольшее количество товаров
 *
 * Форматы фойлов:
 * Входной файл - JSON
 * Выходной файл - JSON
 *
 * @author Алексей Истомин
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Data data = new Data();

        List<Task1> task1 = findLowestPrice(data.sellerAssortmentList,data.goodList,data.sellerList);

        List<Task2> task2 = findDateMostSoldGoods(data.contractList,5);

        FileIO.saveToJson(task1,"json/output/Task1.json");

        FileIO.saveToJson(task2,"json/output/Task2.json");
    }

    /**
     * Метод для поиска самой низкой цены на товары
     * @param sellerAssortmentList - список, содержащий ассортименты, из которого будут браться товары и цены
     * @param goodList - список, содержащий товары
     * @param sellerList - список, содержащий продавцов
     * @return список объектов {@link Task1}
     */
    public static List<Task1> findLowestPrice(List<SellerAssortment> sellerAssortmentList,
                                              List<Good> goodList,
                                              List<Seller> sellerList){
        List<Task1> result = new ArrayList<>();
        //Выделение товаров, которые можно встретить в ассортиментах продавцов
        List<Integer> idsGood = sellerAssortmentList.stream()
                .map(SellerAssortment::getIdGood)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        //Заполнение списка result объектами Task1, которые созданы на основе найденных объктов
        for (Integer id: idsGood) {

            Good good = goodList.stream()
                    .filter(x->x.getIdGood()==id)
                    .findFirst()
                    .orElseThrow(RuntimeException::new);

            double price = sellerAssortmentList.stream()
                    .filter(x->x.getIdGood() == id)
                    .map(SellerAssortment::getPrice)
                    .min(Double::compareTo)
                    .orElseThrow(RuntimeException::new);

            Seller seller = sellerAssortmentList.stream()
                    .filter(y->y.getPrice()==price)
                    .findFirst()
                    .map(SellerAssortment::getIdSeller)
                    .map(idSeller -> sellerList.stream()
                            .filter(s->s.getIdSeller()==idSeller)
                            .findAny()
                            .orElseThrow(RuntimeException::new))
                    .orElseThrow(RuntimeException::new);

            result.add(new Task1(good,seller,price));
        }
        return result;
    }

    /**
     * Метод нахождения дат, в которые было продано наибольшее количество товаров
     * @param contractList - список, содержащий контракты
     * @param limit - количество дат, взятых в порядке убывания
     * @return список обЪектов {@link Task2}
     */
    private static List<Task2> findDateMostSoldGoods(List<Contract> contractList, int limit) {
        List<Task2> result = new ArrayList<>();
        //Выделение уникальных дат
        List<LocalDate> localDates = contractList.stream()
                .map(Contract::getDateTime)
                .map(LocalDateTime::toLocalDate)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        //Заполнение списка result объектами Task2,которые созданы на основе найденных значений
        for (LocalDate localDate:localDates) {
            int quantitySoldGoods = contractList.stream()
                    .filter(x->x.getDateTime().toLocalDate().equals(localDate))
                    .mapToInt(Contract::getQuantityGood)
                    .sum();

            result.add(new Task2(localDate,quantitySoldGoods));
        }
        Collections.sort(result);

        return result.stream()
                .limit(limit)
                .collect(Collectors.toList());
    }
}
