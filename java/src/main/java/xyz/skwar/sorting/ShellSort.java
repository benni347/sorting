package xyz.skwar.sorting;

import java.util.ArrayList;

public class ShellSort {
  private ArrayList<Integer> randomIntList;

  public ShellSort(ArrayList<Integer> randomIntList) {
    this.randomIntList = randomIntList;
  }

  public ArrayList<Integer> shellSort() {
    int n = randomIntList.size();
    for (int gap = n / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < n; i++) {
        int temp = randomIntList.get(i);
        int j;
        for (j = i; j >= gap && randomIntList.get(j - gap) > temp; j -= gap) {
          randomIntList.set(j, randomIntList.get(j - gap));
        }
        randomIntList.set(j, temp);
      }
    }
    return randomIntList;
  }
}
