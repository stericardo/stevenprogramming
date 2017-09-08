package com.stevenprogramming.library.core.lambda.book.mastering.ch1.part2.stevenimpl;

/**
 *
 * @author steven.mendez
 * @since Aug 30 2017
 * @version 1.0
 */
public class Builder {
    
    private SerVivoBuilder serVivoBuilder;

    /**
     * @param serVivoBuilder the serVivoBuilder to set
     */
    public void setSerVivoBuilder(SerVivoBuilder serVivoBuilder) {
        this.serVivoBuilder = serVivoBuilder;
    }
    
    public SerVivo getSerVivo() {
        return serVivoBuilder.getSerVivo();
    }
    
    public void buildSerVivo(){
        serVivoBuilder.createNewSerVivo();
    }

}
