package com.example.vlayoutapplication.homemadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.vlayoutapplication.R;
import com.example.vlayoutapplication.bean.HomeBannerBean;

import java.util.ArrayList;

public class HomeHouseRecyclerMadapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<HomeBannerBean.DataBean.CategoryListBean.GoodsListBean> houselist;

    public HomeHouseRecyclerMadapter(Context context, ArrayList<HomeBannerBean.DataBean.CategoryListBean.GoodsListBean> houselist) {
        this.context = context;
        this.houselist = houselist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_house, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBannerBean.DataBean.CategoryListBean.GoodsListBean goodsListBean = houselist.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        Glide.with(context).load(goodsListBean.getList_pic_url()).into(viewHolder.img_house);
        viewHolder.text_name.setText(goodsListBean.getName());
        viewHolder.text_price.setText("￥ "+goodsListBean.getRetail_price());
    }

    @Override
    public int getItemCount() {
        if(houselist.size()>0){
            return houselist.size();
        }else{
            return 0;
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_house;
        TextView text_name;
        TextView text_price;

        public ViewHolder(View inflate) {
            super(inflate);
            img_house=inflate.findViewById(R.id.iv_house);
            text_name=inflate.findViewById(R.id.tv_house_name);
            text_price=inflate.findViewById(R.id.tv_house_price);
        }
    }
}
