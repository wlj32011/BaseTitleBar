package com.iiseeuu.baseactivity;

import android.app.Activity;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.iiseeuu.rootview.RootLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RootLayout.getInstance(this).setTitleBar("仅标题");

        findViewById(R.id.only_title).setOnClickListener(this);
        findViewById(R.id.title_with_back).setOnClickListener(this);
        findViewById(R.id.left_and_right_img).setOnClickListener(this);
        findViewById(R.id.only_right_img).setOnClickListener(this);
        findViewById(R.id.right_and_left_text).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.only_title:
                RootLayout.getInstance(this).setTitleBar("仅标题");
                break;
            case R.id.title_with_back:
                RootLayout.getInstance(this).setTitleBarWithBack("标题加返回");
                RootLayout.getInstance(this).setLeftOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            case R.id.left_and_right_img:
                RootLayout.getInstance(this).setTitleBar("左右都图标",android.R.drawable.btn_plus,android.R.drawable.btn_minus);
                RootLayout.getInstance(this).setLeftOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                RootLayout.getInstance(this).setRightOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                break;
            case R.id.only_right_img:
                RootLayout.getInstance(this).setTitleBar("右边图标",android.R.drawable.btn_minus);
                RootLayout.getInstance(this).setRightOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                break;
            case R.id.right_and_left_text:
                RootLayout.getInstance(this).setTitleBar("左右都是文字","取消","确定");
                RootLayout.getInstance(this).setRightOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                RootLayout.getInstance(this).setLeftOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                break;
        }
    }


}
