package com.danny.bookone.img;

import android.graphics.Bitmap;

public interface RequestListener {
    boolean onSuccess(Bitmap bitmap);

    boolean onFailure();
}
