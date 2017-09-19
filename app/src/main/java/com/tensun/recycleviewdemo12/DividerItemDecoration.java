package com.tensun.recycleviewdemo12;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Administrator on 2017/9/19.
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private Paint mPaint;

    /** 在构造函数里进行绘制的初始化, 如画笔属性设置等 */
    public DividerItemDecoration(Context context) {

        /** 設置畫筆, 並設置成白色+半透明 */
        mPaint = new Paint();
        mPaint.setColor(0x99ffffff);
    }

    /** 重写onDrawOver(), 並在RecyclerView上 繪出想要的圖形 */
    @Override
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(canvas, parent, state);

        canvas.drawRect(0, 74, 56, 485, mPaint);                                 // 通过Canvas绘制 第一個圖形
        canvas.drawRect(parent.getWidth()-55, 75, parent.getWidth(), 484, mPaint);     // 通过Canvas绘制 第二個圖形
    }
}
