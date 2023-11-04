package xyz.skwar.sorting;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/*
 * BozoSort Implementation
 * Note: This sorting algorithm is included for educational purposes only.
 * It is highly inefficient and not recommended for actual sorting tasks.
 * The algorithm sorts the list purely by chance by repeatedly shuffling
 * the entire list until it happens to be in order.
 */
public class BozoSort {
  private ArrayList<Integer> randomIntList;

  public BozoSort(ArrayList<Integer> randomIntList) {
    this.randomIntList = randomIntList;
  }

  public ArrayList<Integer> bozoSort() {
    while (!isSorted()) {
      swapTwoRandomElements();
    }
    return randomIntList;
  }

  private boolean isSorted() {
    for (int i = 0; i < randomIntList.size() - 1; i++) {
      if (randomIntList.get(i) > randomIntList.get(i + 1)) {
        return false;
      }
    }
    return true;
  }

  private void swapTwoRandomElements() {
    int firstRandomPosition = ThreadLocalRandom.current().nextInt(0, randomIntList.size());
    int secondRandomPosition = ThreadLocalRandom.current().nextInt(0, randomIntList.size());
    Collections.swap(randomIntList, firstRandomPosition, secondRandomPosition);
  }
}
