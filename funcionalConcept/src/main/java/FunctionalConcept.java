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
    }

}
