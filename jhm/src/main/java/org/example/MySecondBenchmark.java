package org.example;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Measurement(iterations = 1)
@State(Scope.Thread)
public class MySecondBenchmark {
    @Param({"100","1000000","10000000","50000000"})
    private int size;
    private List<Integer> data;

    @Setup
    public void setup() {
        data = IntStream.rangeClosed(1, size).boxed().collect(Collectors.toList());

    }

    private List<Double> computeParallel() {
        return data.parallelStream()
                        .map(Math::sqrt)
                        .map(Math::sin)
                        .map(Math::exp)
                        .collect(Collectors.toList());
    }

    private List<Double> compute() {

        return data.stream()
                .map(Math::sqrt)
                .map(Math::sin)
                .map(Math::exp)
                .collect(Collectors.toList());
    }

    /*
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


    public static void main(String[] args) throws IOException, RunnerException {
        Options opt = new OptionsBuilder()
                .include(org.example.MySecondBenchmark.class.getSimpleName())
                .warmupIterations(0)
                .measurementIterations(1)
                .forks(1)
                .threads(1)
                .build();
        new Runner(opt).run();
    }
}


