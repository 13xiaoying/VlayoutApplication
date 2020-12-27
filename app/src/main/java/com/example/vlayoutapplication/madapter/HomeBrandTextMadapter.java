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
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.vlayoutapplication.R;
import com.example.vlayoutapplication.bean.HomeBannerBean;

import java.util.ArrayList;

public class HomeBrandTextMadapter extends DelegateAdapter.Adapter {
    private Context context;
    private String name;
    private ArrayList<HomeBannerBean.DataBean.BrandListBean> brandlist;

    private LayoutHelper LayoutHelper;

    public HomeBrandTextMadapter(Context context, String name, ArrayList<HomeBannerBean.DataBean.BrandListBean> brandlist, com.alibaba.android.vlayout.LayoutHelper layoutHelper) {
        this.context = context;
        this.name = name;
        this.brandlist = brandlist;
        LayoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return LayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_brand_text, parent, false);
        return new TextViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextViewHolder textViewHolder= (TextViewHolder) holder;
        textViewHolder.text.setText(name);
    }

    @Override
    public int getItemCount() {
        if(brandlist.size()>0){
            return 1;
        }else{
            return 0;
        }
    }

    private class TextViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        public TextViewHolder(View inflate) {
            super(inflate);
            text = inflate.findViewById(R.id.brand_text);
        }
    }
}
