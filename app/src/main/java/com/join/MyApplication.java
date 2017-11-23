package com.join;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

import com.join.server.MyServer;

/**
 * Created by Lenovo on 2017/11/23.
 */

public class MyApplication extends Application implements ServiceConnection {
    private static Context myContext;
    private static MyServer service;
    private static MyHandler myHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        myContext = getApplicationContext();
        Intent intent = new Intent(this, MyServer.class);
        bindService(intent, this, Context.BIND_AUTO_CREATE);
        myHandler = new MyHandler();
    }

    public static Context getContext() {
        return myContext;
    }

    public static MyHandler getMyHandler() {
        return myHandler;
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        MyServer.MyBinder myBinder = (MyServer.MyBinder) iBinder;
        service = myBinder.getMyServer();

    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }

   public class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    service.send(100);
                    break;
                case 2:
                    service.send(200);
                    break;
                case 3:
                    service.send(3000);
                    break;
            }
        }
    }
}
