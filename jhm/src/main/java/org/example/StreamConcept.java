package org.example;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;


public class StreamConcept {
    static List<People> girls = People.getSample(100000);
    public StreamConcept(){

    }

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
                .limit(2)
                .toList();


        List<People> treeOrderAlfa = girls.stream().limit(3).sorted(Comparator.reverseOrder()).toList();
        List<People> filterP = girls.stream().filter(p -> p.getName().startsWith("Ana")).toList();
        List<People> filterAge = girls.stream().filter(p -> p.getAge()>22).sorted(Comparator.comparingInt(People::getAge)).toList();
        System.out.print("twoEvenSquares: ");
        twoEvenSquares.forEach(n -> System.out.print(n+ ", "));
        System.out.print("\n treeReverseOrderAlfa: ");
        long start = System.currentTimeMillis();
        treeOrderAlfa.forEach(n -> System.out.print(n.getName()+ ", "));
        long elapsed = System.currentTimeMillis() - start;
        System.out.print("\n normal Elapsed: "+elapsed);
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

        // Infinit Stream
        Stream<Integer> numbers10 = Stream.iterate(0, n -> n + 10);
        //multi 10 (first 9)
        List<Integer> multi10 = numbers10.filter(n -> n!=0).limit(9).toList();
        System.out.print("\n First 9 numbers multi 10: ");
        multi10.forEach(n -> System.out.print(n+","));

        System.out.print("\n treeReverseOrderAlfa: ");
        treeOrderAlfa.forEach(n -> System.out.print(n.getName()+ ", "));
        System.out.print("\n parallel Elapsed: "+elapsed);
    }
;
    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Threads(8)
    public void parallelStream(){
        List<People> treeOrderAlfa = girls.parallelStream().sorted(Comparator.reverseOrder()).toList();
    }
    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Threads(8)
    public void normalStream(){
        List<People> treeOrderAlfa = girls.stream().sorted(Comparator.reverseOrder()).toList();
    }



}
