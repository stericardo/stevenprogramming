package com.stevenprogramming.hadoop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;

public class GenerateHadoopFile {

    //472000000 lOOP = 472 MB
    //if you append ab then outome is 472 MB * 2 ALMOST 1 GB
    // Please use -Xms1024m -Xmx8096m
    // output file 2.7 GB calling writer.append(getStringBuilder()); 3 times
    final static int MEDIUM_GIGABYTE_0_5_SIZE = 4_72_000_000; // 0.5 gb
    final static String HADOOP_FILE = "hadoop.file";
    final static String PATH = System.getProperty("user.home");

    public static StringBuilder getStringBuilder(){
        StringBuilder stringBuilder = new StringBuilder(1_000_000_000 );

        for(int cont = 0; cont < MEDIUM_GIGABYTE_0_5_SIZE; cont++) {
            stringBuilder.append("ab");
            if(cont % 100000 == 0) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        System.out.println("WRITE Hadoop File on directory: " + PATH);

        File homeDir = new File(PATH);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(homeDir +
                FileSystems.getDefault().getSeparator() + HADOOP_FILE))){
            writer.append(getStringBuilder());
            writer.append(getStringBuilder());
            writer.append(getStringBuilder());
            writer.append(getStringBuilder());
            writer.append(getStringBuilder());
        } catch (IOException e) {
            System.out.println("\n\n\n ERROR: " + e.getMessage());
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;  //divide by 1000000 to get milliseconds
        duration /= 1000;  //divide by 1000 to get seconds
        System.out.println("\n\n\n File size generated: " + new File(homeDir +
                FileSystems.getDefault().getSeparator() + HADOOP_FILE).length() + "\n\n Execution time " + duration +
                " seconds");

    }
}
