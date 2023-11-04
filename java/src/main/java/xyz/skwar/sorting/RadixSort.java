package xyz.skwar.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class RadixSort {
  private ArrayList<Integer> randomIntList;

  public RadixSort(ArrayList<Integer> randomIntList) {
    this.randomIntList = randomIntList;
  }

  private int getMax() {
    return Collections.max(randomIntList);
  }

  private void countingSort(int place) {
    int outputSize = randomIntList.size();
    ArrayList<Integer> output = new ArrayList<>(Collections.nCopies(outputSize, 0));
    int[] count = new int[10];

    for (int number : randomIntList) {
      int index = (number / place) % 10;
      count[index]++;
    }

    for (int i = 1; i < 10; i++) {
      count[i] += count[i - 1];
    }

    for (int i = outputSize - 1; i >= 0; i--) {
      int number = randomIntList.get(i);
      int index = (number / place) % 10;
      output.set(count[index] - 1, number);
      count[index]--;
    }

    for (int i = 0; i < outputSize; i++) {
      randomIntList.set(i, output.get(i));
    }
  }

  public ArrayList<Integer> radixSort() {
    int m = getMax();
    for (int place = 1; m / place > 0; place *= 10) {
      countingSort(place);
    }
    return randomIntList;
  }
}
