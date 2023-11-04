package xyz.skwar.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BogoSortTest {

  private BogoSort bogoSort;

  @BeforeMethod
  public void setUp() {
    ArrayList<Integer> randomIntList = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
    bogoSort = new BogoSort(randomIntList);
  }

  @Test
  public void testBogoSort() {
    ArrayList<Integer> sortedList = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8));
    Assert.assertEquals(bogoSort.bogoSort(), sortedList);
  }

  @Test
  public void testAlreadySorted() {
    ArrayList<Integer> alreadySortedList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    bogoSort = new BogoSort(alreadySortedList);
    Assert.assertEquals(bogoSort.bogoSort(), alreadySortedList);
  }

  @Test
  public void testReverseSorted() {
    ArrayList<Integer> reverseSortedList = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
    bogoSort = new BogoSort(reverseSortedList);
    ArrayList<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    Assert.assertEquals(bogoSort.bogoSort(), expectedList);
  }

  @Test
  public void testDuplicateElements() {
    ArrayList<Integer> listWithDuplicates = new ArrayList<>(Arrays.asList(5, 3, 5, 1, 2));
    bogoSort = new BogoSort(listWithDuplicates);
    ArrayList<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 5));
    Assert.assertEquals(bogoSort.bogoSort(), expectedList);
  }
}
