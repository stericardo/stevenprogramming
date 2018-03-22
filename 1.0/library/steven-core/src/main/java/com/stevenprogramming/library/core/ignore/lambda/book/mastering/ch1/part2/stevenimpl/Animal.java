package com.stevenprogramming.library.core.ignore.lambda.book.mastering.ch1.part2.stevenimpl;

/**
 *
 * @author steven.mendez
 */
public class Animal extends SerVivo {

    private String raza;
    private String type;
    
    @Override
    public void comer() {

    }

    /**
     * @return the raza
     */
    public String getRaza() {
        return raza;
    }

    /**
     * @param raza the raza to set
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

}
