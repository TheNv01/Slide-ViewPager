package com.example.slideview;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;

public class UltraDepthScaleTransformer implements ViewPager2.PageTransformer {
    private static final float MIN_SCALE = 0.9f;
    private static final float MAX_ROTATION = 10;

    @Override
    public void transformPage(View view, float position) {
        final float scale = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
        final float rotation = MAX_ROTATION * Math.abs(position);

        float r = 1 - Math.abs(position);


        if (position <= 0f) {
            view.setTranslationX(view.getWidth() * -position * 0.10f);
            view.setPivotY(0.5f * view.getHeight());
            view.setPivotX(0.2f * view.getWidth());
            view.setScaleX(scale);
            view.setScaleY(scale);
            view.setRotationY(rotation);
        } else if (position <= 2f) {
            view.setTranslationX(view.getWidth() * -position * 0.10f);
            view.setPivotY(0.5f * view.getHeight());
            view.setPivotX(0.8f * view.getWidth());
            view.setScaleX(scale);
            view.setScaleY(scale);
            view.setRotationY(-rotation);
        }
    }
}
