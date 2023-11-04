package xyz.skwar.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShellSortTest {

  private ShellSort shellSort;

  @BeforeMethod
  public void setUp() {
    ArrayList<Integer> randomIntList = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
    shellSort = new ShellSort(randomIntList);
  }

  @Test
  public void testShellSort() {
    ArrayList<Integer> sortedList = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8));
    Assert.assertEquals(shellSort.shellSort(), sortedList);
  }

  @Test
  public void testAlreadySorted() {
    ArrayList<Integer> alreadySortedList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    shellSort = new ShellSort(alreadySortedList);
    Assert.assertEquals(shellSort.shellSort(), alreadySortedList);
  }

  @Test
  public void testReverseSorted() {
    ArrayList<Integer> reverseSortedList = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
    shellSort = new ShellSort(reverseSortedList);
    ArrayList<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    Assert.assertEquals(shellSort.shellSort(), expectedList);
  }

  @Test
  public void testDuplicateElements() {
    ArrayList<Integer> listWithDuplicates = new ArrayList<>(Arrays.asList(5, 3, 5, 1, 2));
    shellSort = new ShellSort(listWithDuplicates);
    ArrayList<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 5));
    Assert.assertEquals(shellSort.shellSort(), expectedList);
  }
}
