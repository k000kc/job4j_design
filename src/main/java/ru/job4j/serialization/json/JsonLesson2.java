package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonLesson2 {
    public static void main(String[] args) {
        /* JSONObject из json-строки строки */
        JSONObject jsonOtherObject = new JSONObject("{\"value\":1,\"name\":\"NoName\"}");

        /* JSONArray из ArrayList */
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        JSONArray chars = new JSONArray(list);

        /* JSONObject напрямую методом put */
        MainObject mainObject = new MainObject(new OtheObject(1, "NoName"),
                true, 2, "Beliberda", new char[]{'a', 'b', 'c'});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("object", jsonOtherObject);
        jsonObject.put("boolean", true);
        jsonObject.put("index", 2);
        jsonObject.put("text", "Beliberda");
        jsonObject.put("chars", chars);

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(mainObject).toString());

    }
}
