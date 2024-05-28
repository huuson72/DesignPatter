package Strategy;

import java.util.Arrays;
import java.util.Random;

public class Benchmark {
    public static void main(String[] args) {
        int[] arr = new Random().ints(10000, 1, 10000).toArray();

        Context context = new Context();

        int[] arr1 = Arrays.copyOf(arr, arr.length);
        long startTime = System.currentTimeMillis();
        context.setStrategy(new BubbleSort());
        context.executeStrategy(arr1);
        long endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực thi Bubble Sort: " + (endTime - startTime) + " ms");

        int[] arr2 = Arrays.copyOf(arr, arr.length);
        startTime = System.currentTimeMillis();
        context.setStrategy(new InsertionSort());
        context.executeStrategy(arr2);
        endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực thi Insertion Sort: " + (endTime - startTime) + " ms");

        int[] arr3 = Arrays.copyOf(arr, arr.length);
        startTime = System.currentTimeMillis();
        context.setStrategy(new QuickSort());
        context.executeStrategy(arr3);
        endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực thi Quick Sort: " + (endTime - startTime) + " ms");
    }
}