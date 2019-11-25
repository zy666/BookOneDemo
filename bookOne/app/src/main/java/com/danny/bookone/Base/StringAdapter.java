package com.danny.bookone.Base;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.danny.bookone.R;

import java.util.List;

public class StringAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public StringAdapter(@Nullable List<String> data) {
        super(R.layout.item_main, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_chapter, item);
        helper.addOnClickListener(R.id.tv_chapter);
    }
}
