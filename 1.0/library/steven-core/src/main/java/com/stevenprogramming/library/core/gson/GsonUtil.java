package com.stevenprogramming.library.core.gson;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 *
 * @author steven.mendez
 * @since Sep 08 2017
 * @version 1.0
 */
public final class GsonUtil {

    public static void demostration() {
        JsonObject keyValuePairJson = generateGsonToObject(GsonConstants.SIMPLE_JSON);
        //String siteConfigKey = keyValuePairJson.get(GsonConstants.SITE_CONFIG_KEY).getAsString();
        String siteConfigURL = keyValuePairJson.get(GsonConstants.SITE_CONFIG_URL).getAsString();
        keyValuePairJson.addProperty(GsonConstants.NEW_PROPERTY, GsonConstants.NEW_PROPERTY);
        JsonArray resultArrayValue = generateGsonArray(GsonConstants.ARRAY_GSON);
        keyValuePairJson.add(GsonConstants.NEW_ARRAY, resultArrayValue);
        System.out.print(siteConfigURL);
    }
    
    public static boolean isJsonObject(String json) {
        if ("".equals(json) || " ".equals(json)) {
            return false;
        }
        //Gson gson = new Gson();
        try {
            //JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            return true;
        } catch (com.google.gson.JsonSyntaxException ex) {
            return false;
        }
    }

    public static boolean isJsonArray(String json) {
        if ("".equals(json) || " ".equals(json)) {
            return false;
        }
        //Gson gson = new Gson();
        try {
            //JsonArray jsonArray = gson.fromJson(json, JsonArray.class);
            return true;
        } catch (com.google.gson.JsonSyntaxException ex) {
            return false;
        }
    }

    public static String generateGson(String json) {
        Gson gson = new Gson();
        try {
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            return jsonObject.toString();
        } catch (com.google.gson.JsonSyntaxException ex) {
            return null;
        }
    }

    public static JsonObject generateGsonToObject(String json) {
        Gson gson = new Gson();
        try {
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            return jsonObject;
        } catch (com.google.gson.JsonSyntaxException ex) {
            return null;
        }
    }

    public static JsonArray generateGsonArray(String json) {
        Gson gson = new Gson();
        try {
            JsonArray jsonArray = gson.fromJson(json, JsonArray.class);
            return jsonArray;
        } catch (com.google.gson.JsonSyntaxException ex) {
            return null;
        }
    }

}
