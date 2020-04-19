package com.stevenprogramming.ocp11.consumer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 07 2020
 * @version 1.0
 */
public class ConsumerImpl {

  public Integer temp = 0;
  final static ConsumerImpl con = new ConsumerImpl();
  
  public static void main(String[] args) {
    DoubleConsumer dcons = i -> System.out.println( i * 2.5 ); 
    IntConsumer icons = i -> System.out.println( i + 150 );
    
    //void accept(double value)
    dcons.accept(3);
    
    //void accept(int value)
    icons.accept(23);
    Integer g = 0;
    Consumer<String> c = (x) -> {System.out.println(con.temp + "Lower>" + x.toLowerCase());
    ++con.temp;};
    Consumer<String> c1 = (x) -> {System.out.println(con.temp + "Lowerc1>" + x.toLowerCase());
    ++con.temp;};
    c.andThen(c1).accept("Java2s.com");
    Stream k;
    
    Map<String, List<Double>> groupedValues = new HashMap<>();
    var nums = List.of(1, 2, 3, 4).stream();
    Stream<Integer> d = List.of(1, 2, 3, 4).stream();
    Comparable k2;
    
    Comparator hdjf;
    
    Predicate<Integer> even = i-> i == 0;
    String l = "aa";
    System.out.println(l.compareTo("aa"));
   
    ArrayList<Data> al = new ArrayList<Data>();
        al.add(new Data(1));al.add(new Data(2));al.add(new Data(3));
        
    printUsefulData(al, (i)-> {return i.value>2;}  );
    
  }
  public static void printUsefulData(List l, Predicate<Data> p){
  }
}

 class Data{
    int value;
    Data(int value){
        this.value = value;
    }
}
