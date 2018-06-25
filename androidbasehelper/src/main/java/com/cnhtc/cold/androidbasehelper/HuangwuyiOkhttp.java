package com.cnhtc.cold.androidbasehelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.BufferedSink;

public class HuangwuyiOkhttp {
    public OkHttpClient huangwuyiOkHttpClient;
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public HuangwuyiOkhttp() {
        huangwuyiOkHttpClient = new OkHttpClient();
    }

    public String goPost(String url, JSONObject jsonObjectParameter) throws IOException, JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("", "");
        RequestBody requestBody = RequestBody.create(JSON, "");
        FormBody.Builder formBody = new FormBody.Builder();
        Iterator<String> iterator = jsonObjectParameter.keys();
        while (iterator.hasNext()) {
            String currentKey = iterator.next();
            formBody.add(currentKey, jsonObjectParameter.getString(currentKey));
        }
        Request request = new Request.Builder()
                .url(url)
                .post(formBody.build())
                .build();
        return huangwuyiOkHttpClient.newCall(request).execute().body().string();
    }

    public String goPostWithFile(String url, JSONObject jsonObjectParameter, File file) throws IOException, JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("", "");
        Iterator<String> iterator = jsonObjectParameter.keys();

        MultipartBody.Builder multipartBodyBuilder = new MultipartBody.Builder();
        multipartBodyBuilder.setType(MultipartBody.FORM)
                .addFormDataPart("file", null, new MultipartBody.Builder()
                        .addPart(Headers.of("Content-Disposition", "form-data; filename=\"img.png\""),
                                RequestBody.create(MediaType.parse("image/png"), file)).build());
        while (iterator.hasNext()) {
            String currentKey = iterator.next();
            multipartBodyBuilder.addFormDataPart(currentKey, jsonObjectParameter.getString(currentKey));
        }

        Request request = new Request.Builder()
                .url(url)
                .post(multipartBodyBuilder.build())
                .build();
        return huangwuyiOkHttpClient.newCall(request).execute().body().string();
    }
}
