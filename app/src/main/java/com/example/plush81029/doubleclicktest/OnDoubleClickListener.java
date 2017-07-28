package com.example.plush81029.doubleclicktest;

import android.util.Log;
import android.view.View;

/**
 * Created by PLUSH81029 on 2017/7/28.
 */

public abstract class OnDoubleClickListener implements View.OnClickListener {
    // 两次点击按钮之间的点击间隔不能少于1000毫秒
    private static final int DOUBLE_CLICK_TIME = 1000;

    //选择1:  快速点击两个按钮,第二个不响应
    private static long lastClickTime;
    //选择2: 快速点击两个按钮,第二个响应
//    private long lastClickTime;

    public abstract void onDoubleClick(View v);

    @Override
    public void onClick(View view) {
        long curClickTime = System.currentTimeMillis();
//        Log.i("LHD", "lastime = " + lastClickTime + "  curTime = " + curClickTime
//                + "  " + ((curClickTime - lastClickTime) >= DOUBLE_CLICK_TIME));
        if ((curClickTime - lastClickTime) >= DOUBLE_CLICK_TIME) {
            //单击后重置lastClickTime
            lastClickTime = curClickTime;
            onDoubleClick(view);
        }
    }
}
