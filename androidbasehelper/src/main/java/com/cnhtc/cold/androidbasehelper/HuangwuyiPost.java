package com.cnhtc.cold.androidbasehelper;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class HuangwuyiPost extends AsyncTask<JSONObject,Integer,JSONObject> {
    protected String mUrl;
    protected Context mContext;
    protected ProgressDialog mProgressDialog;
    protected JSONObject mJSONObject;
    public HuangwuyiPost(String url, Context context, JSONObject jsonObject) {
        super();
        this.mUrl=url;
        this.mContext=context;
        this.mProgressDialog=new ProgressDialog(this.mContext);
        this.mJSONObject=jsonObject;
    }

    public HuangwuyiPost(HuangwuyiParameter huangwuyiParameter) {
        super();
        this.mUrl=huangwuyiParameter.getmUrl();
        this.mContext=huangwuyiParameter.getmContext();
        this.mProgressDialog=new ProgressDialog(this.mContext);
        this.mJSONObject=new JSONObject();
        try {
            this.mJSONObject.put("action",huangwuyiParameter.getmAction());
            this.mJSONObject.put("datetime",huangwuyiParameter.getmDateTime());
            this.mJSONObject.put("sign",huangwuyiParameter.getmSign());
            this.mJSONObject.put("data",huangwuyiParameter.getmData());
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
        try {
            if(jsonObject.getBoolean("success")){
                onSuccess(jsonObject);
            }else{
                onFailure(jsonObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            onLosed();
        }
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
        } catch (Exception e){
            jsonObjectResult=new JSONObject();
        }
        return jsonObjectResult;
    }

    protected void onSuccess(JSONObject jsonObject){
        System.out.println(jsonObject);
        Toast.makeText(this.mContext,"获取成功",Toast.LENGTH_SHORT).show();
    }

    protected void onFailure(JSONObject jsonObject){
        Toast.makeText(this.mContext,"获取信息失败，可能的原因是：",Toast.LENGTH_LONG).show();
    }

    protected void onLosed(){
        Toast.makeText(this.mContext,"获取信息失败，失败的很彻底。",Toast.LENGTH_LONG).show();
    }
}
