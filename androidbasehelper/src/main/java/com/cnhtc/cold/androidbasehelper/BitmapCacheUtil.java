package com.cnhtc.cold.androidbasehelper;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v4.util.LruCache;

import com.jakewharton.disklrucache.DiskLruCache;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BitmapCacheUtil {
    int maxMemory;
    int cacheSize;
    LruCache<String,Bitmap> mMemoryCache;
    DiskLruCache mDiskCache;


    public LruCache<String, Bitmap> getmMemoryCache() {
        return mMemoryCache;
    }

    public BitmapCacheUtil(Context context){
        maxMemory= (int) (Runtime.getRuntime().maxMemory()/1024);
        cacheSize=maxMemory/8;
        mMemoryCache=new LruCache<String,Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes()*value.getHeight()/1024;
            }
        };
        File diskCacheDir=new File("getDiskCacheDir(context)") ;
        if(!diskCacheDir.exists()){
            diskCacheDir.mkdirs();
        }
        try {
            mDiskCache=DiskLruCache.open(diskCacheDir,1,1,1024*1024*50);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDiskCacheDir(Context context) {
        String cachePath = null;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        return cachePath;
    }

    public Bitmap getCacheBitmap(String key){
        return mMemoryCache.get(key);
    }

    public void putCacheBitmap(String key,Bitmap value){
        mMemoryCache.put(key,value);
    }
}
