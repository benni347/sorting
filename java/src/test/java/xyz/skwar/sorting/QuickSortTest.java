package xyz.skwar.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QuickSortTest {

  private QuickSort quickSort;

  @BeforeMethod
  public void setUp() {
    ArrayList<Integer> randomIntList = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
    quickSort = new QuickSort(randomIntList);
  }

  @Test
  public void testQuickSort() {
    ArrayList<Integer> sortedList = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8));
    Assert.assertEquals(quickSort.quickSort(), sortedList);
  }

  @Test
  public void testAlreadySorted() {
    ArrayList<Integer> alreadySortedList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    quickSort = new QuickSort(alreadySortedList);
    Assert.assertEquals(quickSort.quickSort(), alreadySortedList);
  }

  @Test
  public void testReverseSorted() {
    ArrayList<Integer> reverseSortedList = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
    quickSort = new QuickSort(reverseSortedList);
    ArrayList<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    Assert.assertEquals(quickSort.quickSort(), expectedList);
  }

  @Test
  public void testDuplicateElements() {
    ArrayList<Integer> listWithDuplicates = new ArrayList<>(Arrays.asList(5, 3, 5, 1, 2));
    quickSort = new QuickSort(listWithDuplicates);
    ArrayList<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 5));
    Assert.assertEquals(quickSort.quickSort(), expectedList);
  }
}
