package com.danny.bookone.one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.danny.bookone.R;
import com.danny.bookone.databinding.ActivityChapterSevenBinding;

public class ChapterSevenActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityChapterSevenBinding sevenBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sevenBinding = DataBindingUtil.setContentView(this, R.layout.activity_chapter_seven);

        sevenBinding.btnAlpha.setOnClickListener(this);
        sevenBinding.btnRotate.setOnClickListener(this);
        sevenBinding.btnScale.setOnClickListener(this);
        sevenBinding.btnTranslate.setOnClickListener(this);
        sevenBinding.btnAll.setOnClickListener(this);
        sevenBinding.btnObj.setOnClickListener(this);
        sevenBinding.btnObj.setAllCaps(false);
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, ChapterSevenActivity.class);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        //渐变
        AlphaAnimation aa = new AlphaAnimation(0, 1);
        aa.setDuration(1000);

        //旋转
        RotateAnimation ra = new RotateAnimation(0, 360,
                RotateAnimation.RELATIVE_TO_SELF, 1f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        ra.setDuration(1000);
        //缩放
        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1);
        sa.setDuration(2000);
        //平移
        TranslateAnimation ta = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_SELF, 0f, TranslateAnimation.RELATIVE_TO_SELF, 0f,
                TranslateAnimation.RELATIVE_TO_SELF, 0f, TranslateAnimation.RELATIVE_TO_SELF, 1f
        );
        ta.setDuration(2000);

        //动画集合
        AnimationSet as = new AnimationSet(true);
        as.setDuration(2000);
        as.addAnimation(aa);
        as.addAnimation(ra);
        as.addAnimation(sa);
        as.addAnimation(ta);

        switch (id) {
            case R.id.btn_alpha://渐变
                sevenBinding.ivDemo.startAnimation(aa);
                break;
            case R.id.btn_rotate://旋转
                sevenBinding.ivDemo.startAnimation(ra);
                break;
            case R.id.btn_scale://缩放
                sevenBinding.ivDemo.startAnimation(sa);
                break;
            case R.id.btn_translate://平移
                sevenBinding.ivDemo.startAnimation(ta);
                break;
            case R.id.btn_all://动画集合
                sevenBinding.ivDemo.startAnimation(as);
                break;
            case R.id.btn_obj://动画集合
                ObjectAnimator oa = ObjectAnimator.ofFloat(sevenBinding.ivDemo, "translationY", 400);
                oa.setDuration(2000);
                oa.start();
                break;
        }
    }
}
