package com.hxl.test.view;/**
 * Created by Administrator on 2018/6/5.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * created by hxl on 2018/6/5
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class PathView extends View {

    Paint paint = new Paint();
    Path path = new Path(); // 初始化 Path 对象
    Path path1 = new Path(); // 贝塞尔曲线

    public PathView(Context context) {
        super(context);
    }

    public PathView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {

        // 使用 path 描述心形
        path.addArc(150, 150, 350, 350, -225, 225);//两个扇形
        path.arcTo(350, 150, 550, 350, -180, 225, false);
        path.lineTo(350, 492);
        path.close();

        //描述五角星
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(100, 800);
        path.lineTo(600, 800);
        path.lineTo(170, 1130);
        path.lineTo(350, 620);
        path.lineTo(490, 1130);
        path.close();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, paint); // 绘制出 path 描述的图形（心形），大功告成


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO Auto-generated method stub
        // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, 3000);//动态设置宽高
    }
}
