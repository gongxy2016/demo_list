package com.demo.gong.mydemoapplication.DemoEtTest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

public class EtTestWidget extends AppCompatEditText {

    private CharSequence hint;
    private Paint mPaint;
    private int mHintTextColor;

    public EtTestWidget(Context context) {
        super(context);
    }

    public EtTestWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EtTestWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
        hint = getHint();
        mPaint.setTextAlign(Paint.Align.RIGHT);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }
}
