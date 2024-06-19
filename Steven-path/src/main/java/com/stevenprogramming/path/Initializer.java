package com.stevenprogramming.path;

import com.stevenprogramming.path.util.IOUtil;

public final class Initializer {

    private static Initializer initializer;

    private Initializer(){}

    public static Initializer getInstance(){
        if (initializer == null){
            synchronized (Initializer.class){
                if (initializer == null){
                    initializer =  new Initializer();
                }
            }
        }
        return initializer;
    }

    public void init(){
        getIOUtil();
    }

    public IOUtil getIOUtil(){
        return IOUtil.getInstance();
    }
}
