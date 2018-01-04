package com.revature.curriculumservice.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonMaker {

    private Gson gson = null;

    public JsonMaker(){
         gson = new GsonBuilder()
                .serializeNulls()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .create();
    }

    public String toJsonString(Object anObject){
        try {
            return getGson().toJson(anObject);
        }catch (NullPointerException ex){
            return "";
        }
    }

    public Gson getGson() {
        return gson;
    }

}
