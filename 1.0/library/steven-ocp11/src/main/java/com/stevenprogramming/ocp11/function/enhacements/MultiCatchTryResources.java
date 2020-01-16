package com.stevenprogramming.ocp11.function.enhacements;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileSystemException;
import java.nio.file.NoSuchFileException;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 16 2020
 * @version 1.0
 */
public class MultiCatchTryResources {
  
  public static void main(String[] args) {
        try(BufferedReader bfr = new BufferedReader(new FileReader("c:\\works\\a.java"))){
            String line = null;
            while( (line = bfr.readLine()) != null){
                System.out.println(line);
            }
        /**
         * FileSystemException
         * Alternatives in a multi-catch statement cannot be related by subclassing
         * Alternative AccessDeniedException is a subclass of alternative FileSystemException
         * catch(FileNotFoundException | FileSystemException |AccessDeniedException e)
         * }catch(NoSuchFileException|IOException|AccessDeniedException e){
         * Alternatives in a multi-catch statement cannot be related by subclassing
         * Alternative NoSuchFileException is a subclass of alternative IOException
         */
        }catch(FileNotFoundException|SecurityException|IllegalArgumentException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

}
