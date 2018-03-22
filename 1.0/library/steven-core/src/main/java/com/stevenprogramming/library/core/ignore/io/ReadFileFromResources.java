package com.stevenprogramming.library.core.ignore.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/**
 *
 * @author steven.mendez
 * @since Nov 10 2017
 * @version 1.0
 */
public class ReadFileFromResources {

    public InputStream readFile(String fileName) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName);
        return is;
    }

    public String getStringFromInputStream(InputStream is) {
        String result = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))
                .lines().collect(Collectors.joining("\n"));
        return result;
    }

    public String getStringFromFile(String fileName) {
        return getStringFromInputStream(readFile(fileName));
    }

    public String getStringParallelFromFile(String fileName) {
        InputStreamReader inputStreamReader = new InputStreamReader(readFile(fileName), StandardCharsets.UTF_8);
        if (null != inputStreamReader) {
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            if (null != bufferedReader) {
                String result = bufferedReader.lines().collect(Collectors.joining("\n"));
                try {
                    bufferedReader.close();
                } catch (IOException ignored) {
                }
                return result;
            }
        }
        return "NULL";
    }

    public StringBuilder getStringBuilderFromFile(String fileName, String encoding) {
        final StringBuilder out = new StringBuilder();
        Reader in = null;
        try {
            final int bufferSize = 1024;
            final char[] buffer = new char[bufferSize];
            in = new InputStreamReader(readFile(fileName), encoding);
            for (;;) {
                int rsz = in.read(buffer, 0, buffer.length);
                if (rsz < 0) {
                    break;
                }
                out.append(buffer, 0, rsz);
            }

        } catch (UnsupportedEncodingException ignored) {
            System.out.println(UnsupportedEncodingException.class.getName() + "\t" + ignored.toString());
        } catch (IOException ignored) {
            System.out.println(IOException.class.getName() + "\t" + ignored.toString());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ignored) {
            }
        }
        return out;
    }

    public static void main(String[] args) {
        ReadFileFromResources readFileFromResources = new ReadFileFromResources();
        System.out.println(readFileFromResources.getStringFromFile("read.txt"));
        System.out.println(readFileFromResources.getStringParallelFromFile("read.txt"));
        System.out.println(readFileFromResources.getStringBuilderFromFile("read.txt", "UTF-8"));

    }
}
