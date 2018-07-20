package com.cnhtc.cold.androidbasehelper;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

public class SpinnerAdapterCenter extends ArrayAdapter {

    public SpinnerAdapterCenter(@NonNull Context context,  @NonNull List objects) {
        super(context, R.layout.spinner_item_select, R.id.textView, objects);
    }
}
