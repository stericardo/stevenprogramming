package com.stevenprogramming.path;

import com.stevenprogramming.path.structure.Directory;
import com.stevenprogramming.path.structure.POMFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Application {

    public static Initializer initializer = Initializer.getInstance();
    public static final String lookFor= "org.json";

    public static void main(String[] args) throws IOException {
        initializer.init();
        String currentPath = initializer.getIOUtil().getCanonicalPath(".");
        System.out.println("Current dir:" + currentPath);

        String currentDir = System.getProperty("user.home");
        currentPath = initializer.getIOUtil().getCanonicalPath(currentDir);
        System.out.println("Current dir:" + currentPath);

        currentPath = initializer.getIOUtil().getCanonicalPath(currentDir + "/.m2/repository");
        System.out.println("Current dir m2:" + currentPath);
        String m2Repository = currentPath;

        List<Directory> directoryList = new ArrayList<>();
        List<POMFile> pomFileList = new ArrayList<>();

        try (Stream<Path> stream = Files.walk(Paths.get(currentPath))) {
            stream.filter(Files::isDirectory).forEach(path -> {
                Directory directory = new Directory(path.getParent().getFileName().toString(), path.toString());
                directoryList.add(directory);
            });
        }

        try (Stream<Path> stream = Files.walk(Paths.get(currentPath))) {
            stream.filter(Files::isRegularFile)
                    .filter(path -> path.toString().toLowerCase().endsWith(".pom"))
                    .forEach(path -> {
                        POMFile pomFile = new POMFile(initializer.getIOUtil().removePartOfString(path.getParent().toString(), m2Repository),
                                path.getFileName().toString(), path);
                        pomFileList.add(pomFile);
                    });
        }

        //directoryList.stream().forEach(System.out::println);

        //pomFileList.stream().forEach(System.out::println);

        String outcome = new String(Files.readAllBytes(pomFileList.get(0).getPathSource()));
        //System.out.println(outcome);

        List<POMFile> pomExclusionFileList = new ArrayList<>();

        try (Stream<Path> stream = Files.walk(Paths.get(currentPath))) {
            stream.filter(Files::isRegularFile)
                    .filter(path -> path.toString().toLowerCase().endsWith(".pom"))
                    .filter(path -> {
                        try  {
                            String pomString = new String(Files.readAllBytes(path));
                            if(pomString.indexOf(lookFor) > -1){
                                return true;
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    })
                    .forEach(path -> {
                        POMFile pomFile = new POMFile(initializer.getIOUtil().removePartOfString(path.getParent().toString(), m2Repository),
                                path.getFileName().toString(), path);
                        pomExclusionFileList.add(pomFile);
                    });
        }

       // pomExclusionFileList.stream().forEach(System.out::println);
        System.out.println("Amount of POMs scanned: " + pomFileList.size() + " Found " + lookFor + " on "
                + pomExclusionFileList.size() + " POMs");

    }

}
