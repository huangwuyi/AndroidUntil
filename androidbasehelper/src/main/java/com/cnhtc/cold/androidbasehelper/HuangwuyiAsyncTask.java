package com.cnhtc.cold.androidbasehelper;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import android.widget.ProgressBar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class HuangwuyiAsyncTask extends AsyncTask<JSONObject,Integer,JSONObject> {
    private String mUrl;
    private Context mContext;
    private ProgressDialog mProgressDialog;
    private JSONObject mJSONObject;
    public HuangwuyiAsyncTask(String url, Context context,JSONObject jsonObject) {
        super();
        this.mUrl=url;
        this.mContext=context;
        this.mProgressDialog=new ProgressDialog(this.mContext);
        this.mJSONObject=jsonObject;
    }

    private void Initialized(){
        mProgressDialog.setTitle("提示");
        mProgressDialog.setMessage("正在操作，请稍候！");
        mProgressDialog.setCancelable(false);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressDialog.show();
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);
        //1
        mProgressDialog.dismiss();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(JSONObject jsonObject) {
        super.onCancelled(jsonObject);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected JSONObject doInBackground(JSONObject... jsonObjects) {
        JSONObject jsonObjectResult;
        try {
            jsonObjectResult=new JSONObject( new HuangwuyiOkhttp().goPost(mUrl,mJSONObject));
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
