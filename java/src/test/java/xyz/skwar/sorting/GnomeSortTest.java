package xyz.skwar.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GnomeSortTest {

  private GnomeSort gnomeSort;

  @BeforeMethod
  public void setUp() {
    ArrayList<Integer> randomIntList = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
    gnomeSort = new GnomeSort(randomIntList);
  }

  @Test
  public void testGnomeSort() {
    ArrayList<Integer> sortedList = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8));
    Assert.assertEquals(gnomeSort.gnomeSort(), sortedList);
  }

  @Test
  public void testAlreadySorted() {
    ArrayList<Integer> alreadySortedList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    gnomeSort = new GnomeSort(alreadySortedList);
    Assert.assertEquals(gnomeSort.gnomeSort(), alreadySortedList);
  }

  @Test
  public void testReverseSorted() {
    ArrayList<Integer> reverseSortedList = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
    gnomeSort = new GnomeSort(reverseSortedList);
    ArrayList<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    Assert.assertEquals(gnomeSort.gnomeSort(), expectedList);
  }

  @Test
  public void testDuplicateElements() {
    ArrayList<Integer> listWithDuplicates = new ArrayList<>(Arrays.asList(5, 3, 5, 1, 2));
    gnomeSort = new GnomeSort(listWithDuplicates);
    ArrayList<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 5));
    Assert.assertEquals(gnomeSort.gnomeSort(), expectedList);
  }
}
