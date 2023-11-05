package xyz.skwar.sorting;

import java.util.*;

/*
 * Miracle Sort Implementation
 * Note: This "sorting" algorithm is a humorous example and is included for entertainment and educational purposes only.
 * It is not a genuine sorting algorithm and is not recommended for any sorting tasks.
 * The "algorithm" assumes that the list will somehow sort itself by sheer chance and does not perform any operations to actually sort the data.
 */
public class MiracleSort {
  private ArrayList<Integer> randomIntList;

  public MiracleSort(ArrayList<Integer> randomIntList) {
    this.randomIntList = randomIntList;
  }

  public ArrayList<Integer> miracleSort() {
    while (!isSorted()) {}
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
