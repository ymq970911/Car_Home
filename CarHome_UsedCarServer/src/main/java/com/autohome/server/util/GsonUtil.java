package com.autohome.server.util;

import com.autohome.entity.UsedCarConfig;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Component;

/**
 * @program: car_home
 * @description:
 * @author: ztk
 * @create: 2020-08-08 23:54
 **/

public class GsonUtil {
    public static Gson gson = new Gson();
    public static JsonParser jsonParser = new JsonParser();

    //对象转JsonObject
    public static JsonObject setObjectToJsonObject(Object object) {
        JsonElement element = gson.toJsonTree(object);
        if (!element.isJsonNull()) {
            return element.getAsJsonObject();
        } else {
            return null;
        }
    }

    public static String setObjectToJsonString(UsedCarConfig carConfig) {
        return gson.toJson(carConfig);
    }

    //JsonObject转对象
    /*
           一脸懵逼不知道哪有问题
           (⊙ˍ⊙)(⊙ˍ⊙)(⊙ˍ⊙)
     */
    // public static <T> Object setJsonObjectToEntity(JsonObject jsonObject, Class<T> cls) {
    //     T tObject = gson.fromJson(jsonObject.getAsString(), cls);
    //     return tObject;
    // }

}
