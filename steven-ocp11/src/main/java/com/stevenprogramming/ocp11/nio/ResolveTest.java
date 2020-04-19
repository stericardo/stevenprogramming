package com.stevenprogramming.ocp11.nio;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 14 2020
 * @version 1.0
 */
public class ResolveTest {

  private static String SMENDEZ = "/home/smendez";
  private static Path SMENDEZ_PATH = Paths.get(SMENDEZ);
  private static String SMENDEZ_DEVELOPMENT = SMENDEZ + "/development";
  private static Path SMENDEZ_DEVELOPMENT_PATH = Paths.get(SMENDEZ_DEVELOPMENT);

  public static void main(String[] args) {
    System.out.println(SMENDEZ_PATH.resolve(SMENDEZ_DEVELOPMENT_PATH)); ///home/smendez/development
    System.out.println(SMENDEZ_DEVELOPMENT_PATH.resolve(SMENDEZ_PATH)); ///home/smendez

    //System.out.println(SMENDEZ_DEVELOPMENT_PATH.resolve( (String) null )); // Throws Null pointer but compiles
    Path pathNull = null;
    //System.out.println(SMENDEZ_DEVELOPMENT_PATH.resolve( pathNull ));  // Throws Null pointer but compiles
    //System.out.println(SMENDEZ_DEVELOPMENT_PATH.resolve( null ));  // Does not compile


    Path path22 = Paths.get("development/data.pdf");
    System.out.println(SMENDEZ_PATH.resolve(path22)); // /home/smendez/development/data.pdf
    System.out.println(path22.resolve(SMENDEZ_PATH)); // /home/smendez

    Path absolute = Paths.get("/home/smendez");
    Path relative = Paths.get("development");
    Path file = Paths.get("file.txt");

    System.out.println(absolute.resolve(relative));  //   /home/smendez/development
    System.out.println(absolute.resolve(file));      //   /home/smendez/file.txt
    System.out.println(relative.resolve(file));      //   development/file.txt
    System.out.println("BAD " + relative.resolve(absolute)); // BAD /home/smendez
    System.out.println("BAD " + file.resolve(absolute)); // BAD     /home/smendez
    System.out.println("BAD " + file.resolve(relative)); // BAD     file.txt/development
    /**
     * /home/smendez/development /home/smendez/file.txt development/file.txt
     * BAD /home/smendez BAD /home/smendez BAD file.txt/development
     */
    
    System.out.println("BAD " + file.resolve(file));
    
     Path p1 = Paths.get("c:\\temp\\test.txt");
   Path p2 = Paths.get("sdf");
   System.out.println("Result" + p1.resolve(p2) + "__");
    

  }

}
