package com.danny.bookone.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danny.bookone.R;
import com.danny.bookone.databinding.FragmentThirdFrameBinding;
import com.danny.bookone.event.StringEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFrameFragment extends BaseFragment implements View.OnClickListener {
    private FragmentThirdFrameBinding thirdFrameBinding;

    public ThirdFrameFragment() {
        // Required empty public constructor
    }

    public static ThirdFrameFragment newInstance() {
        ThirdFrameFragment fragment = new ThirdFrameFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        thirdFrameBinding.btnSendEvent.setOnClickListener(this);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        thirdFrameBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_third_frame, container, false);
        return thirdFrameBinding.getRoot();
    }


    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true, priority = 100)
    public void onEvent(StringEvent name) {
        thirdFrameBinding.tvShow.setText(name.getMessage());
    }

    @Override
    protected void onLazyData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send_event:
                Log.e("aa", "bb");
                EventBus.getDefault().post(new StringEvent("hello"));
                break;
        }
    }
}
