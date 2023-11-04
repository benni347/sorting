package xyz.skwar.sorting;

import java.util.*;

public class BogoSort {
  private ArrayList<Integer> randomIntList;

  public BogoSort(ArrayList<Integer> randomIntList) {
    this.randomIntList = randomIntList;
  }

  public ArrayList<Integer> bogoSort() {
    while (!isSorted()) {
      Collections.shuffle(randomIntList);
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
}
