package com.danny.bookone.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.greenrobot.eventbus.EventBus;

public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewInitiated = true;
        lazyData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            lazyData();
        }
    }

    private boolean isViewInitiated;//fragment的view加载完毕的标记
    private boolean isLazyInitiated;//是否懒加载

    private void lazyData() {
        if (getUserVisibleHint() && isViewInitiated && !isLazyInitiated) {
            onLazyData();
            isLazyInitiated = true;
        }
//        else {//如果不需要懒加载，注释打开，每次可见都会刷刷新页面
//            isLazyInitiated = false;
//        }
    }

    protected abstract void onLazyData();
}
