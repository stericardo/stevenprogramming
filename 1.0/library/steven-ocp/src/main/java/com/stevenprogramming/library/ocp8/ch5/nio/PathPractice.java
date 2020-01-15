package com.stevenprogramming.library.ocp8.ch5.nio;

import java.io.IOException;
import java.nio.file.*;
import java.time.Period;
import java.time.ZonedDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Steven Ricardo Mendez Brenes
 * @version 1.0
 * @since Mar 26 2019
 */
public class PathPractice {

    private void pathUses() {
        Path path3 = Paths.get("\\home\\smendez\\development");         
        Path path4 = Paths.get("\\home\\smendez\\development\\java");   
        Path path1 = Paths.get("/home/smendez/development");            
        Path path2 = Paths.get("/home/smendez/development/java");      
        Path result = path3.relativize(path4);                               
        result = path4.relativize(path3);                                  
        result = path1.relativize(path2);                                    
        result = path2.relativize(path1);                                     
    }

    private void createDirectories() {
        Path path1 = Paths.get("/home/smendez/development/apath");
        Path path2 = Paths.get("/home/smendez/development/bpath");
        Path path1File = Paths.get("/home/smendez/development/apath/file1.txt");
        createDirectory(path1);
        createDirectory(path2);
        createFile(path1File);
        Path path3 = Paths.get("/home/smendez/development/a1path");
        Path path4 = Paths.get("/home/smendez/development/b2path");
        Path path2File = Paths.get("/home/smendez/development/a1path/file1.txt");
        createDirectories(path3);
        createDirectories(path4);
        createFile(path2File);
    }

    private void copyFiles() {
        Path path1File = Paths.get("/home/smendez/development/apath/file1.txt");
        Path path2File = Paths.get("/home/smendez/development/a1path/file1.txt");
        copyFile(path1File, path2File);
        copyFile(path1File, path2File, StandardCopyOption.REPLACE_EXISTING);
        copyFile(path1File, path2File, StandardCopyOption.ATOMIC_MOVE);       // Unsupported copy option
        copyFile(path1File, path2File, StandardCopyOption.COPY_ATTRIBUTES);
        System.out.println("\n\n Moving Files\n");
        moveFiles(StandardCopyOption.REPLACE_EXISTING);
        moveFiles(StandardCopyOption.ATOMIC_MOVE);
        moveFiles(StandardCopyOption.COPY_ATTRIBUTES);                         // Unsupported move option
        removeFile();
        moveFiles();
    }

    private void moveFiles() {
        Path path1File = Paths.get("/home/smendez/development/apath/file1.txt");
        Path path2File = Paths.get("/home/smendez/development/a1path/file1.txt");
        try {
            Path result = Files.move(path1File, path2File);
            printPath(result);
        } catch (IOException e) {
            System.out.println("**** move file " + e.toString());
        }
    }

    private void moveFiles(CopyOption copyOption) {
        Path path1File = Paths.get("/home/smendez/development/apath/file1.txt");
        Path path2File = Paths.get("/home/smendez/development/a1path/file1.txt");
        try {
            System.out.println("Moving " + copyOption.toString());
            Path result = Files.move(path1File, path2File, copyOption);
            printPath(result);
        } catch (IOException e) {
            System.out.println("**** move file " + e.toString());
        } catch (UnsupportedOperationException e) {
            System.out.println("*** move File " + e.toString());
        }
    }

    private void removeFile() {
        Path path2File = Paths.get("/home/smendez/development/a1path/file1.txt");
        try {
            Files.delete(path2File);
        } catch (IOException e) {
            System.out.println("*** removeFile " + e.toString());
        }
    }

    private void copyFile(Path path1, Path path2) {
        try {
            Path result = Files.copy(path1, path2);
            printPath(result);
        } catch (IOException e) {
            System.out.println("*** copyFile " + e.toString());
        }
    }

    private void copyFile(Path path1, Path path2, CopyOption copyOption) {
        try {
            System.out.println("Copying " + copyOption.toString());
            Path result = Files.copy(path1, path2, copyOption);
            printPath(result);
        } catch (IOException e) {
            System.out.println("*** copyFile " + e.toString());
        } catch (UnsupportedOperationException e) {
            System.out.println("*** copyFile " + e.toString());
        }
    }

    private void createDirectory(Path path) {
        try {
            Path result = Files.createDirectory(path);
            printPath(result);
        } catch (IOException e) {
            System.out.println("**** createDirectory " + e.toString());
        }
    }

    private void createDirectories(Path path) {
        try {
            Path result = Files.createDirectories(path);
            printPath(result);
        } catch (IOException e) {
            System.out.println("**** createDirectories " + e.toString());
        }
    }

    private void createFile(Path path) {
        try {
            Path result = Files.createFile(path);
            printPath(result);
        } catch (IOException e) {
            System.out.println("**** createFile " + e.toString());
        }
    }

    private void printPath(Path path) {
        System.out.println("Path ::: " + path.toString());
    }

