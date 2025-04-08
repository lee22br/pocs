import java.util.Locale;
import java.util.Objects;
import java.util.function.Function;


public class FunctionalConcept {
    private static <T, R> void print(Function<T, R> function, T t ) {
        System.out.println(function.apply(t));
    }
    public static void main(String[] args) {
        Function <Integer, Integer> cube = x -> x * x * x;
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Cube ******");
        for (int j : array) {
            print(cube, j);
        }
        functionComposeExample(122);
    }

    //Function Compose
    private static void functionComposeExample(int number){
        Function<Integer, Integer> squared = x -> x * x;
        Function<Integer, Double> divByTwo = x -> (double) (x / 2);
        Function<Double, String> format= s -> String.format(Locale.US, "%,.2f", s);
        Function<String, String> addSimbol= s -> "$ "+s;
        Function<Integer, String> squaredDiv2Format = addSimbol.compose(format).compose(divByTwo).compose(squared);
        System.out.println(squaredDiv2Format.apply(number));
    }



}
