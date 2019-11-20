package com.demo.gong.mydemoapplication.DemoMotionEvent;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class LinearLayoutEventTest extends LinearLayout {
    public LinearLayoutEventTest(Context context) {
        super(context);
    }

    public LinearLayoutEventTest(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LinearLayoutEventTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = false;
        int y = (int) ev.getY();
        int nowY = 0;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN :
                nowY = y;
                intercepted = super.onInterceptTouchEvent(ev);
                break;

            case MotionEvent.ACTION_UP :
                intercepted = false;
                break;
        }
        return intercepted;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
