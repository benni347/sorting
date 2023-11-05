package xyz.skwar.sorting;

import java.util.*;

public class SpaghettiSort {
  private ArrayList<Integer> randomIntList;

  public SpaghettiSort(ArrayList<Integer> randomIntList) {
    this.randomIntList = new ArrayList<>(randomIntList);
  }

  public ArrayList<Integer> spaghettiSort() {
    ArrayList<Integer> sortedList = new ArrayList<>();
    while (!randomIntList.isEmpty()) {
      int tallestStrandIndex = findIndexOfTallestStrand(randomIntList);
      int tallestStrand = randomIntList.get(tallestStrandIndex);
      randomIntList.remove(tallestStrandIndex);
      sortedList.add(tallestStrand);
    }
    Collections.reverse(sortedList);
    return sortedList;
  }

  private int findIndexOfTallestStrand(ArrayList<Integer> list) {
    int tallestStrandIndex = 0;
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i) > list.get(tallestStrandIndex)) {
        tallestStrandIndex = i;
      }
    }
    return tallestStrandIndex;
  }
}
