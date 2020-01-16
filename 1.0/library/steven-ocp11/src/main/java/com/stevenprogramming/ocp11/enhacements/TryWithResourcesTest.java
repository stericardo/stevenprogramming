package com.stevenprogramming.ocp11.enhacements;

import java.io.Closeable;
import java.io.IOException;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 14 2020
 * @version 1.0
 */
public class TryWithResourcesTest implements AutoCloseable{

  String header = null;

  public void open() {
    header = "OPENED";
    System.out.println("Device Opened");
  }

  public String read() throws IOException {
    throw new IOException("Unknown");
  }

  public void writeHeader(String str) throws IOException {
    System.out.println("Writing : " + str);
    header = str;
  }

  public void close() {
    header = null;
    System.out.println("Device closed");
  }

  public static void testDevice() {
    try (TryWithResourcesTest d = new TryWithResourcesTest()) {
      d.open();
      d.read();
      d.writeHeader("TEST");
      d.close();
    } catch (IOException e) {
      System.out.println("Got Exception");
    }
  }
  
  public static void main(String[] args) {
    AutoCloseable f;
    Closeable d;

    TryWithResourcesTest.testDevice();

            
            
  }

}
