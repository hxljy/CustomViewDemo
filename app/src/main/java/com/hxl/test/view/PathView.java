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

        // 使用 path 对图形进行描述（这段描述代码不必看懂）
        path.addArc(200, 200, 400, 400, -225, 225);
        path.arcTo(400, 200, 600, 400, -180, 225, false);
        path.lineTo(400, 542);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setAntiAlias(true);
//        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, paint); // 绘制出 path 描述的图形（心形），大功告成


    }
}
