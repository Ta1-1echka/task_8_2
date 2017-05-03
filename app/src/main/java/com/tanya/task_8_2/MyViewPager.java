package com.tanya.task_8_2;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ta1-1 on 02.05.2017.
 */

public class MyViewPager extends ViewPager {

    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    static int p = 0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

//        int position = getCurrentItem();
//        if(p==5)
//            p = 0;
////        if(position>=getChildCount()-1) {
////            position = getChildCount() % position - 1;
////            System.out.println(getChildCount() % position);
////        }
//
////        if (position == 5)
////            position = getChildCount() / position;
////        position++;
//        System.out.println(position);
//        View child = getChildAt(p);
//        System.out.println("position=" + position + "count=" + getChildCount());
////        ViewGroup.LayoutParams params = child.getLayoutParams();
////        params.width = 10;
////        child.setLayoutParams(params);
//        int width = getMeasuredWidth(), height = getMeasuredHeight();
//
//        // Use the previously measured width but simplify the calculations
//        widthMeasureSpec = MeasureSpec.makeMeasureSpec(width , MeasureSpec.AT_MOST);
//
//            /* If the pager actually has any children, take the first child's
//             * height and call that our own */
//        if (getChildCount() > 0) {
//
//                /* The child was previously measured with exactly the full height.
//                 * Allow it to wrap this time around. */
//            child.measure(widthMeasureSpec,
//                    MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
//
//            height = child.getMeasuredHeight();
//        }
//
//        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
//        p++;
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(true, l, t, r, b);
        int position = getCurrentItem();
        View child = getChildAt(position + 1);
        View view = getChildAt(getCurrentItem());
        view.setTranslationZ(view.getWidth() );
        view = getChildAt(getCurrentItem()+1);
        view.setTranslationZ(0);
    }


}
