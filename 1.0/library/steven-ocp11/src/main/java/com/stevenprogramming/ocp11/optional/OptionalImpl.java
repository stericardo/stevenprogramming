package com.stevenprogramming.ocp11.optional;

import com.stevenprogramming.ocp11.stream.UtilStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Jan 12 2020
 * @version 1.0
 */
public class OptionalImpl {

  public static void main(String[] args) {
    String expected = "properValue";
    Optional<String> value = Optional.of(expected);
    Optional<String> defaultValue = Optional.of("default");
    Optional<String> valueEmpty = Optional.empty();

    // or method receive a Supplier
    Optional<String> result = value.or(() -> defaultValue);

    UtilStream.printOptional(result, "Result printing");
    UtilStream.printOptional(value, "value printing");
    UtilStream.printOptional(defaultValue, "defaultValue printing");
    UtilStream.printOptional(valueEmpty, "valueEmpty printing");

    valueEmpty = valueEmpty.or(() -> defaultValue);
    UtilStream.printOptional(valueEmpty, "valueEmpty printing");

    AtomicInteger successCounter = new AtomicInteger(0);
    valueEmpty = Optional.empty();
    valueEmpty.ifPresentOrElse(v -> successCounter.incrementAndGet(),
            () -> System.out.println("Runnable " + successCounter));
    System.out.println(successCounter);

    valueEmpty = valueEmpty.or(() -> defaultValue);
    valueEmpty.ifPresentOrElse(v -> successCounter.incrementAndGet(),
            () -> System.out.println("Runnable " + successCounter));
    System.out.println(successCounter);

    List<Optional<String>> listOfOptionals = Arrays.asList(
            Optional.empty(), Optional.of("foo"), Optional.empty(), Optional.of("bar"), Optional.empty());

    List<String> filteredList = listOfOptionals.stream()
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());
    UtilStream.printStream(filteredList.stream(), "List after filter + map" + filteredList.size());

    listOfOptionals = Arrays.asList(
            Optional.empty(), Optional.of("foo"), Optional.empty(), Optional.of("bar"), Optional.empty());
    filteredList = listOfOptionals.stream()
            .filter(Optional::isEmpty)
            .map(v -> v.isPresent() ? v.get() : defaultValue.get())
            .collect(Collectors.toList());
    UtilStream.printStream(filteredList.stream(), "List after filter + map" + filteredList.size());

    filteredList = listOfOptionals.stream()
            .flatMap(Optional::stream)
            .collect(Collectors.toList());
    UtilStream.printStream(filteredList.stream(), "List after flatMap + collect" + filteredList.size());

    String name = Optional.of("steven").orElse("orElse");
    name = Optional.of("steven").orElseGet(() -> "orElseGet");
    
    StringBuilder resultFinal = new StringBuilder();
    Optional.of("steven").or(() -> Optional.of("default")).ifPresent(i -> resultFinal.append(i));
    System.out.println("\n***" + resultFinal.toString());
    Optional.of("").or(() -> Optional.of("default")).ifPresent(i -> resultFinal.append(i + "i"));
    System.out.println("\n***" + resultFinal.toString());

    Optional<Integer> op
            = Optional.of(9456);

    // print value 
    System.out.println("Optional: "
            + op);

    // filter the value 
    System.out.println("Filtered value "
            + "for odd or even: "
            + op
                    .filter(num
                            -> num % 2 != 0));
    
        System.out.println("Filtered value "
            + "for odd or even: "
            + op
                    .filter(num
                            -> num % 2 == 0));
  }

}
