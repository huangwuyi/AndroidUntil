package com.cnhtc.cold.androidbasehelper;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class HuangwuyiGet extends HuangwuyiPost {
    public HuangwuyiGet(String url, Context context, JSONObject jsonObject) {
        super(url, context, jsonObject);
    }

    @Override
    protected JSONObject doInBackground(JSONObject... jsonObjects) {
        JSONObject jsonObjectResult;
        try {
            jsonObjectResult=new JSONObject(new HuangwuyiOkhttp().goGet(mUrl));
        } catch (IOException e) {
            e.printStackTrace();
            jsonObjectResult=new JSONObject();
        } catch (JSONException e) {
            e.printStackTrace();
            jsonObjectResult=new JSONObject();
        }
        return jsonObjectResult;
    }
}
