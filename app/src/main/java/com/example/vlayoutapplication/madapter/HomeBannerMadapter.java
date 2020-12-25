package com.example.vlayoutapplication.madapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.vlayoutapplication.R;
import com.example.vlayoutapplication.bean.HomeBannerBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class HomeBannerMadapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<HomeBannerBean.DataBean.BannerBean> list;
    private SingleLayoutHelper singleLayoutHelper;

    public HomeBannerMadapter(Context context, ArrayList<HomeBannerBean.DataBean.BannerBean> list, SingleLayoutHelper singleLayoutHelper) {
        this.context = context;
        this.list = list;
        this.singleLayoutHelper = singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_banner, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.banner.setImages(list).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                HomeBannerBean.DataBean.BannerBean bannerBean = (HomeBannerBean.DataBean.BannerBean) path;
                Glide.with(context).load(bannerBean.getImage_url()).into(imageView);
            }
        }).start();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnclickItem.iOnclick();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        Banner banner;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            banner=itemView.findViewById(R.id.banner_home);
        }
    }
    public interface iOnclickItem{
        void iOnclick();
    }
    iOnclickItem iOnclickItem;

    public void setiOnclickItem(HomeBannerMadapter.iOnclickItem iOnclickItem) {
        this.iOnclickItem = iOnclickItem;
    }
}
