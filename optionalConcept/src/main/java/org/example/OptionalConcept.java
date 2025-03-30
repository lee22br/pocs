package org.example;

import java.util.Optional;

public class OptionalConcept {
    public static void main(String[] args) {
        String[] words = new String[10];

        Optional<String> checkNull = Optional.ofNullable(words[5]);

        if(checkNull.isPresent()){
            String word = words[5].toUpperCase();
            System.out.print(word);
        }else{
            System.out.println("word is null"+ " - "+"Optional = "+checkNull);
        }
        //Test static Optional Methods
        words[2] = "Optional - Test Statics Methods";
        Optional<String> empty = Optional.empty();
        System.out.println(empty);
        Optional<String> value = Optional.of(words[2]);
        System.out.println(value);
        //System.out.println("optional: "+Optional.of(words[1]));
        Optional<String[]> value2 = Optional.of(words);
        //System.out.println("optional: "+value2.get()[1].toLowerCase());
        System.out.println("optional null: "+Optional.ofNullable(value2.get()[1]));
        System.out.println("optional value: "+Optional.ofNullable(value2.get()[2]));

        //orElse vs orElseGet
        System.out.println(checkNull.orElse("orElse: Optional is empty, execute other"));
        System.out.println("orElse: The value is: "+value.orElse("orElse: Optional is empty, execute other"));

        System.out.println(checkNull.orElseGet(() -> "orElseGet: Optional is empty, execute other"));
        System.out.println("orElseGet: The value is: "+value.orElseGet(() -> "orElseGet: Optional is empty, execute other"));
    }

}
