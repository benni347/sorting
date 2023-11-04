package xyz.skwar.sorting;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
    // At the beginning of the main method
    ExecutorService executor = Executors.newFixedThreadPool(6);

    // Create an ArrayList and populate it with random values
    ArrayList<Integer> randomIntList = new ArrayList<>();
    Random rand = new Random();
    int listLength = 10000;

    for (int i = 0; i < listLength; i++) {
      randomIntList.add(rand.nextInt(listLength * 5));
    }

    // Make copies of the original unsorted list for each sort
    ArrayList<Integer> copyForBubbleSort = new ArrayList<>(randomIntList);
    ArrayList<Integer> copyForShellSort = new ArrayList<>(randomIntList);
    ArrayList<Integer> copyForHeapSort = new ArrayList<>(randomIntList);
    ArrayList<Integer> copyForQuickSort = new ArrayList<>(randomIntList);
    ArrayList<Integer> copyForBuiltInSort = new ArrayList<>(randomIntList);
    ArrayList<Integer> copyForRadixSort = new ArrayList<>(randomIntList);
    ArrayList<Integer> copyForGnomeSort = new ArrayList<>(randomIntList);
    // ArrayList<Integer> copyForBogoSort = new ArrayList<>(randomIntList);
    // ArrayList<Integer> copyForBozoSort = new ArrayList<>(randomIntList);
    ArrayList<Integer> copyForSpaghettiSort = new ArrayList<>(randomIntList);

    // Init Sorting classes with the respective copies
    BubbleSort bubbleSort = new BubbleSort(copyForBubbleSort);
    ShellSort shellSort = new ShellSort(copyForShellSort);
    HeapSort heapSort = new HeapSort(copyForHeapSort);
    QuickSort quickSort = new QuickSort(copyForQuickSort);
    Runnable builtInSort = () -> copyForBuiltInSort.sort(null);
    RadixSort radixSort = new RadixSort(copyForRadixSort);
    GnomeSort gnomeSort = new GnomeSort(copyForGnomeSort);
    // BogoSort bogoSort = new BogoSort(copyForBogoSort);
    // BozoSort bozoSort = new BozoSort(copyForBozoSort);
    SpaghettiSort spaghettiSort = new SpaghettiSort(copyForSpaghettiSort);

    // Submit them with immediate timing
    Future<Long> bubbleSortFuture = executor.submit(() -> timeSort(bubbleSort::bubbleSort));
    Future<Long> shellSortFuture = executor.submit(() -> timeSort(shellSort::shellSort));
    Future<Long> heapSortFuture = executor.submit(() -> timeSort(heapSort::heapSort));
    Future<Long> quickSortFuture = executor.submit(() -> timeSort(quickSort::quickSort));
    Future<Long> builtInSortFuture = executor.submit(() -> timeSort(builtInSort));
    Future<Long> radixSortFuture = executor.submit(() -> timeSort(radixSort::radixSort));
    Future<Long> gnomeSortFuture = executor.submit(() -> timeSort(gnomeSort::gnomeSort));
    // Future<Long> bogoSortFuture = executor.submit(() ->
    // timeSort(bogoSort::bogoSort));
    // Future<Long> bozoSortFuture = executor.submit(() ->
    // timeSort(bozoSort::bozoSort));
    Future<Long> spaghettiSortFuture =
        executor.submit(() -> timeSort(spaghettiSort::spaghettiSort));

    // Wait for all futures to complete and print the timing
    printSortTime("BubbleSort", bubbleSortFuture);
    printSortTime("ShellSort", shellSortFuture);
    printSortTime("HeapSort", heapSortFuture);
    printSortTime("QuickSort", quickSortFuture);
    printSortTime("BuiltInSort", builtInSortFuture);
    printSortTime("RadixSort", radixSortFuture);
    printSortTime("GnomeSort", gnomeSortFuture);
    // printSortTime("BogoSort", bogoSortFuture);
    // printSortTime("BozoSort", bozoSortFuture);
    printSortTime("SpaghettiSort", spaghettiSortFuture);
    executor.shutdown();
  }

  private static Long timeSort(Runnable sortTask) {
    long startTime = System.currentTimeMillis();
    long endTime = System.currentTimeMillis();
    return endTime - startTime;
  }

  private static void printSortTime(String sortName, Future<Long> future) {
    try {
      Long sortTime = future.get(); // This waits for the task to complete
      logger.info("Time taken by {}: {} ms", sortName, sortTime);
    } catch (InterruptedException | ExecutionException e) {
      logger.error("There was a problem with the sorting task", e);
    }
  }
}
