package com.example.plush81029.doubleclicktest;

import android.os.Message;
import android.util.Log;

/**
 * author: liutao
 * date: 2016/6/30.
 */
public class HelpUtil {

    //防止双击多次调用方案2
    public long time;

    public boolean isOnDoubleClick(long DoubleClickTime) {
        long currentTime = System.currentTimeMillis();
        boolean isDoubleClick = false;
        if (currentTime - time < DoubleClickTime) {
            isDoubleClick = true;
        }
        Log.i("LHD", "time = " + time + " currentTime = " + currentTime + "  isDoubleClick = " + isDoubleClick);
        time = currentTime;
        return isDoubleClick;
    }

}
