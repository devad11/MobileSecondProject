/*
 * Adam Devenyi
 * R00155710
 * adam.devenyi@mycit.ie
 *
 * create view
 * showing a pizza
 * */
package com.assignments.adamdevenyi.secondproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PizzaView extends View {

    public PizzaView(Context context) {
        super(context);
        init(null);
    }

    public PizzaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public PizzaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public PizzaView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init (@Nullable AttributeSet set){

    }

    @Override
    protected void onDraw(Canvas canvas){
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getResources().getColor(R.color.orange));
        canvas.drawCircle(540, 800, 450, paint);

        paint.setColor(Color.YELLOW);
        canvas.drawCircle(540, 800, 400, paint);

        paint.setColor(Color.RED);
        canvas.drawCircle(400, 700, 40, paint);
        canvas.drawCircle(250, 850, 40, paint);
        canvas.drawCircle(730, 550, 40, paint);
        canvas.drawCircle(700, 1000, 40, paint);
        canvas.drawCircle(300, 1000, 40, paint);
        canvas.drawCircle(800, 950, 40, paint);
        canvas.drawCircle(400, 550, 40, paint);
        canvas.drawCircle(450, 950, 40, paint);
        canvas.drawCircle(650, 800, 40, paint);
        canvas.drawCircle(550, 1100, 40, paint);
        canvas.drawCircle(560, 500, 40, paint);
        canvas.drawCircle(770, 750, 40, paint);

        paint.setColor(getResources().getColor(R.color.orange));
        paint.setStrokeWidth(10);
        canvas.drawLine(140, 820, 950, 820, paint);
        canvas.drawLine(545, 350, 545, 1200, paint);
        canvas.drawLine(262, 505, 828, 1145, paint);
        canvas.drawLine(828, 505, 262, 1145, paint);

    }
}