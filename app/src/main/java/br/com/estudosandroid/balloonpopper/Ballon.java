package br.com.estudosandroid.balloonpopper;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import br.com.estudosandroid.balloonpopper.utils.PixelHelper;

/**
 * Created by Edmilson on 18/12/2016.
 */

public class Ballon extends ImageView implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
    private ValueAnimator valueAnimator;

    public Ballon(Context context) {
        super(context);
    }

    public Ballon(Context context, int color, int rawHeight) {
        super(context);

        this.setImageResource(R.drawable.balloon);
        this.setColorFilter(color);

        int rawWidth = rawHeight / 2;
        int dpHeight = PixelHelper.pixelsToDp(rawHeight, context);
        int dpWidth = PixelHelper.pixelsToDp(rawWidth, context);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(dpWidth, dpHeight);
        setLayoutParams(params);
    }

    public void releaseBallon(int screenHeigth, int duration) {
        valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(duration);
        valueAnimator.setFloatValues(screenHeigth, 0f);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setTarget(this);
        valueAnimator.addListener(this);
        valueAnimator.addUpdateListener(this);
        valueAnimator.start();
    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {

    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        setY((float) valueAnimator.getAnimatedValue());
    }
}
