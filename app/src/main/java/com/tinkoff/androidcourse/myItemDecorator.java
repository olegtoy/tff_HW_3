package com.tinkoff.androidcourse;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;

/**
 * Created by olegtojgildin on 09/10/2018.
 */

public class myItemDecorator extends DividerItemDecoration {
    public myItemDecorator(Context context){
        super(context, DividerItemDecoration.VERTICAL);
        setDrawable(context.getResources().getDrawable(R.drawable.divider));

    }
}
