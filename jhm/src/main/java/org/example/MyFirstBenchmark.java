package org.example;

public class MyFirstBenchmark {

    public long sumArray(int[] array) {
        long sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }
    @Benchmark
    public void testSumArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        sumArray(array);
    }
}
