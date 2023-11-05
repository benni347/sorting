package xyz.skwar.sorting;

import java.util.ArrayList;

public class HeapSort {
  private ArrayList<Integer> randomIntList;

  public HeapSort(ArrayList<Integer> randomIntList) {
    this.randomIntList = randomIntList;
  }

  public ArrayList<Integer> heapSort() {
    int n = randomIntList.size();
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(randomIntList, n, i);
    }
    for (int i = n - 1; i >= 0; i--) {
      int temp = randomIntList.get(0);
      randomIntList.set(0, randomIntList.get(i));
      randomIntList.set(i, temp);
      heapify(randomIntList, i, 0);
    }
    return randomIntList;
  }

  private void heapify(ArrayList<Integer> randomIntList, int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    if (left < n && randomIntList.get(left) > randomIntList.get(largest)) {
      largest = left;
    }
    if (right < n && randomIntList.get(right) > randomIntList.get(largest)) {
      largest = right;
    }
    if (largest != i) {
      int temp = randomIntList.get(i);
      randomIntList.set(i, randomIntList.get(largest));
      randomIntList.set(largest, temp);
      heapify(randomIntList, n, largest);
    }
  }
}
