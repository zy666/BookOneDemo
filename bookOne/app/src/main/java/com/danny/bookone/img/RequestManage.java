package com.danny.bookone.img;

import java.util.concurrent.LinkedBlockingQueue;

public class RequestManage {
    private static RequestManage requestManage = new RequestManage();
    private LinkedBlockingQueue<BitmapRequest> requestQueue = new LinkedBlockingQueue<>();

    private RequestManage() {
        stop();
        startAllDispatcher();
    }

    //停止所有线s程
    private void stop() {
        if (bitmapDispatchers != null && bitmapDispatchers.length != 0) {
            for (BitmapDispatcher dispatcher :
                    bitmapDispatchers) {
                if (!dispatcher.isInterrupted()) {
                    dispatcher.interrupt();
                }
            }
        }
    }

    //提示窗口开启服务
    public void startAllDispatcher() {//获取手机支持的最大线程数
        int threadCount = Runtime.getRuntime().availableProcessors();
        bitmapDispatchers = new BitmapDispatcher[threadCount];
        for (int i = 0; i < threadCount; i++) {
            BitmapDispatcher bitmapDispatcher = new BitmapDispatcher(requestQueue);
            bitmapDispatcher.start();

            //将每个dispatcher放到数组中，方便统一管理
            bitmapDispatchers[i] = bitmapDispatcher;
        }
    }


    //将图片请求，添加到队列
    public static RequestManage getInstance() {
        return requestManage;
    }

    //创建数组线程
    private BitmapDispatcher[] bitmapDispatchers;

    public void addBitMapRequest(BitmapRequest bitmapRequest) {
        if (bitmapRequest == null) {
            return;
        }

        if (!requestQueue.contains(bitmapRequest)) {
            requestQueue.add(bitmapRequest);
        }
    }

}
