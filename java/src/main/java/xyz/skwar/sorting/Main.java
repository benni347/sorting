package xyz.skwar.sorting;

import java.util.ArrayList;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
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

    // Time Sorting functions
    long bubbleSortTime = measureTime(bubbleSort::bubbleSort);
    long shellSortTime = measureTime(shellSort::shellSort);
    long heapSortTime = measureTime(heapSort::heapSort);
    long quickSortTime = measureTime(quickSort::quickSort);
    long builtInSortTime = measureTime(builtInSort);
    long radixSortTime = measureTime(radixSort::radixSort);
    long gnomeSortTime = measureTime(gnomeSort::gnomeSort);
    // long bogoSortTime = measureTime(bogoSort::bogoSort);
    // long bozoSortTime = measureTime(bozoSort::bozoSort);

    // Print time duration for each sorter
    logger.info("Time taken by BubbleSort: {} ms", bubbleSortTime);
    logger.info("Time taken by ShellSort: {} ms", shellSortTime);
    logger.info("Time taken by HeapSort: {} ms", heapSortTime);
    logger.info("Time taken by QuickSort: {} ms", quickSortTime);
    logger.info("Time taken by BuiltInSort: {} ms", builtInSortTime);
    logger.info("Time taken by RadixSort: {} ms", radixSortTime);
    logger.info("Time taken by GnomeSort: {} ms", gnomeSortTime);
    // logger.info("Time taken by BogoSort: {} ms", bogoSortTime);
    // logger.info("Time taken by BozoSort: {} ms", bozoSortTime);
  }

  private static long measureTime(Runnable action) {
    long startTimeBubble = System.currentTimeMillis();
    action.run();
    long endTimeBubble = System.currentTimeMillis();
    return endTimeBubble - startTimeBubble;
  }
}
