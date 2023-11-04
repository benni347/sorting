package xyz.skwar.sorting;

import java.util.ArrayList;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    // Create an ArrayList and populate it with random values
    ArrayList<Integer> randomIntList = new ArrayList<>();
    Random rand = new Random();

    for (int i = 0; i < 200; i++) {
      randomIntList.add(rand.nextInt(1000));
    }

    // Create an instance of the Sorting class
    BubbleSort bubbleSort = new BubbleSort(randomIntList);

    // Call the BubbleSort method and store the sorted list
    ArrayList<Integer> bubbleSortedList = bubbleSort.bubbleSort();

    // Print the sorted list
    System.out.println("Sorted List: " + bubbleSortedList);
  }
}
