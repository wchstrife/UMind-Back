package com.wchstife.umind.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class UMindJSONUtil {
    public static  <T> T jsonToBean(String json, Class<T> clazz) throws IOException {
        if(null == json){

            return null;
        }else{

            return new ObjectMapper().readValue(json , clazz);
        }
    }

    public static  <T> T jsonToBean(JSONObject json, Class<T> clazz) throws IOException {
        if(null == json){

            return null;
        }else{

            return new ObjectMapper().readValue(json.toString() , clazz);
        }
    }

    public static JSONObject beanToJson(Object object) throws IOException {
        if(null == object){

            return null;
        }else{

            return JSONObject.parseObject(new ObjectMapper().writeValueAsString(object));
        }
    }

    public static JSONArray listToJson(List<?> objectList) throws IOException {
        if(null == objectList){

            return null;
        }else{
            JSONArray ja = new JSONArray();
            for (Object object: objectList) {
                if(object instanceof String){
                    ja.add(object);
                }else{
                    ja.add(beanToJson(object));
                }
            }

            return ja;
        }
    }
}
