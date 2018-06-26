package com.cnhtc.cold.androidbasehelper;

import android.content.Context;

import org.json.JSONObject;

public class HuangwuyiParameter {
    private String mUrl;
    private Context mContext;
    private String mAction;
    private String mDateTime;
    private String mSign;
    private JSONObject mData;

    public HuangwuyiParameter(String mUrl, Context mContext, String mAction, String mDateTime, String mSign, JSONObject mData) {
        this.mUrl = mUrl;
        this.mContext=mContext;
        this.mAction = mAction;
        this.mDateTime = mDateTime;
        this.mSign = mSign;
        this.mData = mData;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public String getmUrl() {
        return mUrl;
    }

    public String getmAction() {
        return mAction;
    }

    public String getmDateTime() {
        return mDateTime;
    }

    public String getmSign() {
        return mSign;
    }

    public JSONObject getmData() {
        return mData;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public void setmAction(String mAction) {
        this.mAction = mAction;
    }

    public void setmDateTime(String mDateTime) {
        this.mDateTime = mDateTime;
    }

    public void setmSign(String mSign) {
        this.mSign = mSign;
    }

    public void setmData(JSONObject mData) {
        this.mData = mData;
    }
}
