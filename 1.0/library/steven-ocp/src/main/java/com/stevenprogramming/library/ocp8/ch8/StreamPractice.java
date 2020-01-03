package com.stevenprogramming.library.ocp8.ch8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author steven mendez
 */
public class StreamPractice {

    public static List<Dog> dogs = Arrays.asList(new Dog("Steven", 10, 40),
            new Dog("Steven2", 9, 70),
            new Dog("Steven3", 8, 130),
            new Dog("Steven3", 8, 130),
            new Dog("Steven4", 7, 20),
            new Dog("Steven5", 17, 130),
            new Dog("Steven5", 8, 70));

    public static void main(String[] args) {
        StreamPractice ch9GroupingPartioning = new StreamPractice();

        Map<Dog, Integer> map = new HashMap<Dog, Integer>();
        Integer valor = map.get(new Dog("Steven", 10, 40));
        System.out.println("Valor " + valor);
        System.out.println("sorted does --- works on the next line because of collector is a Map");
        ch9GroupingPartioning.printStream(dogs.stream().sorted((d1, d2) -> d1.getWeight() - d2.getWeight()));
        //sorted does not work on the next line because of collector is a Map
        System.out.println("sorted does not work on the next line because of collector is a Map");
        Map<Integer, List<Dog>> dogByWeight = dogs.stream().sorted((d1, d2) -> d1.getWeight() - d2.getWeight()).collect(Collectors.groupingBy(Dog::getWeight));
        dogByWeight.forEach((m, n) -> System.out.println("@ " + n));
        System.out.println("\n First Basic Example: " + dogByWeight);

        Map<Integer, Long> dogByWeight2 = dogs.stream().collect(Collectors.groupingBy(Dog::getWeight, Collectors.counting()));
        System.out.println("\n" + dogByWeight2);

        Map<Integer, List<Dog>> dogByWeight2222 = dogs.stream().collect(Collectors.groupingBy(Dog::getWeight, Collectors.toList()));
        System.out.println("\nMIRAVOS>>>>" + dogByWeight2222);

        Map<Integer, List<String>> dogByWeight3 = dogs.stream().collect(Collectors.groupingBy(Dog::getWeight, Collectors.mapping(Dog::getName2, Collectors.toList())));
        System.out.println("\n dogByWeight3 :::: " + dogByWeight3);

        Map<Integer, Map<String, List<Dog>>> dogByWeight33 = dogs.stream().collect(Collectors.groupingBy(Dog::getWeight, Collectors.groupingBy(Dog::getName, Collectors.toList())));
        System.out.println("\n dogByWeight333&&&&*** :::: " + dogByWeight33);

        Map<Integer, Map<String, List<Dog>>> dogByWeight3322 = dogs.stream().collect(Collectors.groupingBy(Dog::getWeight, Collectors.groupingBy(Dog::getName)));
        System.out.println("\n dogByWeight333&&&&*** :::: " + dogByWeight3322);

        Map<Boolean, List<Dog>> dogByWeight4 = dogs.stream().collect(Collectors.partitioningBy(d -> d.getWeight() > 50));
        System.out.println("\n\n\n Partitioning::: " + dogByWeight4);

        Map<Boolean, Long> dogByWeight5 = dogs.stream().collect(Collectors.partitioningBy(d -> d.getWeight() > 50, Collectors.counting()));
        System.out.println("\n\n\n Partitioning 55555 ::: " + dogByWeight5);

        Map<Boolean, List<String>> dogByWeight6 = dogs.stream().collect(Collectors.partitioningBy(d -> d.getWeight() > 50, Collectors.mapping(Dog::getName, Collectors.toList())));
        System.out.println("\n\n\n Partitioning::: " + dogByWeight6);

        Map<Boolean, Map<String, List<Dog>>> dogByWeight666 = dogs.stream().collect(Collectors.partitioningBy(d -> d.getWeight() > 50, Collectors.groupingBy(Dog::getName)));
        System.out.println("\n\n\n Partitioning666::: " + dogByWeight666);

        dogs = new ArrayList<>(dogs);
        dogs.add(new Dog("Steven4", 7, 20));
        dogs.add(new Dog("Steven4", 11, 20));
        Map<String, Integer> dogByWeight7 = dogs.stream().collect(Collectors.groupingBy(Dog::getName, Collectors.summingInt(Dog::getWeight)));
        System.out.println("\n\n\n Grouping Summing::: " + dogByWeight7);

        Map<String, Double> dogByWeight8 = dogs.stream().collect(Collectors.groupingBy(Dog::getName, Collectors.averagingDouble(Dog::getWeight)));
        System.out.println("\n\n\n Grouping Averaging::: " + dogByWeight8);

        String dogByWeight9 = dogs.stream().map(Dog::getName).collect(Collectors.joining(","));
        System.out.println("\n\n\n joining::: " + dogByWeight9);

        Stream<String> dogByWeight10 = dogs.stream().map(Dog::getName);
        System.out.println("\n\n\n joining::: " + dogByWeight10);
        ch9GroupingPartioning.printStream(dogByWeight10);

        Optional<Dog> oldest = dogs.stream().collect(Collectors.maxBy((d1, d2) -> d1.getWeight() - d2.getWeight()));
        oldest.ifPresent(d -> System.out.println("\n\n\n Oldest Dog::: " + d));

        try (Stream<String> linesFile = Files.lines(Paths.get("file.txt"))) {
            System.out.println("\n Lines Directly");
            ch9GroupingPartioning.printStream(linesFile);
        } catch (IOException e) {

        }

        try (Stream<String> linesFile = Files.lines(Paths.get("file.txt"))) {
            System.out.println("\n Lines Split - Only Map");
            ch9GroupingPartioning.printStream(linesFile.map(line -> line.split("%")));
        } catch (IOException e) {

        }

        try (Stream<String> linesFile = Files.lines(Paths.get("file.txt"))) {
            System.out.println("\n Lines Split - Only Flat Map");
            Stream<String[]> lines = linesFile.map(line -> line.split("%"));
            ch9GroupingPartioning.printStream(lines.flatMap(line -> Arrays.stream(line)));
        } catch (IOException e) {

        }

        Stream.iterate(0, n -> n + 1)
                .filter(x -> x % 2 != 0) //odd
                .limit(10)
                .forEach(System.out::println);

        //Map<String, String> hm = new ConcurrentHashMap<>();
        // hm.put(null, "asdf");  //1
        // hm.put("aaa", null);  //2
        //ch9GroupingPartioning.printStream(hm.entrySet().stream());
    }

    private <T> void printStream(Stream<T> stream) {
        stream.forEach(System.out::println);
    }

    private <T> void printStream2(Stream<T> stream) {
        stream.forEach(System.out::print);
    }

}

class Dog implements Comparable<Dog> {

    private String name;
    private int age;
    private int weight;

    public Dog(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String toString() {
        return "Name= " + this.name + " Age= " + this.age + " weight= " + this.weight;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public String getName2() {
        return this.name + "$";
    }

    @Override
    public int compareTo(Dog dog) {
        return this.weight > dog.getWeight() ? 1 : this.weight == dog.getWeight() ? 0 : -1;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) age;
        hash = 31 * hash + (int) weight;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dog other = (Dog) obj;
        if (this.age != other.age) {
            return false;
        }
        if (this.weight != other.weight) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
}
