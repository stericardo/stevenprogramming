package com.stevenprogramming.ocp11.nio;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 14 2020
 * @version 1.0
 */
public class InformationSubPathTest {

  public static void main(String[] args) {
    Path path1File = Paths.get("/home/smendez/development/apath/file1.txt");

    System.out.println(path1File.getFileName());
    System.out.println("1" + path1File.getName(1));
    System.out.println("0" + path1File.getName(0));
    System.out.println(path1File.getNameCount());
    System.out.println(path1File.getParent());
    System.out.println(path1File.getRoot());
    System.out.println(path1File.subpath(0, 3)); // home\smendez\development

    System.out.println(path1File.subpath(0, 3).relativize(path1File.subpath(0, 2)));
    System.out.println(path1File.subpath(0, 2).relativize(path1File.subpath(0, 3)));

    Path p1 = Paths.get("c:\\main\\project\\Starter.java");
    System.out.println("0" + p1.getName(0));

    Map<String, String> map1 = new HashMap<>();
    map1.put("a", "x");
    map1.put("b", "x");
    BiFunction<String, String, String> f = String::concat;
    map1.merge("b", "y", f);
    map1.merge("c", "y", f);
    System.out.println(map1);

  }

}
