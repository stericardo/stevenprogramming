package com.stevenprogramming.library.core.lambda.book.mastering.ch1.part2.stevenimpl;

/**
 *
 * @author steven.mendez
 * @since Aug 30 2017
 * @version 1.0
 */
public class PersonaBuilder extends SerVivoBuilder{
    
    @Override
    public <T extends SerVivo> void createNewSerVivo() {
        Persona persona = new Persona();
        persona.setColor("default");
        this.serVivo = persona;
        setDefaultAge();
    }

}
