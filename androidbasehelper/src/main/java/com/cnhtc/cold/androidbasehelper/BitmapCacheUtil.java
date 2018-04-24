package com.cnhtc.cold.androidbasehelper;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

public class BitmapCacheUtil {
    int maxMemory;
    int cacheSize;
    LruCache<String,Bitmap> mMemoryCache;

    public LruCache<String, Bitmap> getmMemoryCache() {
        return mMemoryCache;
    }

    public BitmapCacheUtil(){
        maxMemory= (int) (Runtime.getRuntime().maxMemory()/1024);
        cacheSize=maxMemory/8;
        mMemoryCache=new LruCache<String,Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes()*value.getHeight()/1024;
            }
        };
    }

    public Bitmap getCacheBitmap(String key){
        return mMemoryCache.get(key);
    }

    public void putCacheBitmap(String key,Bitmap value){
        mMemoryCache.put(key,value);
    }
}
