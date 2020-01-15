package com.stevenprogramming.ocp11.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 13 2020
 * @version 1.0
 */
public class NormalizeTest {

  public static Path PATHDEVELOPMENT = Paths.get("./home/smendez/../development/");
  public static Path PATHDEVELOPMENT_2 = Paths.get("/home/./smendez/../development/");
  public static Path PATHDEVELOPMENT_APATH = Paths.get("/home/./smendez/development/../apath");
  public static Path PATH_SPLIT = Paths.get("myDirectory", "..", "development");
  public static Path PATH_SPLIT2 = Paths.get("myDirectory/", "/../", "/development/");

  public static void main(String[] args) {
    System.out.println("./home/smendez/../development/" + ":Normalize=" +PATHDEVELOPMENT.normalize());
    System.out.println("/home/./smendez/../development/" + ":Normalize=" +PATHDEVELOPMENT_2.normalize());
    System.out.println("/home/./smendez/development/../apath" + ":Normalize=" +PATHDEVELOPMENT_APATH.normalize());
    System.out.println(":Normalize=" +PATH_SPLIT.normalize());
    System.out.println(":Normalize=" +PATH_SPLIT2.normalize());

    String buildProject = "/build_project/scripts";
    String upToDirectories = "../..";
    String myProject = "/My_project/source";
    Path pathsBuild = Paths.get(buildProject, upToDirectories, myProject);
    System.out.println("Original " + pathsBuild + " BuildProject " + pathsBuild.normalize());
    
    System.out.println("Original " + pathsBuild.toUri() + " BuildProject " + pathsBuild.normalize());
    Path p1 = Paths.get("c:\\main\\project\\Starter.java");
    System.out.println(p1.getName(0).toString());

  }

}
