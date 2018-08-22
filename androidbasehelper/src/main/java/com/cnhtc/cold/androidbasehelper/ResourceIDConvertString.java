package com.cnhtc.cold.androidbasehelper;

import android.content.Context;
import android.content.res.Resources;

public class ResourceIDConvertString {
    public int String2ID(Context mcontext,String IDString,String type,String packageName){
        Resources resources=mcontext.getResources();
        return resources.getIdentifier(IDString,type,packageName);
    }
}
