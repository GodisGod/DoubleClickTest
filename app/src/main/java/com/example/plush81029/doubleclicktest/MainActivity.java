package com.example.plush81029.doubleclicktest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private HelpUtil mHelpUtil;
    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = this;

        //方案1 Activity整体布局防止双击
//        findViewById(R.id.btn_one).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(ctx, "one one one", Toast.LENGTH_SHORT).show();
//            }
//        });


        //方案2  使用工具类防止双击 问题:快速点击两个控件，第二个控件不会响应
        mHelpUtil = new HelpUtil();
        findViewById(R.id.btn_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mHelpUtil.isOnDoubleClick(1000)) {
                    return;
                }
                Log.i("LHD", "弹出吐司111");
                Toast.makeText(ctx, "one one one", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btn_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mHelpUtil.isOnDoubleClick(1000)) {
                    return;
                }
                Log.i("LHD", "弹出吐司222");
                Toast.makeText(ctx, "two two two", Toast.LENGTH_SHORT).show();
            }
        });

        //方案3: 重写OnClickListener
        findViewById(R.id.btn_three).setOnClickListener(new OnDoubleClickListener() {
            @Override
            public void onDoubleClick(View v) {
                Log.i("LHD", "弹出吐司333");
                Toast.makeText(ctx, "three three three", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.btn_four).setOnClickListener(new OnDoubleClickListener() {
            @Override
            public void onDoubleClick(View v) {
                Log.i("LHD", "弹出吐司444");
                Toast.makeText(ctx, "four four four", Toast.LENGTH_SHORT).show();
            }
        });

    }


    //防止双击多次调用方案1
//    private long lastClickTime;
//    /**
//     * 防止重复点击
//     *
//     * @return
//     */
//    private boolean isFastDoubleClick() {
//        long time = System.currentTimeMillis();
//        long timeD = time - lastClickTime;
//        if (0 < timeD && timeD < 500) {
//            return true;
//        }
//        lastClickTime = time;
//        return false;
//    }
//
//    /**
//     * 判断触摸时间派发间隔
//     */
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
//            if (isFastDoubleClick()) {
//                return true;
//            }
//        }
//        return super.dispatchTouchEvent(ev);
//    }

}
