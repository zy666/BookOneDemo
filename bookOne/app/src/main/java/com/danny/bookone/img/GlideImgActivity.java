package com.danny.bookone.img;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.danny.bookone.R;
import com.danny.bookone.databinding.ActivityGlideImgBinding;
import com.danny.bookone.other.CompanyActivity;

public class GlideImgActivity extends AppCompatActivity {
    private ActivityGlideImgBinding glideImgBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glideImgBinding = DataBindingUtil.setContentView(this, R.layout.activity_glide_img);
        glideImgBinding.tvOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                single();
            }
        });
        glideImgBinding.tvMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                more();
            }
        });
    }

    String imgUrl = "https://ww1.sinaimg.cn/mw690/8f0b8983gy1gcum0n2g5tj21yu2jou0z.jpg";

    private void single() {
        ImageView img = new ImageView(this);
        img.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        glideImgBinding.imgList.addView(img);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.mipmap.ic_launcher);           //加载占位符
        requestOptions.error(R.mipmap.ic_launcher);                 //异常占位符
        requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE);   //禁用缓存，方便占位符展示
        requestOptions.override(100,100);                           //加载指定图片大小
        Glide.with(this)
                .load(imgUrl)
                .apply(requestOptions)
                .into(img);
//        NeGlide.with(this)
//                .load(imgUrl)
//                .listener(new RequestListener() {
//                    @Override
//                    public boolean onSuccess(Bitmap bitmap) {
//                        Toast.makeText(GlideImgActivity.this, "加载成功", Toast.LENGTH_SHORT).show();
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onFailure() {
//                        Toast.makeText(GlideImgActivity.this, "失败", Toast.LENGTH_SHORT).show();
//                        return false;
//                    }
//                }).into(img);

    }

    private void more() {
        for (int i = 0; i < 5; i++) {
            ImageView img = new ImageView(this);
            img.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            glideImgBinding.imgList.addView(img);
            String url = "";
            switch (i) {
                case 0:
                    url = "https://ww1.sinaimg.cn/mw690/8f0b8983gy1gcum0n2g5tj21yu2jou0z.jpg";
                    break;
                case 1:
                    url = "https://ww1.sinaimg.cn/mw690/8f0b8983gy1gcum0n2g5tj21yu2jou0z.jpg";

                    break;
                case 2:
                    url = "https://ww1.sinaimg.cn/mw690/8f0b8983gy1gcum0n2g5tj21yu2jou0z.jpg";

                    break;
                case 3:
                    url = "https://ww1.sinaimg.cn/mw690/8f0b8983gy1gcum0n2g5tj21yu2jou0z.jpg";

                    break;
                case 4:
                    url = "https://ww1.sinaimg.cn/mw690/8f0b8983gy1gcum0n2g5tj21yu2jou0z.jpg";

                    break;
            }
            NeGlide.with(this)
                    .load(url)
                    .listener(new RequestListener() {
                        @Override
                        public boolean onSuccess(Bitmap bitmap) {
                            Toast.makeText(GlideImgActivity.this, "加载成功", Toast.LENGTH_SHORT).show();
                            return false;
                        }

                        @Override
                        public boolean onFailure() {
                            Toast.makeText(GlideImgActivity.this, "失败", Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    }).into(img);

        }

    }

    public static Intent createIntent(Context context) {
        return new Intent(context, GlideImgActivity.class);
    }
}
