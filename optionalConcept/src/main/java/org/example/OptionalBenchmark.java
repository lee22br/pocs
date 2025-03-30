package org.example;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Measurement(iterations = 10)
@State(Scope.Thread)
public class OptionalBenchmark {

    private final String[] names = {"Ana","Bruna","Cintia","Daniele","Fernanda","Ana Clara", "Ana Bia", "Ana Maria"};
    @Setup
    public void setup()
    {

    }
    public String getRandomName() {
        Random random = new Random();
        int index = random.nextInt(8);
        return names[index];
    }
    public String orElseBenchmark() {
        return Optional.of("orElse").orElse(getRandomName());
    }
    public String orElseGetBenchmark() {
        return Optional.of("orElseGet").orElseGet(this::getRandomName);
    }

     /*
     * Use Blackhole
     *
     * Use explicit Blackhole objects, and sink the values there.
     * (Background: Blackhole is just another @State object, bundled with JMH).
     */

    @Benchmark
    public void orElse(Blackhole bh) {
        bh.consume(orElseBenchmark());
    }
    @Benchmark
    public void orElseGet(Blackhole bh) {
        bh.consume(orElseGetBenchmark());
    }


    public static void main (String[] args) throws IOException, RunnerException {
        Options opt = new OptionsBuilder()
                .include(OptionalBenchmark.class.getSimpleName())
                .warmupIterations(0)
                .measurementIterations(10)
                .forks(1)
                .threads(1)
                .build();
        new Runner(opt).run();

    }
}
