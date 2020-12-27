package com.example.vlayoutapplication.madapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.example.vlayoutapplication.R;
import com.example.vlayoutapplication.bean.HomeBannerBean;

import java.util.ArrayList;

public class HomeHotGoodsImgMadapter  extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<HomeBannerBean.DataBean.HotGoodsListBean> hotgoodslist;
    private LayoutHelper layoutHelper;

    public HomeHotGoodsImgMadapter(Context context, ArrayList<HomeBannerBean.DataBean.HotGoodsListBean> hotgoodslist, LayoutHelper layoutHelper) {
        this.context = context;
        this.hotgoodslist = hotgoodslist;
        this.layoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_hotgoods_img, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBannerBean.DataBean.HotGoodsListBean hotGoodsListBean = hotgoodslist.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.text_good_weight.setText(hotGoodsListBean.getName());
        viewHolder.text_good_price.setText("￥ "+hotGoodsListBean.getRetail_price());
        Glide.with(context).load(hotGoodsListBean.getList_pic_url()).into(viewHolder.img_good);
    }

    @Override
    public int getItemCount() {
        return hotgoodslist.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_good;
        TextView text_good_weight;
        TextView text_good_price;

        public ViewHolder(View inflate) {
            super(inflate);
            img_good = inflate.findViewById(R.id.iv_good);
            text_good_weight = inflate.findViewById(R.id.tv_good_weight);
            text_good_price = inflate.findViewById(R.id.tv_good_price);
        }
    }
}
