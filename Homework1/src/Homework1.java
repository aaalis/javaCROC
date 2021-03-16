/**
 * @version 1
 * @author Alexey Istomin
 */

public class Homework1 {
    public static void main(String[] args) {
        int num = 1;
        int limit = 100;
        for (; num <= limit ; num++) {
            if (num % 3 == 0) {
                if (num % 5 == 0) {
                    System.out.println("FizzBuzz");
                    continue;
                }
                else {
                    System.out.println("Fizz");
                    continue;
                }
            }
            if (num % 5 == 0) {
                System.out.println("Buzz");
                continue;
            }
            System.out.println(num);
        }
    }
}
