package com.join.server;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Lenovo on 2017/11/23.
 */

public class MyServer extends Service {
    private String TAG = "MyServer";
    private MyBinder myBinder = new MyBinder();
    private long add;

    @Override
    public void onCreate() {
        super.onCreate();
        MyThread myThread = new MyThread();
        myThread.start();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void send(int data) {
        add = add + data;
    }

    public long receive() {

        return add;
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            while (true) {
                long receive = receive();
                Log.e(TAG, "recyiver" + receive);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class MyThread1  extends Thread {
        @Override
        public void run() {
            super.run();
            while (true) {
                long receive = receive();
                Log.e(TAG, "recyiver" + receive);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public class MyBinder extends Binder {
        public MyServer getMyServer() {
            return MyServer.this;
        }
    }
}
