package com.demo.gong.mydemoapplication.DemoMotionEvent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class BtnEventTest extends android.support.v7.widget.AppCompatButton {

    public BtnEventTest(Context context) {
        super(context);
    }

    public BtnEventTest(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BtnEventTest(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

}
