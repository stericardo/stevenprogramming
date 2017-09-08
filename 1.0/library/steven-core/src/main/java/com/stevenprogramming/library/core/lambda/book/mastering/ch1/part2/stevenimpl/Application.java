package com.stevenprogramming.library.core.lambda.book.mastering.ch1.part2.stevenimpl;

import java.util.Comparator;

/**
 *
 * @author steven.mendez
 * @since Sep 01 2017
 * @version 1.0
 */
public class Application {

    public static void main(String[] args) {

        Builder builderPersona = new Builder();
        Builder builderAnimal = new Builder();
        SerVivoBuilder serVivoAnimalBuilder = new AnimalBuilder();
        SerVivoBuilder serVivoPersonaBuilder = new PersonaBuilder();
        builderPersona.setSerVivoBuilder(serVivoPersonaBuilder);
        builderAnimal.setSerVivoBuilder(serVivoAnimalBuilder);
        builderPersona.buildSerVivo();
        builderAnimal.buildSerVivo();
        Persona persona = (Persona) builderPersona.getSerVivo();
        Animal animal = (Animal) builderAnimal.getSerVivo();
        // The next prints: Persona color > default Animal raza > default
        System.out.println("Persona color > " + persona.getColor() + " Animal raza > " + animal.getRaza());
        
        OrderElements<SerVivo, Integer> orderElements = serVivo -> serVivo.getEdad();
        Comparator<Integer> keyComparer = (edad1, edad2) -> Integer.compare(edad1, edad2);
        Comparator<SerVivo> compareSerVivo = (serVivo1, serVivo2) -> keyComparer.compare(orderElements.order(serVivo1),
          orderElements.order(serVivo2));
        
    }

}
