package com.cnhtc.cold.androidbasehelper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapInSampleSizeUtil {
    public static Bitmap decodeSampledBitmapFromResource(Resources res,int resId,int reqWidth,int reqHeight){
        //First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options=new BitmapFactory.Options();
        options.inJustDecodeBounds=true;
        BitmapFactory.decodeResource(res,resId,options);
        //Calculate inSampleSize
        options.inSampleSize=calculateInSampleSize(options,reqWidth,reqHeight);
        //再次取样
        options.inJustDecodeBounds=false;
        return BitmapFactory.decodeResource(res,resId,options);
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        //Raw Height and Width of image
        final int height=options.outHeight;
        final int width=options.outWidth;
        int inSampleSize=1;
        if(height>reqHeight||width>reqWidth){
            final int halfHeight=height/2;
            final int halfWidth=width/2;
            //计算最大的取样值，是2的倍数
            while((halfHeight/inSampleSize)>=reqHeight&&(halfWidth/inSampleSize)>=reqWidth){
                inSampleSize*=2;
            }
        }
        return inSampleSize;
    }
}
