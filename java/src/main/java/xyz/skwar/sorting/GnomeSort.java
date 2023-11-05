package xyz.skwar.sorting;

import java.util.*;

public class GnomeSort {
  private ArrayList<Integer> randomIntList;

  public GnomeSort(ArrayList<Integer> randomIntList) {
    this.randomIntList = randomIntList;
  }

  public ArrayList<Integer> gnomeSort() {
    int pos = 0;
    while (pos < randomIntList.size()) {
      if (pos == 0 || randomIntList.get(pos) >= randomIntList.get(pos - 1)) {
        ++pos;
      } else {
        Integer tempNumber = randomIntList.get(pos);
        randomIntList.set(pos, randomIntList.get(pos - 1));
        randomIntList.set(pos - 1, tempNumber);
        --pos;
      }
    }
    return randomIntList;
  }
}
