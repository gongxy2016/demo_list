package com.demo.gong.mydemoapplication.DemoEtTest;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.util.AttributeSet;

public class EtTestWidget extends AppCompatEditText {

    private CharSequence mHint;
    private Paint mPaint;
    private int mHintTextColor;

    public EtTestWidget(Context context) {
//        super(context);
        this(context,null);
    }

    public EtTestWidget(Context context, AttributeSet attrs) {
//        super(context, attrs);
        this(context,attrs,android.support.v7.appcompat.R.attr.editTextStyle);
    }

    public EtTestWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mHint = getHint();
        setHint("");
        mPaint = new Paint();
        mPaint.setTextAlign(Paint.Align.RIGHT);
        mPaint.setTextSize(getTextSize());

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (TextUtils.isEmpty(mHint) || !TextUtils.isEmpty(getText())) {
            return;
        }

        canvas.save();

        ColorStateList hintTextColors = getHintTextColors();

        if (hintTextColors != null) {
            int color = hintTextColors.getColorForState(getDrawableState(),0);

            if (color != mHintTextColor) {
                mHintTextColor = color;
                mPaint.setColor(color);
            }
        }

        Paint.FontMetricsInt fontMetrics = mPaint.getFontMetricsInt();
        int baseline = (getHeight() - fontMetrics.bottom + fontMetrics.top) / 2 - fontMetrics.top;
        canvas.drawText(mHint,0,mHint.length(),getWidth()-getPaddingRight() + getScrollX(),baseline,mPaint);
        canvas.restore();

    }
}
