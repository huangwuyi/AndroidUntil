package com.cnhtc.cold.androidbasehelper;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class HuangwuyiPostWithFile extends HuangwuyiPost {

    private File mFile;
    public HuangwuyiPostWithFile(String url, Context context, JSONObject jsonObject, File file) {
        super(url, context, jsonObject);
        mFile=file;
    }

    @Override
    protected JSONObject doInBackground(JSONObject... jsonObjects) {
        JSONObject jsonObjectResult;
        try {
            jsonObjectResult=new JSONObject( new HuangwuyiOkhttp().goPostWithFile(this.mUrl,this.mJSONObject,mFile));
        } catch (IOException e) {
            e.printStackTrace();
            jsonObjectResult=new JSONObject();
        } catch (JSONException e) {
            e.printStackTrace();
            jsonObjectResult=new JSONObject();
        } catch (Exception e){
            jsonObjectResult=new JSONObject();
        }
        return jsonObjectResult;
    }
}
