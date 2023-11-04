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
    int listLength = 1000;

    for (int i = 0; i < listLength; i++) {
      randomIntList.add(rand.nextInt(listLength * 5));
    }

    BubbleSort bubbleSort = new BubbleSort(randomIntList);

    // Time bubbleSort
    long bubbleSortTime = measureTime(bubbleSort::bubbleSort);

    // Print time duration for each sorter
    logger.info("Time taken by BubbleSort: {} ms", bubbleSortTime);
  }

  private static long measureTime(Runnable action) {
    long startTimeBubble = System.currentTimeMillis();
    action.run();
    long endTimeBubble = System.currentTimeMillis();
    return endTimeBubble - startTimeBubble;
  }
}
