package com.stevenprogramming.library.core.ignore.lambda.book.mastering.ch1.part2.stevenimpl;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author steven.mendez
 * @since Aug 30 2017
 * @version 1.0
 */
public abstract class SerVivoBuilder {
    
    protected SerVivo serVivo;

    /**
     * @return the serVivo
     */
    public SerVivo getSerVivo() {
        return serVivo;
    }
    
    protected void setDefaultAge() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 10000 + 1);
        serVivo.setEdad(randomNum);
    }
    
    abstract <T extends SerVivo> void createNewSerVivo();
    
}
