package xyz.skwar.sorting;

import java.util.*;

public class BubbleSort {
  private ArrayList<Integer> randomIntList;

  public BubbleSort(ArrayList<Integer> randomIntList) {
    this.randomIntList = randomIntList;
  }

  public ArrayList<Integer> bubbleSort() {
    int n = randomIntList.size();
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (randomIntList.get(j) > randomIntList.get(j + 1)) {
          // swap temp and randomIntList.get(i)
          int temp = randomIntList.get(j);
          randomIntList.set(j, randomIntList.get(j + 1));
          randomIntList.set(j + 1, temp);
        }
      }
    }
    return randomIntList;
  }
}
