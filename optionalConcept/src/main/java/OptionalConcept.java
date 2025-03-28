import java.util.Optional;

public class OptionalConcept {
    public static void main(String[] args) {
        String[] words = new String[10];

        Optional<String> checkNull = Optional.ofNullable(words[5]);

        if(checkNull.isPresent()){
            String word = words[5].toLowerCase();
            System.out.print(word);
        }else{
            System.out.println("word is null");
        }
        words[2] = "Test with some string";
        Optional<String> empty = Optional.empty();
        System.out.println(empty);
        Optional<String> value = Optional.of(words[2]);
        System.out.println(value);
        //System.out.println("optional: "+Optional.of(words[1]));
        Optional<String[]> value2 = Optional.of(words);
        //System.out.println("optional: "+value2.get()[1].toLowerCase());
        System.out.println("optional null: "+Optional.ofNullable(value2.get()[1]));
        System.out.println("optional value: "+Optional.ofNullable(value2.get()[2]));
    }

}
