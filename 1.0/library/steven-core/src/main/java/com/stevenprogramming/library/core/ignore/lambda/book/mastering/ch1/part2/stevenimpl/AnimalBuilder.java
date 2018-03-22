package com.stevenprogramming.library.core.ignore.lambda.book.mastering.ch1.part2.stevenimpl;

/**
 *
 * @author steven.mendez
 * @since Aug 30 2017
 * @version 1.0
 */
public class AnimalBuilder extends SerVivoBuilder{

    @Override
    public <T extends SerVivo> void createNewSerVivo() {
        Animal animal = new Animal();
        animal.setRaza("default");
        this.serVivo = animal;
        setDefaultAge();
    }
    
}
