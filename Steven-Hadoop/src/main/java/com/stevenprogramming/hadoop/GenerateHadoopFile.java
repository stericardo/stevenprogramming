package com.stevenprogramming.hadoop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;

public class GenerateHadoopFile {

    final static int GIGA_MEDIUM_1_5_SIZE = 1_500_000_000; // 1.5 gb
    final static String HADOOP_FILE = "hadoop.file";
    final static String PATH = System.getProperty("user.home");

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        System.out.println("WRITE Hadoop File on directory: " + PATH);
        StringBuilder stringBuilder = new StringBuilder(GIGA_MEDIUM_1_5_SIZE);

        for(int cont = 0; cont < GIGA_MEDIUM_1_5_SIZE; cont++) {
            stringBuilder.append("ab");
            if(cont % 100000 == 0) {
                stringBuilder.append("\n");
            }
        }

        File homeDir = new File(PATH);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(homeDir +
                FileSystems.getDefault().getSeparator() + HADOOP_FILE))){
            writer.append(stringBuilder);
        } catch (IOException e) {
            System.out.println("\n\n\n ERROR: " + e.getMessage());
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds
        System.out.println("\n\n\n File size generated: " + new File(homeDir +
                FileSystems.getDefault().getSeparator() + HADOOP_FILE).length() + "\n\n Execution time " + duration );

    }
}
