package com.danny.bookone.img;

import android.content.Context;
import android.widget.ImageView;

import java.lang.ref.SoftReference;

public class BitmapRequest {
    //图片请求地址
    private String mUrl;
    //图片加载控件
    private SoftReference<ImageView> mImageView;
    //占位图片
    private int resId;
    //回调对象
    private RequestListener requestListener;
    //图片标识
    private String urlMd5;

    private Context mContext;

    public BitmapRequest(Context context) {
        mContext = context;
    }

    public BitmapRequest load(String url) {
        mUrl = url;
        return this;
    }

    public BitmapRequest listener(RequestListener listener) {
        this.requestListener = listener;
        return this;
    }

    public ImageView getImageView() {
        return mImageView.get();
    }

    public int getResId() {
        return resId;
    }

    public RequestListener getRequestListener() {
        return requestListener;
    }

    public String getUrlMd5() {
        return urlMd5;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void into(ImageView imageView) {
        imageView.setTag(this.urlMd5);
        this.mImageView = new SoftReference<>(imageView);
    }
}
