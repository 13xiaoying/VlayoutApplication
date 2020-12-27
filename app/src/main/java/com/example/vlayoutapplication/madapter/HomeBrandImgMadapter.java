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
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.vlayoutapplication.R;
import com.example.vlayoutapplication.bean.HomeBannerBean;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HomeBrandImgMadapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<HomeBannerBean.DataBean.BrandListBean> brandlist;
    private LayoutHelper layoutHelper;

    public HomeBrandImgMadapter(Context context, ArrayList<HomeBannerBean.DataBean.BrandListBean> brandlist, LayoutHelper layoutHelper) {
        this.context = context;
        this.brandlist = brandlist;
        this.layoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_brand_img, parent, false);
        return new ImgViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBannerBean.DataBean.BrandListBean brandListBean = brandlist.get(position);
        ImgViewHolder imgViewHolder = (ImgViewHolder) holder;
        imgViewHolder.text_manu.setText(brandListBean.getName());
        imgViewHolder.text_price.setText(brandListBean.getFloor_price()+"元起");
        Glide.with(context).load(brandListBean.getNew_pic_url()).into(imgViewHolder.img);
    }

    @Override
    public int getItemCount() {
        return brandlist.size();
    }

    private class ImgViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView text_manu;
        TextView text_price;
        public ImgViewHolder(View inflate) {
            super(inflate);
            img = inflate.findViewById(R.id.brand_img);
            text_manu = inflate.findViewById(R.id.brand_manu);
            text_price = inflate.findViewById(R.id.brand_price);
        }
    }

}
