package com.danny.bookone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context mContext;
    private List<String> mChapterList;

    public MyAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.mChapterList = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTvChapter.setText(mChapterList.get(position));
    }


    @Override
    public int getItemCount() {
        return mChapterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTvChapter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvChapter = itemView.findViewById(R.id.tv_chapter);
        }
    }
}
