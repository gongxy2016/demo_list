package com.demo.gong.mydemoapplication.DemoCoordinatorLayout;


import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;


/**
 * Created by TS_02 on 2018/11/30.
 */

public class FollowBehavior extends CoordinatorLayout.Behavior{
    public FollowBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof Button;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        child.setX(dependency.getX()+150);
        child.setY(dependency.getY()+150);
        return true;
    }
}
