package com.danny.bookone.img;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.LinkedBlockingQueue;

public class BitmapDispatcher extends Thread {
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private LinkedBlockingQueue<BitmapRequest> mRequestQueue;

    private BitmapDispatcher(LinkedBlockingQueue requestQueue) {
        mRequestQueue = requestQueue;
    }

    @Override
    public void run() {
        super.run();
        while (!isInterrupted()) {
            //设置占位图片，加载图片，展示图片
            try {
                BitmapRequest request = mRequestQueue.take();
                //设置占位图片
                showLoadingImage(request);
                //加载图片
                Bitmap bitmap = getBitMap(request);
                setImage(request, bitmap);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private Bitmap getBitMap(BitmapRequest request) {
        Bitmap bitmap = downLoadBitmap(request.getmUrl());
        return bitmap;
    }

    private Bitmap downLoadBitmap(String uri) {
        FileOutputStream out = null;
        InputStream in = null;
        Bitmap bitmap = null;
        try {
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            in = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(in);
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return bitmap;
    }

    private void setImage(final BitmapRequest request, final Bitmap bitmap) {
        if (bitmap != null && request.getImageView() != null
                && request.getUrlMd5().equals(request.getImageView().getTag())) {
            final ImageView imageView = request.getImageView();
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    imageView.setImageBitmap(bitmap);
                    if (request.getRequestListener() != null) {
                        RequestListener listener = request.getRequestListener();
                        listener.onSuccess(bitmap);
                    }
                }
            });
        }
    }

    private void showLoadingImage(BitmapRequest br) {
        if (br.getResId() > 0 && br.getImageView() != null) {
            final int resId = br.getResId();
            final ImageView imageView = br.getImageView();
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    imageView.setImageResource(resId);
                }
            });
        }
    }
}
