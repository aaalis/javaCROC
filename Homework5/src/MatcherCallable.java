import java.util.concurrent.Callable;

/**
 * Класс для многопоточного нахождения количества символа в строке
 */
public class MatcherCallable implements Callable<Boolean> {
    private String input_char;
    private String template;

    public MatcherCallable(String input_char, String template) {
        this.input_char = input_char;
        this.template = template;
    }

    @Override
    public Boolean call(){
        return Matcher.match(input_char,template);
    }
}
