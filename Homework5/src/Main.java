import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Main {

    /**
     * Пример входной строки.
     */
    public static final String INPUT_STRING = "Невежество есть мать промышленности, как и суеверий." +
            " Сила размышления и воображения подвержена ошибкам; но привычка двигать рукой или ногой" +
            " не зависит ни от того, ни от другого. Поэтому мануфактуры лучше всего процветают там, где" +
            " наиболее подавлена духовная жизнь, так что мастерская может рассматриваться как машина," +
            " части которой составляют люди.";

    /**
     * Шаблон поиска символов в строке.
     */
    public static final String TEMPLATE = " ";

    public static final int nThread = 100;

    /**
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки.
     */
    public static void main(String[] args) throws InterruptedException {

        long current = System.currentTimeMillis();

        System.out.println("Count of space: " + countMatches(INPUT_STRING,TEMPLATE));

        System.out.println("Time: " + (System.currentTimeMillis() - current)+ " миллисекунд.");

    }

    private static long countMatches(String input_string, String template) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(nThread);

        /*
        Создание пула задач
         */
        List<MatcherCallable> matcherCallables = input_string.chars().
                mapToObj(x->new MatcherCallable(String.valueOf((char)x),template)).
                collect(Collectors.toList());
        /*
        Запуск пула задач и подсчет количества совпадений
         */
        long future = service.invokeAll(matcherCallables).stream().map(x-> {
            try {
                return x.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).filter(y->y).count();

        service.shutdown();

        return future;
    }

}