package com.stevenprogramming.ocp11.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 13 2020
 * @version 1.0
 */
public class RelativizeTest {
  
  private static  String SMENDEZ = "/home/smendez";
  private static  Path SMENDEZ_PATH = Paths.get(SMENDEZ);
  private static  String SMENDEZ_DEVELOPMENT = SMENDEZ + "/development";
  private static  Path SMENDEZ_DEVELOPMENT_PATH = Paths.get(SMENDEZ_DEVELOPMENT);
  
    public static void main(String[] args) {
       //Path path1 = Paths.get("/home/smendez");
        //Path path2 = Paths.get("/home/smendez/development/");
        Path pathResult = SMENDEZ_DEVELOPMENT_PATH.relativize(SMENDEZ_PATH);
        System.out.println("1) " + pathResult); // ...

        pathResult = SMENDEZ_PATH.relativize(SMENDEZ_DEVELOPMENT_PATH);
        System.out.println("2) " + pathResult);  // development
        System.out.println("3) Absolute " +pathResult.toAbsolutePath()); 

        SMENDEZ_PATH = Paths.get("/home/smendez");
        SMENDEZ_DEVELOPMENT_PATH = Paths.get("/root/smendez/development/");
        pathResult = SMENDEZ_DEVELOPMENT_PATH.relativize(SMENDEZ_PATH);
        System.out.println("4) " + pathResult); // ../../../home/smendez

        pathResult = SMENDEZ_PATH.relativize(SMENDEZ_DEVELOPMENT_PATH);
        System.out.println("5) " + pathResult); //../../root/smendez/development
        System.out.println("6) >>>Absolute " +pathResult.toAbsolutePath()); 

        SMENDEZ_PATH = Paths.get("/root/smendez/development/");
        SMENDEZ_DEVELOPMENT_PATH = Paths.get("/root/smendez/development/");
        pathResult = SMENDEZ_DEVELOPMENT_PATH.relativize(SMENDEZ_PATH);
        System.out.println("7) :" +pathResult+":"); 
        System.out.println("8) >>>Absolute" +pathResult.toAbsolutePath()); 
        
        SMENDEZ_PATH = Paths.get("/root/../smendez/development/");
        SMENDEZ_DEVELOPMENT_PATH = Paths.get("/root/smendez/development/");
        pathResult = SMENDEZ_DEVELOPMENT_PATH.relativize(SMENDEZ_PATH);
        System.out.println("9) :" +pathResult+":"); 
        
        SMENDEZ_PATH = Paths.get("/root/../smendez/development/");
        SMENDEZ_DEVELOPMENT_PATH = Paths.get("/root/smendez/development/");
        pathResult = SMENDEZ_PATH.relativize(SMENDEZ_DEVELOPMENT_PATH);
        System.out.println("10) :" +pathResult+":"); 
        
        SMENDEZ_PATH = Paths.get("/root/../smendez/.//development/");
        SMENDEZ_DEVELOPMENT_PATH = Paths.get("/root/.///smendez/development/");
        pathResult = SMENDEZ_PATH.relativize(SMENDEZ_DEVELOPMENT_PATH);
        System.out.println("11) :" +pathResult+":"); 
        
        Path path3 = Paths.get("\\home\\smendez\\development");         // \home\smendez\development
        Path path4 = Paths.get("\\home\\smendez\\development\\java");   // \home\smendez\development\java
        Path result = path3.relativize(path4);                                // ../\home\smendez\development\java
        System.out.println("12) :" +result+":"); 
        
        Path path01 = Paths.get("Topic.txt");
        Path path02 = Paths.get("Demo.txt");
        Path path01_to_path02 = path01.relativize(path02);
        System.out.println("01-02:" +path01_to_path02);
        Path path02_to_path01 = path02.relativize(path01);
        System.out.println("02-01:" +path02_to_path01);
        
        Path path03 = Paths.get("/Java/JavaFX/Topic.txt");
        Path path04 = Paths.get("/Java/2011");
        Path path03_to_path04 = path03.relativize(path04);
        System.out.println("03-04:" +path03_to_path04);
        Path path04_to_path03 = path04.relativize(path03);
        System.out.println("04-03:" +path04_to_path03);
        
        
        Path path033 = Paths.get("/Java/JavaFX/Topic2.txt");
        //System.out.println(path01.relativize(path03)); //Error IllegalArgumentException: 'other' is different type of Path
        System.out.println(path03.relativize(path033));
        //System.out.println(path01.relativize(path04)); //Error IllegalArgumentException: 'other' is different type of Path
        
        Path p1 = Paths.get("c:\\temp\\test1.txt");
        
        System.out.println("13" + p1.relativize(Paths.get("c:\\temp\\text2.txt")));
        p1 = Paths.get("c:\\test1.txt");
        System.out.println("14" + p1.relativize(Paths.get("c:\\temp\\text2.txt")));
        p1 = Paths.get("test1.txt");
        //System.out.println("15" + p1.relativize(Paths.get("c:\\temp\\text2.txt")));
        p1 = Paths.get("c:\\temp\\test1.txt");
        
        System.out.println("16" + p1.relativize(Paths.get("text2.txt")));
      
    }

}
