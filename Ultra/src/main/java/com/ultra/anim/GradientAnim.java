package com.ultra.anim;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;

public class GradientAnim {
    private int alpha;
    private View view;
    private int resource;
    private int duration = 4000;
    private AnimationDrawable frameAnimation;

    public GradientAnim setTransitionDuration(int time) {
        this.duration = time;
        return this;
    }

    public GradientAnim onView(View view) {
        this.view = view;
        return this;
    }

    public GradientAnim start() {
        if (view != null) {
            view.setBackgroundResource(resource);
            frameAnimation = (AnimationDrawable) view.getBackground();
        }
        frameAnimation.setExitFadeDuration(duration);
        frameAnimation.setEnterFadeDuration(duration);
        frameAnimation.start();
        return this;
    }

    public GradientAnim setBackgroundResource(int resource) {
        this.resource = resource;
        return this;
    }

    public GradientAnim setAlpha(int alpha) {
        this.alpha = alpha;
        frameAnimation.setAlpha(this.alpha);
        return this;
    }
}