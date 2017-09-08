package com.stevenprogramming.library.core.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author steven.mendez
 * @since Sep 08 2017
 * @version 1.0
 */
public class TestGson {
    
    public static JsonObject generateGson(String json) {
        Gson gson = new Gson();
        try {
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            return jsonObject;
        } catch (com.google.gson.JsonSyntaxException ex) {
            return null;
        }
    }
    
    public static void main(String[] args){
        String tabName = "Make_A_PAYMENT";
        JsonParser parser = new JsonParser();
        JsonObject obj = (JsonObject) parser.parse(GsonConstants.FIRST_GSON);
        System.out.println(obj.toString());
        Map<String, Object> map = new HashMap<>();
        map.put(tabName, new JsonObject());
        JsonObject jsonObjectTemp = (JsonObject)map.get(tabName);
        boolean isJson = GsonUtil.isJsonObject(tabName);
        Gson gson2 = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        System.out.println(isJson);
        isJson = GsonUtil.isJsonObject(GsonConstants.ARRAY_INTERNAL_GSON);
        System.out.println(isJson);
        isJson = GsonUtil.isJsonObject(GsonConstants.FIRST_GSON);
        System.out.println(isJson);
        JsonObject jsonObjectGenerated = generateGson(GsonConstants.SIMPLE_JSON);
        String result = jsonObjectGenerated.get("siteconfigkey").getAsString();
        System.out.println(jsonObjectGenerated.toString());
        GsonUtil.demostration(); 
    }

}
