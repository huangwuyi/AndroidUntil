package com.cnhtc.cold.androidbasehelper;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;

public class TextPath {
    private Paint mTextPaint;
    private String mText;
    private Path mPath;
    private PathMeasure mPathMesaure;
    private Float mPathLength;

    public TextPath(Paint mTextPaint, String mText) {
        this.mTextPaint = mTextPaint;
        this.mText = mText;

        initialized();
    }

    public void initialized(){
        mTextPaint.getTextPath(mText,0,mText.length(),0,mTextPaint.getTextSize(),mPath);
        mPathMesaure.setPath(mPath,false);
        mPathLength=mPathMesaure.getLength();
        while (mPathMesaure.nextContour()){
            mPathLength+=mPathMesaure.getLength();
        }
    }
}
