package com.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.json.Json;

import java.io.FileReader;

public class EnvConfig {

    public static JsonObject jsonObject;
    public static JsonObject jsonObject_EnvConfig;

    public static void loadJson(String searchEngine) {
        try {
            JsonElement element = JsonParser.parseReader(new FileReader("./src/test/resources/" + searchEngine + ".json"));
            jsonObject = element.getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadEnvData(String searchEngine) {
        try {
            JsonElement element = JsonParser.parseReader(new FileReader("./src/test/resources/env-data.json"));
            jsonObject_EnvConfig = element.getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getJsonElement(String element) {
        return jsonObject.get(element).toString().replaceAll("\"", "");
    }

    public static String getEnvJsonElement(String element) {
        return jsonObject_EnvConfig.get("SearchEngines").getAsJsonObject().get(element).toString().replaceAll("\"", "");
    }
}
