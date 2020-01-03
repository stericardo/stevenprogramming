package com.stevenprogramming.library.ocp8.ch5.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author steven
 */
public class RelatizePractice {

    public static void main(String[] args) {
        Path path01 = Paths.get("Topic.txt");
        Path path02 = Paths.get("Demo.txt");
        Path path03 = Paths.get("/Java/JavaFX/Topic.txt");
        Path path04 = Paths.get("/Java/2011");
        /**
            ../Demo.txt
            ../Topic.txt
            ../../2011
            ../JavaFX/Topic.txt
         */
        Path path01_to_path02 = path01.relativize(path02);
        System.out.println(path01_to_path02);

        Path path02_to_path01 = path02.relativize(path01);
        System.out.println(path02_to_path01);

        Path path03_to_path04 = path03.relativize(path04);
        System.out.println(path03_to_path04);

        Path path04_to_path03 = path04.relativize(path03);
        System.out.println(path04_to_path03);
        
        
        path01 = Paths.get("//Topic.txt");
        path02 = Paths.get("//Demo.txt");
        path03 = Paths.get("//Java/JavaFX//Topic.txt");
        path04 = Paths.get("/Java//.//2011");
        /**
            ../Demo.txt
            ../Topic.txt
            ../../2011
            ../JavaFX/Topic.txt
         */
        path01_to_path02 = path01.relativize(path02);
        System.out.println(path01_to_path02);

        path02_to_path01 = path02.relativize(path01);
        System.out.println(path02_to_path01);

        path03_to_path04 = path03.relativize(path04);
        System.out.println(path03_to_path04);

        path04_to_path03 = path04.relativize(path03);
        System.out.println(path04_to_path03);
        
    }

}
