package com.stevenprogramming.ocp11.method;

public class MethodImpl {

    /**
     * Reference to a static method (args) -> ClassName.staticMethodName(args)
     *
     * @param value
     * @return
     */
    public static String getValue(String value){
        return value + value;
    }

    public String getValues(String value){
        return value + value;
    }

}
