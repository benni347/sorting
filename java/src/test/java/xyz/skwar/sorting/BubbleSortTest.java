package xyz.skwar.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BubbleSortTest {

  private BubbleSort bubbleSort;

  @BeforeMethod
  public void setUp() {
    ArrayList<Integer> randomIntList = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
    bubbleSort = new BubbleSort(randomIntList);
  }

  @Test
  public void testBubbleSort() {
    ArrayList<Integer> sortedList = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8));
    Assert.assertEquals(bubbleSort.bubbleSort(), sortedList);
  }

  @Test
  public void testAlreadySorted() {
    ArrayList<Integer> alreadySortedList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    bubbleSort = new BubbleSort(alreadySortedList);
    Assert.assertEquals(bubbleSort.bubbleSort(), alreadySortedList);
  }

  @Test
  public void testReverseSorted() {
    ArrayList<Integer> reverseSortedList = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
    bubbleSort = new BubbleSort(reverseSortedList);
    ArrayList<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    Assert.assertEquals(bubbleSort.bubbleSort(), expectedList);
  }

  @Test
  public void testDuplicateElements() {
    ArrayList<Integer> listWithDuplicates = new ArrayList<>(Arrays.asList(5, 3, 5, 1, 2));
    bubbleSort = new BubbleSort(listWithDuplicates);
    ArrayList<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 5));
    Assert.assertEquals(bubbleSort.bubbleSort(), expectedList);
  }
}
