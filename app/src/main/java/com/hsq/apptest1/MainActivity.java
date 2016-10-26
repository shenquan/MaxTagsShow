package com.hsq.apptest1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activity_main);
        for (int i = 0; i < 3; i++) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.frame_layout, null);
            TextView textView = (TextView) frameLayout.findViewById(R.id.tags);
            if (i == 0) {
                textView.setText("11111房间诶看见");
            } else if (i == 1) {
                textView.setText("2222哦飞机刚卡了关雎尔空间高科技几个了飞飞浪费了就看见就够了关雎尔空间高科技几个了飞飞浪费了就看见就够了");
            } else {
                textView.setText("关雎尔空间高科技几个了飞飞浪费了就看见就够了");
            }
            frameLayout.setTag("frameLayout" + i);
            frameLayout.setVisibility(View.INVISIBLE);
            linearLayout.addView(frameLayout);
        }

        linearLayout.post(new Runnable() {
            @Override
            public void run() {
                int temp = 0;
                for (int i = 0; i < 3; i++) {
                    FrameLayout frameLayout = (FrameLayout) linearLayout.findViewWithTag("frameLayout" + i);
                    TextView textView = (TextView) frameLayout.findViewById(R.id.tags);
                    if (textView.getLineCount() == 1) {
                        frameLayout.setVisibility(View.VISIBLE);
                    } else if (textView.getLineCount() >= 2) {
                        frameLayout.setVisibility(View.GONE);
                        temp = i;
                        break;
                    }
                }
                for (int i = temp + 1; i < 3; i++) {
                    FrameLayout frameLayout = (FrameLayout) linearLayout.findViewWithTag("frameLayout" + i);
                    TextView textView = (TextView) frameLayout.findViewById(R.id.tags);
                    frameLayout.setVisibility(View.GONE);
                }
            }
        });


    }
}
