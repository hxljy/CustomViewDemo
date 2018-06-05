package com.hxl.test.view;/**
 * Created by Administrator on 2018/6/1.
 */

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.hxl.test.R;

/**
 * created by hxl on 2018/6/1
 */
public class CustomView1 extends View {
    Paint paint;

    public CustomView1(Context context) {
        super(context);
    }

    public CustomView1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO Auto-generated method stub
        // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, 3000);//动态设置宽高
    }

    /**
     * Paint.setStyle(Style style) 设置绘制模式
     * Paint.setColor(int color) 设置颜色
     * Paint.setStrokeWidth(float width) 设置线条宽度
     * Paint.setTextSize(float textSize) 设置文字大小
     * Paint.setAntiAlias(boolean aa) 设置抗锯齿开关
     */
    /**
     * Paint.Style.FILL：填充内部
     * Paint.Style.FILL_AND_STROKE  ：填充内部和描边
     * Paint.Style.STROKE  ：描边
     */
    /**
     * Paint.Cap：设置画线的结尾处的形状，有三个选择BUTT、SQUARE、ROUND，
     * BUTT：不在结尾处添加任何一笔，SQUARE：在结尾处加一个方形，ROUND：在结尾处追加一个半圆
     */
    /**
     * Paint.join：设置结合处的形状，有三个选择：BEVEL、MITER、ROUND，分别表示直线、直角、圆角
     */

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //颜色填充
//        canvas.drawColor(Color.BLACK);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        //圆
        canvas.drawCircle(300, 300, 200, paint);

        //画矩形
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeJoin(Paint.Join.BEVEL);
        canvas.drawRect(100, 550, 600, 800, paint);
        paint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawRect(100, 900, 600, 1100, paint);
        paint.setStrokeJoin(Paint.Join.MITER);
        canvas.drawRect(100, 1200, 600, 1300, paint);

        //画点
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(30);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(100, 1380, paint);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(200, 1380, paint);
        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(300, 1380, paint);

        //画椭圆
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            paint.setColor(Color.DKGRAY);
            paint.setStrokeWidth(10);
            canvas.drawOval(100, 1450, 300, 1550, paint);
        }

        //画圆角矩形(rx 和 ry 是圆角的横向半径和纵向半径)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            paint.setColor(Color.GREEN);
            canvas.drawRoundRect(100, 1600, 500, 1900, 60, 60, paint);
        }

        //画弧形 和扇形
        /**
         * drawArc() 是使用一个椭圆来描述弧形的。left, top, right, bottom 描述的是这个弧形所在的椭圆；
         * startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度）
         * ，sweepAngle 是弧形划过的角度；useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形。
         * */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawArc(100, 1950, 300, 2050, 90, 270, true, paint);
            canvas.drawArc(350, 1950, 550, 2050, 90, 270, false, paint);
            paint.setStyle(Paint.Style.FILL); // 填充模式
            canvas.drawArc(100, 2100, 300, 2200, 90, 270, true, paint);
        }


        //画bitmap
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher), 100, 2250, paint);


    }
}
