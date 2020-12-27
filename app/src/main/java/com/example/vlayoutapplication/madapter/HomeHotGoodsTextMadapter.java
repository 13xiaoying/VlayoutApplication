package com.example.vlayoutapplication.madapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.vlayoutapplication.R;
import com.example.vlayoutapplication.bean.HomeBannerBean;

import java.util.ArrayList;

public class HomeHotGoodsTextMadapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<HomeBannerBean.DataBean.HotGoodsListBean> hotgoodslist;
    private String name;
    private LayoutHelper layoutHelper;

    public HomeHotGoodsTextMadapter(Context context, ArrayList<HomeBannerBean.DataBean.HotGoodsListBean> hotgoodslist, String name, LayoutHelper layoutHelper) {
        this.context = context;
        this.hotgoodslist = hotgoodslist;
        this.name = name;
        this.layoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_hotgoods_text, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //HomeBannerBean.DataBean.NewGoodsListBean newGoodsListBean = goodlist.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.text_hotgoods.setText(name);
    }

    @Override
    public int getItemCount() {
        if (hotgoodslist.size() > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_hotgoods;
        public ViewHolder(View inflate) {
            super(inflate);
            text_hotgoods = inflate.findViewById(R.id.tv_hotgoods_text);
        }
    }
}
