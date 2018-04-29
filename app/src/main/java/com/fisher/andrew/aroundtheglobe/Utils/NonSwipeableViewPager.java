package com.fisher.andrew.aroundtheglobe.Utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;

/**
 * Created by andrewfisher on 4/28/18.
 */

public class NonSwipeableViewPager extends ViewPager {
    public NonSwipeableViewPager(Context context) {
        super(context);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

}
