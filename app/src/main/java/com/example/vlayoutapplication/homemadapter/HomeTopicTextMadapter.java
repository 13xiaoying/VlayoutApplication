package com.example.vlayoutapplication.homemadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.vlayoutapplication.R;
import com.example.vlayoutapplication.bean.HomeBannerBean;

import java.util.ArrayList;

public class HomeTopicTextMadapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<HomeBannerBean.DataBean.TopicListBean> topiclist;
    private String name;
    private LayoutHelper layoutHelper;

    public HomeTopicTextMadapter(Context context, ArrayList<HomeBannerBean.DataBean.TopicListBean> topiclist, String name, LayoutHelper layoutHelper) {
        this.context = context;
        this.topiclist = topiclist;
        this.name = name;
        this.layoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_topic_text, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //HomeBannerBean.DataBean.NewGoodsListBean newGoodsListBean = goodlist.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.text_topic.setText(name);
    }

    @Override
    public int getItemCount() {
        if (topiclist.size() > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_topic;

        public ViewHolder(View inflate) {
            super(inflate);
            text_topic = inflate.findViewById(R.id.tv_topic);
        }
    }
}
