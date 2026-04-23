package com.stevenprogramming.path.util;

import java.io.File;
import java.io.IOException;

public class IOUtil {

    private static IOUtil ioUtilInstance;

    private IOUtil(){

    }

    public static IOUtil getInstance(){
        if (ioUtilInstance == null){
            synchronized (IOUtil.class){
                if (ioUtilInstance == null){
                    ioUtilInstance =  new IOUtil();
                }
            }
        }
        return ioUtilInstance;
    }

    public File getFile(String path) throws IOException {
        return new java.io.File(path);
    }

    public String getCanonicalPath(String path) throws IOException{
        return getFile(path).getCanonicalPath();
    }

    public String removePartOfString(String source, String remove){
        return source.substring(source.indexOf(remove) + remove.length());
    }
}
