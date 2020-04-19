package com.stevenprogramming.ocp11.nio;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.DoubleStream;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 19 2020
 * @version 1.0
 */
public class PathTest {

  static Path p1 = Paths.get("c:\\a\\b\\c");
  static Path p2 = Paths.get("\\a\\b\\c");
  static Path p3 = Paths.get("/a/b/c");
  static Path p4 = Paths.get("a/b/c");

  public static String getValue(Path p1) {
    String root = p1.getName(0).toString();
    String x = p1.getName(1).toString();
    String y = p1.subpath(1, 2).toString();
    return x + " : " + y + " :ROOT>" + root;
  }

  public static void main(String[] args) {
    System.out.println(getValue(p1));
    System.out.println(getValue(p2));
    System.out.println(getValue(p3));
    System.out.println(getValue(p4));

    DoubleStream is = DoubleStream.of(0, 2, 4); //1
    double sum = is.filter(i -> i % 2 != 0).sum(); //2
    System.out.println(sum); //3
    String g = "Steven";
    System.out.println(g.indexOf("e"));
    System.out.println(g.lastIndexOf("e"));
    System.out.println(g.substring(1, 3));

    Path p1 = Paths.get("photos\\..\\beaches\\.\\calangute\\a.txt");
    Path p2 = p1.normalize();
    Path p3 = p1.relativize(p2);
    Path p4 = p2.relativize(p1);

    System.out.println(p1.getNameCount() + " " + p2.getNameCount() + " "
            + p3.getNameCount() + " " + p4.getNameCount());
    System.out.println(p1);
    System.out.println(p2);
    System.out.println(":" + p3 + ">");
    System.out.println(":" + p4 + ">");
    
    
  }

}
