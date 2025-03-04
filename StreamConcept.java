import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class StreamConcept {

    public static void main (String [] args){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<String> names = Arrays.asList("Ana","Joao","Bruna","Pedro");

        List<Integer> twoEvenSquares =   numbers.stream()
                .filter(n -> {
                    System.out.println("filtering " + n);
                    return n % 2 == 0;
                })
                .map(n -> {
                    System.out.println("mapping " + n);
                    return n * n;
                })
                .limit(3)
                .toList();

        List<String> treeOrderAlfa = names.stream().limit(3).sorted().toList();
        twoEvenSquares.forEach(n -> System.out.println("List " + n));
        treeOrderAlfa.forEach(n -> System.out.println("Names " + n));
    }


}
