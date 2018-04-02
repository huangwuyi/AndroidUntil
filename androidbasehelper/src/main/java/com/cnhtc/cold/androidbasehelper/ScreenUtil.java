package com.cnhtc.cold.androidbasehelper;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class ScreenUtil {
    /**
     * 获取屏幕相关参数
     */

    public  static DisplayMetrics getScreenSize(Context context){
        DisplayMetrics displayMetrics=new DisplayMetrics();
        WindowManager windowManager= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display=windowManager.getDefaultDisplay();
        display.getMetrics(displayMetrics);
        return displayMetrics;
    }
    /**
     * 获取屏幕的密度
     */

    public static float getDeviceDensity(Context context){
        DisplayMetrics displayMetrics=new DisplayMetrics();
        WindowManager windowManager= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display=windowManager.getDefaultDisplay();
        display.getMetrics(displayMetrics);
        return displayMetrics.density;
    }
}
