package com.stevenprogramming.ocp11.nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;

public class PathMock {

    public static void main(String[] args){
        //Path p1 = Paths.get("c:\\finance\\data\\reports\\daily\\pnl.txt");
        Path p1 = Paths.get("//finance//data//reports//daily//pnl.txt");
        System.out.println(p1);
        System.out.println(p1.subpath(0, 2));

        Path p2 = Paths.get("//finance//data");
        System.out.println(p1.relativize(p2));
        System.out.println(p2.relativize(p1));

        p2 = Paths.get("//finance//data.txt");
        System.out.println(p2.relativize(p1));

        p1 = Paths.get("//finance//data3.txt");
        p2 = Paths.get("//finance//data");
        System.out.println(p2.relativize(p1));
        System.out.println(p1.relativize(p2));

        Path path1 = Paths.get("/user1/bin.txt");
        Path path2 = Paths.get("/user2/bin");

        System.out.printf("Path from %s to %s: %s%n",
                path1, path2, path1.relativize(path2));
        System.out.printf("Path from %s to %s: %s%n",
                path1, path2, path2.relativize(path1));

        System.out.printf("Path from %s to %s: %s%n",
                path1, path2, path2.relativize(path2));

        int a=5, b =10, c=100;
        System.out.println(a + "d" +b + c);

        p1 = Paths.get("finance//i//data3");
        p2 = Paths.get("finance2//data");
        System.out.println("22:" + p1.relativize(p2));
        System.out.println("11:" +p2.relativize(p1));

        p1 = Paths.get("finance//data3");
        p2 = Paths.get("//finance//data");
        System.out.println("2**:" + p1.relativize(p2));
        System.out.println("1**:" +p2.relativize(p1));

        p1 = Paths.get("finance//data3.txt");
        p2 = Paths.get("//finance//data");
        System.out.println("2:" + p1.relativize(p2));
        System.out.println("1:" +p2.relativize(p1));

        Consumer<Integer> func = x->{ x= x+10;};





    }
}
