package com.stevenprogramming.ocp11.stream;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 12 2020
 * @version 1.0
 */
public class SortedStream {
  
  public static void main(String[] args) {
    /**
     * Stream<T> sorted(Comparator<? super T> comparator); comparator = int
     * compare(T o1, T o2);
     *
     */

    UtilStream.printStreamln(UtilStream.dogs.stream().sorted((d1, d2) -> d1.getWeight() - d2.getWeight()), "Sorted Stream");

  }

}
