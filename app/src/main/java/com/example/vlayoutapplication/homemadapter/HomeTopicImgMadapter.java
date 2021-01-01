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

public class HomeTopicImgMadapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<HomeBannerBean.DataBean.TopicListBean> topiclist;

    public HomeTopicImgMadapter(Context context, ArrayList<HomeBannerBean.DataBean.TopicListBean> topiclist) {
        this.context = context;
        this.topiclist = topiclist;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_topic_img, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBannerBean.DataBean.TopicListBean topicListBean = topiclist.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        Glide.with(context).load(topicListBean.getItem_pic_url()).into(viewHolder.img_topic);
        viewHolder.text_topic_title.setText(topicListBean.getTitle());
        viewHolder.text_topic_price.setText("￥ "+topicListBean.getPrice_info());
        viewHolder.text_topic_sale.setText(topicListBean.getSubtitle());
    }

    @Override
    public int getItemCount() {
        if(topiclist!=null){
            return topiclist.size();
        }else{
            return 0;
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_topic;
        TextView text_topic_title;
        TextView text_topic_price;
        TextView text_topic_sale;

        public ViewHolder(View inflate) {
            super(inflate);
            img_topic=inflate.findViewById(R.id.iv_topic);
            text_topic_title=inflate.findViewById(R.id.tv_topic_title);
            text_topic_price=inflate.findViewById(R.id.tv_topic_price);
            text_topic_sale=inflate.findViewById(R.id.tv_topic_sale);
        }
    }
}
