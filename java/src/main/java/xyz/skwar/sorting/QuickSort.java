package xyz.skwar.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class QuickSort {
  private ArrayList<Integer> randomIntList;

  public QuickSort(ArrayList<Integer> randomIntList) {
    this.randomIntList = randomIntList;
  }

  public ArrayList<Integer> quickSort() {
    quickSort(0, randomIntList.size() - 1);
    return randomIntList;
  }

  private void quickSort(int start, int end) {
    if (start < end) {
      int partitionIndex = partition(start, end);
      quickSort(start, partitionIndex - 1);
      quickSort(partitionIndex + 1, end);
    }
  }

  private int partition(int start, int end) {
    int middle = start + (end - start) / 2;
    int pivotIndex = medianOfThree(start, middle, end);
    int pivotValue = randomIntList.get(pivotIndex);
    // Swap pivot with end
    Collections.swap(randomIntList, pivotIndex, end);

    int i = (start - 1);

    for (int j = start; j < end; j++) {
      if (randomIntList.get(j) <= pivotValue) {
        i++;
        Collections.swap(randomIntList, i, j);
      }
    }

    Collections.swap(randomIntList, i + 1, end);
    return i + 1;
  }

  private int medianOfThree(int start, int middle, int end) {
    int a = randomIntList.get(start);
    int b = randomIntList.get(middle);
    int c = randomIntList.get(end);
    int medianIndex;
    if (a < b) {
      if (b < c) {
        medianIndex = middle;
      } else if (a < c) {
        medianIndex = end;
      } else {
        medianIndex = start;
      }
    } else {
      if (a < c) {
        medianIndex = start;
      } else if (b < c) {
        medianIndex = end;
      } else {
        medianIndex = middle;
      }
    }
    return medianIndex;
  }
}
