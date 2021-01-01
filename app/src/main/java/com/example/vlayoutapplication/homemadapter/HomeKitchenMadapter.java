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

public class HomeKitchenMadapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<HomeBannerBean.DataBean.CategoryListBean> kitchenlist;
    private LayoutHelper layoutHelper;

    public HomeKitchenMadapter(Context context, ArrayList<HomeBannerBean.DataBean.CategoryListBean> kitchenlist, LayoutHelper layoutHelper) {
        this.context = context;
        this.kitchenlist = kitchenlist;
        this.layoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_kitchen, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBannerBean.DataBean.CategoryListBean goodsListBean = kitchenlist.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        //Glide.with(context).load(goodsListBean.getList_pic_url()).into(viewHolder.img_kitchen);
        viewHolder.text_name.setText(goodsListBean.getName());
        //viewHolder.text_price.setText("￥ "+goodsListBean.getRetail_price());
    }

    @Override
    public int getItemCount() {
        if(kitchenlist.size()>0){
            return kitchenlist.size();
        }else{
            return 0;
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_kitchen;
        TextView text_name;
        TextView text_price;

        public ViewHolder(View inflate) {
            super(inflate);
            img_kitchen=inflate.findViewById(R.id.iv_kitchen);
            text_name=inflate.findViewById(R.id.tv_kitchen_name);
            text_price=inflate.findViewById(R.id.tv_kitchen_price);
        }
    }
}
