package com.cnhtc.cold.androidbasehelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.BufferedSink;

public class HuangwuyiOkhttp {
    public OkHttpClient huangwuyiOkHttpClient;
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    public HuangwuyiOkhttp(){
        huangwuyiOkHttpClient=new OkHttpClient();
    }

    public String goPost(String url) throws IOException, JSONException {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("","");
        RequestBody requestBody=RequestBody.create(JSON,"");
        FormBody.Builder formBody=new FormBody.Builder();
        Request request= new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return  huangwuyiOkHttpClient.newCall(request).execute().body().string();
    }
}
