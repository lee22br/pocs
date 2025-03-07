import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class StreamConcept {

    public static void main (String [] args){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<People> girls = People.getSample();

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

        List<People> treeOrderAlfa = girls.stream().limit(3).sorted(Comparator.reverseOrder()).toList();
        List<People> filterP = girls.stream().filter(p -> p.getName().startsWith("Ana")).toList();
        List<People> filterAge = girls.stream().filter(p -> p.getAge()>22).sorted((p1, p2) -> Integer.compare(p1.getAge(),p2.getAge())).toList();
        System.out.print("treeOrderAlfa: ");
        treeOrderAlfa.forEach(n -> System.out.print(n.getName()+ ", "));
        System.out.print("\n FilterP: ");
        filterP.forEach(n -> System.out.print(n.getName()+", "));
        System.out.print("\n filterAge: ");
        filterAge.forEach(n -> System.out.print(n.getName()+"("+n.getAge()+"), "));
        //Map
        List<String> words = Arrays.asList("Oracle", "Java", "Magazine");
        List<Integer> wordLengths =   words.stream().map(String::length).toList();
        System.out.print("\n wordLengths: ");
        wordLengths.forEach(n -> System.out.print(n+","));
        //Map 2
        List<Integer> ageList = girls.stream().map(People::getAge).sorted().toList();
        System.out.print("\n ageList: ");
        ageList.forEach(n -> System.out.print(n+","));
    }



}
