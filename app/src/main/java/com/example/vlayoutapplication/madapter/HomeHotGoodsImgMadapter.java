package com.example.vlayoutapplication.madapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.example.vlayoutapplication.R;
import com.example.vlayoutapplication.bean.HomeBannerBean;

import java.util.ArrayList;

public class HomeHotGoodsImgMadapter extends DelegateAdapter.Adapter {
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
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.text_hotgoods_weight.setText(hotGoodsListBean.getName());
        viewHolder.text_hotgoods_trait.setText(hotGoodsListBean.getGoods_brief());
        viewHolder.text_hotgoods_price.setText("￥ "+hotGoodsListBean.getRetail_price());
        Glide.with(context).load(hotGoodsListBean.getList_pic_url()).into(viewHolder.img_hotgoods);
    }

    @Override
    public int getItemCount() {
        if (hotgoodslist.size()>0){
            return hotgoodslist.size();
        }else {
            return 0;
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_hotgoods;
        TextView text_hotgoods_weight;
        TextView text_hotgoods_trait;
        TextView text_hotgoods_price;

        public ViewHolder(View inflate) {
            super(inflate);
            img_hotgoods = inflate.findViewById(R.id.iv_hotgoods);
            text_hotgoods_weight = inflate.findViewById(R.id.tv_hotgoods_weight);
            text_hotgoods_trait = inflate.findViewById(R.id.tv_hotgoods_trait);
            text_hotgoods_price = inflate.findViewById(R.id.tv_hotgoods_price);
        }
    }
}
