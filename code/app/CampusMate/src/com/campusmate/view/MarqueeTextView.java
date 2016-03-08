package com.campusmate.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class MarqueeTextView extends TextView{


    public MarqueeTextView(Context context) {
        super(context);
    }
 
    public MarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
 
    public MarqueeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
 
    //始终返回true，即一直获得焦点
    @Override
    public boolean isFocused() {
        return true;
    }
}
