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

public class HomeGoodImgMadapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<HomeBannerBean.DataBean.NewGoodsListBean> goodlist;
    private LayoutHelper layoutHelper;

    public HomeGoodImgMadapter(Context context, ArrayList<HomeBannerBean.DataBean.NewGoodsListBean> goodlist, LayoutHelper layoutHelper) {
        this.context = context;
        this.goodlist = goodlist;
        this.layoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_good_img, parent, false);
        return new ViewHold(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBannerBean.DataBean.NewGoodsListBean newGoodsListBean = goodlist.get(position);
        ViewHold viewHolder = (ViewHold) holder;
        viewHolder.text_good_weight.setText(newGoodsListBean.getName());
        viewHolder.text_good_price.setText("￥ "+newGoodsListBean.getRetail_price());
        Glide.with(context).load(newGoodsListBean.getList_pic_url()).into(viewHolder.img_good);

    }

    @Override
    public int getItemCount() {
        if (goodlist.size()>0){
            return goodlist.size();
        }else {
            return 0;
        }
    }


    class ViewHold extends RecyclerView.ViewHolder {
        ImageView img_good;
        TextView text_good_weight;
        TextView text_good_price;

        public ViewHold(@NonNull View itemView) {
            super(itemView);
            img_good = itemView.findViewById(R.id.iv_good);
            text_good_weight = itemView.findViewById(R.id.tv_good_weight);
            text_good_price = itemView.findViewById(R.id.tv_good_price);
        }
    }
}
