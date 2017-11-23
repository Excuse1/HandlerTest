package com.join.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.join.MyApplication;
import com.join.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MyApplication.MyHandler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        myHandler = MyApplication.getMyHandler();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                myHandler.sendEmptyMessage(1);
                break;
            case R.id.button2:
                myHandler.sendEmptyMessage(2);
                break;
            case R.id.button3:
                myHandler.sendEmptyMessageDelayed(3, 1000);
                break;
        }
    }
}
