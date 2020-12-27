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
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.vlayoutapplication.R;
import com.example.vlayoutapplication.bean.HomeBannerBean;

import java.util.ArrayList;

public class HomeBrandTextMadapter extends DelegateAdapter.Adapter {
    private Context context;
    private SingleLayoutHelper singleLayoutHelper;

    public HomeBrandTextMadapter(Context context, SingleLayoutHelper singleLayoutHelper) {
        this.context = context;
        this.singleLayoutHelper = singleLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
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
        textViewHolder.text.setText("品牌制造商直供");
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class TextViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        public TextViewHolder(View inflate) {
            super(inflate);
            text = inflate.findViewById(R.id.brand_text);
        }
    }
}
