package com.example.vlayoutapplication.homemadapter;

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
import com.example.vlayoutapplication.R;
import com.example.vlayoutapplication.bean.HomeBannerBean;

import java.util.ArrayList;

public class HomeBadyMadapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<HomeBannerBean.DataBean.CategoryListBean> badylist;
    private LayoutHelper layoutHelper;

    public HomeBadyMadapter(Context context, ArrayList<HomeBannerBean.DataBean.CategoryListBean> badylist, LayoutHelper layoutHelper) {
        this.context = context;
        this.badylist = badylist;
        this.layoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_bady, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBannerBean.DataBean.CategoryListBean goodsListBean = badylist.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        //Glide.with(context).load(goodsListBean.getList_pic_url()).into(viewHolder.img_bady);
        viewHolder.text_name.setText(goodsListBean.getName());
        //viewHolder.text_price.setText("￥ "+goodsListBean.getRetail_price());
    }

    @Override
    public int getItemCount() {
        if(badylist.size()>0){
            return badylist.size();
        }else{
            return 0;
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_bady;
        TextView text_name;
        TextView text_price;

        public ViewHolder(View inflate) {
            super(inflate);
            img_bady=inflate.findViewById(R.id.iv_bady);
            text_name=inflate.findViewById(R.id.tv_bady_name);
            text_price=inflate.findViewById(R.id.tv_bady_price);
        }
    }
}
