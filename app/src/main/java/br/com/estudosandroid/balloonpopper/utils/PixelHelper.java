package br.com.estudosandroid.balloonpopper.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by Edmilson on 18/12/2016.
 */

public class PixelHelper {

    public static int pixelsToDp(int px, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px,
                context.getResources().getDisplayMetrics());
    }
}
