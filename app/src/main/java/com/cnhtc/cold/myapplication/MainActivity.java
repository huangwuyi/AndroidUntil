package com.cnhtc.cold.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cnhtc.cold.androidbasehelper.HuangwuyiPost;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

//    20180330
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new HuangwuyiPost("",MainActivity.this,new JSONObject()){
            @Override
            protected void onSuccess(JSONObject jsonObject) {
                super.onSuccess(jsonObject);
                //调用方法成功后的信息在这里显示
            }

            @Override
            protected void onFailure(JSONObject jsonObject) {
                super.onFailure(jsonObject);
                //调用方法失败后的信息在这里显示
            }
        }.execute();

    }
}
