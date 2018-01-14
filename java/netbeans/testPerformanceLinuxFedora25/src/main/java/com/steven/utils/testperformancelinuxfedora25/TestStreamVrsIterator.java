package com.steven.utils.testperformancelinuxfedora25;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author steven
 */
public class TestStreamVrsIterator {

  public List<String> getList() {
    List<String> myList = new ArrayList<>();
    for (int i = 0; i < 10000; i++) {
      if ((i % 2) == 0) {
        myList.add("a" + String.valueOf(i));
      } else {
        myList.add("c" + String.valueOf(i));
      }
    }
    return myList;
  }

  public void testStream() {
    List<String> myList = getList();
    myList
            .stream()
            .filter(s -> s.startsWith("c"))
            .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);

    myList.forEach(System.out::println);

  }

  public static void main(String[] args) {
    TestStreamVrsIterator tsvi = new TestStreamVrsIterator();
    tsvi.testStream();
  }

}
