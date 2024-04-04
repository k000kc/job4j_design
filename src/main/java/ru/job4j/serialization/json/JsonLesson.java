package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonLesson {
    public static void main(String[] args) {
        MainObject object = new MainObject(
                new OtheObject(1, "NoName"),
                true, 2, "Beliberda", new char[]{'a', 'b', 'c'});
        Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(object));
        String string = "{\"object\":{\"value\":1,\"name\":\"NoName\"},"
                + "\"isBoolean\":true,"
                + "\"index\":2,"
                + "\"text\":\"Beliberda\","
                + "\"chars\":[\"a\",\"b\",\"c\"]}";
        MainObject mainObject = gson.fromJson(string, MainObject.class);
        System.out.println(mainObject);
    }
}
