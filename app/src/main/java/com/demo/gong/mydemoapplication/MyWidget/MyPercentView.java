package com.demo.gong.mydemoapplication.MyWidget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by TS_02 on 2018/11/29.
 */

public class MyPercentView extends View{

    private static final String TAG = MyPercentView.class.getSimpleName();
    private Paint mPaint;
    private RectF oval;

    public MyPercentView(Context context) {
        super(context);
        init();
    }

    public MyPercentView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyPercentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        oval = new RectF();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        Log.i(TAG, "onMeasure--widthMode-->" + widthMode);

        switch (widthMode) {
            case MeasureSpec.EXACTLY :
                break;
            case MeasureSpec.AT_MOST :
                break;
            case MeasureSpec.UNSPECIFIED :
                break;
        }

        Log.i(TAG, "onMeasure--widthSize-->" + widthSize);
        Log.i(TAG, "onMeasure--heightMode-->" + heightMode);
        Log.i(TAG, "onMeasure--heightSize-->" + heightSize);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.i(TAG,"onLayout");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);// FILL填充, STROKE描边,FILL_AND_STROKE填充和描边

        int width = getWidth();
        int height = getHeight();
        Log.i(TAG, "onDraw---->" + width + "*" + height);

        float radius = width / 4;

        canvas.drawCircle(width/2,width/2,radius,mPaint);

        mPaint.setColor(Color.BLUE);
        oval.set(width/2-radius,width/2-radius,width/2+radius,width/2+radius);//用于定义的圆弧的形状和大小的界限

        canvas.drawArc(oval,270,120,true,mPaint);//根据进度画圆弧
    }
}
