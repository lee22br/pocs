package org.example;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Measurement(iterations = 1)
@State(Scope.Thread)
public class MyFirstBenchmark {
    @Param({"50000000","100000000"})
    private int size;
//    private List<Integer> data;
    private List<People> girls;

    @Setup
    public void setup() {
//        data = IntStream.rangeClosed(1, size).boxed().collect(Collectors.toList());
        girls = People.getSample(size);
    }
    private List<People> computeParallel() {
        return girls.parallelStream().filter(p -> p.getName().startsWith("Ana")).filter(p -> p.getAge()>22).sorted(Comparator.comparingInt(People::getAge)).sorted(Comparator.reverseOrder()).toList();
    }

//    private List<Double> computeParallelSin() {
//        return data.parallelStream().map(Math::sin).collect(Collectors.toList());
//    }

    private List<People> compute() {
        return girls.stream().filter(p -> p.getName().startsWith("Ana")).filter(p -> p.getAge()>22).sorted(Comparator.comparingInt(People::getAge)).sorted(Comparator.reverseOrder()).toList();
    }

//    private List<Double> computeSin(){
//        return data.stream().map(Math::sin).collect(Collectors.toList());
//    }

    /*
     * This demonstrates Option B:
     *
     * Use explicit Blackhole objects, and sink the values there.
     * (Background: Blackhole is just another @State object, bundled with JMH).
     */

    @Benchmark
    public void parallelStream(Blackhole bh) {
        bh.consume(computeParallel());
    }
    @Benchmark
    public void stream(Blackhole bh) {
        bh.consume(compute());
    }


    public static void main (String[] args) throws IOException, RunnerException {
        Options opt = new OptionsBuilder()
                .include(MyFirstBenchmark.class.getSimpleName())
                .warmupIterations(0)
                .measurementIterations(1)
                .forks(1)
                .threads(1)
                .build();
        new Runner(opt).run();

    }
}