    private void getInformationPath() {
        Path path1File = Paths.get("/home/smendez/development/apath/file1.txt");
        AccessDeniedException j;
       ZonedDateTime.now().plus(Period.ofDays(7));


        System.out.println("\n\n");
        System.out.println(path1File.getFileName());
        System.out.println(path1File.getName(1));
        System.out.println(path1File.getName(0));
        System.out.println(path1File.getNameCount());
        System.out.println(path1File.getParent());
        System.out.println(path1File.getRoot());
        System.out.println(path1File.subpath(0, 3));
        System.out.println(path1File.subpath(0, 3).relativize(path1File.subpath(0, 2)));
        System.out.println(path1File.subpath(0, 2).relativize(path1File.subpath(0, 3)));
        Path path1 = Paths.get("/home/smendez");
        Path path2 = Paths.get("/home/smendez/development/");
        System.out.println(path1.relativize(path2));
        System.out.println(path2.relativize(path1));
        Path path3 = Paths.get("./home/smendez/../development/");
        /**
         * file1.txt smendez home 5 /home/smendez/development/apath /
         * home/smendez/development .. development development ..
         */

        System.out.println("\n\nNormalizing:::\n");
        System.out.println(path3.normalize()); //  home/development

        Path path4 = Paths.get("/home/./smendez/../development/");
        System.out.println(path4.normalize()); //  /home/development

        Path path5 = Paths.get("/home/./smendez/development/../apath");
        System.out.println(path5.normalize()); //  /home/smendez/apath

        Path path6 = Paths.get("development");
        Path path7 = Paths.get("./development");
        Path path8 = Paths.get("myDirectory", "..", "development");
        System.out.println(path8.normalize());  // development

        String buildProject = "/build_project/scripts";
        String upToDirectories = "../..";
        String myProject = "/My_project/source";
        Path pathsBuild = Paths.get(buildProject, upToDirectories, myProject);
        System.out.println("Original " + pathsBuild + " BuildProject " + pathsBuild.normalize()); //  /My_project/source

    }

    /**
     * Resolve should be read as "resolve path2 within path1 directory"
     */
    private void resolvePath() {
        Path path1 = Paths.get("/home/smendez");
        Path path2 = Paths.get("/home/smendez/development/");
        System.out.println(path1.resolve(path2)); ///home/smendez/development
        System.out.println(path2.resolve(path1)); ///home/smendez

        //System.out.println(path2.resolve( (String) null )); // Throws Null pointer but compiles
        Path pathNull = null;
        //System.out.println(path2.resolve( pathNull ));  // Throws Null pointer but compiles
        //System.out.println(path2.resolve( null ));  // Does not compile

        Path path11 = Paths.get("/home/smendez");
        Path path22 = Paths.get("development/data.pdf");
        System.out.println(path11.resolve(path22)); // /home/smendez/development/data.pdf

        Path absolute = Paths.get("/home/smendez");
        Path relative = Paths.get("development");
        Path file = Paths.get("file.txt");
        System.out.println(" @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ");
        System.out.println(" @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ");
        System.out.println(" @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ");
        System.out.println(" @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ");
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

    }

    /**
     * Relativization is the inverse of resolution
     */
    private void relativizePath() {
        Path path1 = Paths.get("/home/smendez");
        Path path2 = Paths.get("/home/smendez/development/");
        Path pathResult = path2.relativize(path1);
        System.out.println(pathResult); // ...

        pathResult = path1.relativize(path2);
        System.out.println(pathResult);  // development
        System.out.println(">>>!!!" +pathResult.toAbsolutePath()); 

        path1 = Paths.get("/home/smendez");
        path2 = Paths.get("/root/smendez/development/");
        pathResult = path2.relativize(path1);
        System.out.println(pathResult); // ../../../home/smendez

        pathResult = path1.relativize(path2);
        System.out.println(pathResult); //../../root/smendez/development
        System.out.println(">>>!!!" +pathResult.toAbsolutePath()); 

        path1 = Paths.get("/root/smendez/development/");
        path2 = Paths.get("/root/smendez/development/");
        pathResult = path2.relativize(path1);
        System.out.println(">>>" +pathResult); 
        System.out.println(">>>!!!" +pathResult.toAbsolutePath()); 

    }

    public static void main(String[] args) {
        PathPractice pathPractice = new PathPractice();

        pathPractice.pathUses();
        System.out.println("\n\n\t\t\t******** createDirectories");
        pathPractice.createDirectories();
        System.out.println("\n\n\t\t\t******** copyFiles");
        pathPractice.copyFiles();
        System.out.println("\n\n\t\t\t******** getInformationPath");
        pathPractice.getInformationPath();
        //Resolve should be read as "resolve path2 within path1 directory"
        System.out.println("\n\n\t\t\t******** resolvePath>>> Resolve should be read as \"resolve path2 within path1 directory");
        pathPractice.resolvePath();
        System.out.println("\n\n\t\t\t******** relativizePath");
        pathPractice.relativizePath();
        Path p1 = Paths.get("photos/../beaches/./calangute/a.txt");
        Path p2 = p1.normalize();
        Path p3 = p1.relativize(p2);
        Path p4 = p2.relativize(p1);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(
            p1.getNameCount()+" "+p2.getNameCount()+" "+
            p3.getNameCount()+" "+p4.getNameCount());
         ExecutorService executor = Executors.newFixedThreadPool(5);

        // Runnable, return void, nothing, submit and run the task async
        executor.submit(() -> System.out.println("I'm Runnable task."));
        
    }

}


