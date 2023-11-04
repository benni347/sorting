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

    // Init Sorting classes
    BubbleSort bubbleSort = new BubbleSort(randomIntList);
    ShellSort shellSort = new ShellSort(randomIntList);
    HeapSort heapSort = new HeapSort(randomIntList);
    QuickSort quickSort = new QuickSort(randomIntList);

    // Time Sorting functions
    long bubbleSortTime = measureTime(bubbleSort::bubbleSort);
    long shellSortTime = measureTime(shellSort::shellSort);
    long heapSortTime = measureTime(heapSort::heapSort);
    long quickSortTime = measureTime(quickSort::quickSort);

    // Print time duration for each sorter
    logger.info("Time taken by BubbleSort: {} ms", bubbleSortTime);
    logger.info("Time taken by ShellSort: {} ms", shellSortTime);
    logger.info("Time taken by HeapSort: {} ms", heapSortTime);
    logger.info("Time taken by QuickSort: {} ms", quickSortTime);
  }

  private static long measureTime(Runnable action) {
    long startTimeBubble = System.currentTimeMillis();
    action.run();
    long endTimeBubble = System.currentTimeMillis();
    return endTimeBubble - startTimeBubble;
  }
}
