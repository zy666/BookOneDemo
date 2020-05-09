package com.danny.bookone.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.danny.bookone.Base.StringAdapter;
import com.danny.bookone.R;
import com.danny.bookone.aac.AacActivity;
import com.danny.bookone.databinding.FragmentTest3Binding;
import com.danny.bookone.highLight.HighLightActivity;
import com.danny.bookone.img.GlideImgActivity;
import com.danny.bookone.one.HandlerActivity;
import com.danny.bookone.one.HeroActivity;
import com.danny.bookone.other.CompanyActivity;
import com.danny.bookone.other.DataActivity;
import com.danny.bookone.suanfa.Calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 力扣题库
 */
public class Test3Fragment extends BaseFragment {
    private FragmentTest3Binding test3Binding;
    private List<String> calculateList = new ArrayList<>();
    private int[] maoPaoArray = {4, 7, 6, 5, 3, 2, 8, 1};

    public Test3Fragment() {
        // Required empty public constructor
    }

    public static Test3Fragment newInstance() {
        Test3Fragment fragment = new Test3Fragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        test3Binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test3, container, false);
        return test3Binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        StringAdapter adapter = new StringAdapter(calculateList);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        fanZhuan(calculateList.get(position));
                        break;
                    case 1:
//                        Calculate.maoPao(maoPaoArray, position, getActivity());
                        Calculate.maoPaoYouhua(maoPaoArray, position, getActivity());
//                        Calculate.finalMaoPao(maoPaoArray, position, getActivity());
                        break;
                    case 2:
                        Calculate.selectSort(maoPaoArray, getActivity());
                        break;
                    case 3:
                        Calculate.fastSort(maoPaoArray, 0, maoPaoArray.length - 1, getActivity());
                        break;
                    case 4:
                        Calculate.insertSort(maoPaoArray, getActivity());
                        break;
                    case 6:
                        Calculate.halfSearch(maoPaoArray, getActivity());
                        break;
                    case 7:
                        Calculate.treeSearch(maoPaoArray, getActivity());
                        break;
                    case 8:
                        Calculate.hashSearch(maoPaoArray, getActivity());
                        break;
                }
            }
        });
        test3Binding.recyclerCalculate.setLayoutManager(new LinearLayoutManager(getActivity()));
        test3Binding.recyclerCalculate.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        test3Binding.recyclerCalculate.setAdapter(adapter);
    }


    public void fanZhuan(String s) {
        String[] newStr = s.trim().split(" ");
        StringBuffer StringBuffer = new StringBuffer();
        for (int i = newStr.length - 1; i > 0; i--) {
            if (!newStr[i].isEmpty()) {
                StringBuffer.append(newStr[i]).append(" ");
            }
        }
//        Log.e("fanzhuan", StringBuffer.toString().substring(0, StringBuffer.length() - 1 > 0 ? StringBuffer.length() - 1 : 0));
        Toast.makeText(getActivity(), StringBuffer.toString().substring(0, StringBuffer.length() - 1), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onLazyData() {
        Log.e("Test3-->", "onLazyData");
        calculateList.add(" a good   example ");
        calculateList.add("冒泡排序：" + Arrays.toString(maoPaoArray));
        calculateList.add("选择排序：" + Arrays.toString(maoPaoArray));
        calculateList.add("快速排序：" + Arrays.toString(maoPaoArray));
        calculateList.add("插入排序：" + Arrays.toString(maoPaoArray));
        calculateList.add("====================================");
        calculateList.add("折半查找：" + Arrays.toString(maoPaoArray));
        calculateList.add("树查找：" + Arrays.toString(maoPaoArray));
        calculateList.add("hash查找：" + Arrays.toString(maoPaoArray));
    }
}
