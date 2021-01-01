package com.example.vlayoutapplication.homemadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.vlayoutapplication.R;
import com.example.vlayoutapplication.bean.HomeBannerBean;

import java.util.ArrayList;

public class HomeTopicImgRecyclerMadapter extends DelegateAdapter.Adapter {
    private Context context;
    private LayoutHelper layoutHelper;
    private ArrayList<HomeBannerBean.DataBean.TopicListBean> topiclist;
    private HomeTopicImgMadapter homeTopicImgMadapter;

    public HomeTopicImgRecyclerMadapter(Context context, LayoutHelper layoutHelper, ArrayList<HomeBannerBean.DataBean.TopicListBean> topiclist) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.topiclist = topiclist;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_topic_recycler, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        homeTopicImgMadapter = new HomeTopicImgMadapter(context, topiclist);
        viewHolder.recyclerView.setAdapter(homeTopicImgMadapter);
        LinearLayoutManager layout = new LinearLayoutManager(context);
        layout.setOrientation(RecyclerView.HORIZONTAL);
        viewHolder.recyclerView.setLayoutManager(layout);
    }

    @Override
    public int getItemCount() {
        if(topiclist.size()>0){
            return 1;
        }else{
            return 0;
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        public ViewHolder(View inflate) {
            super(inflate);
            recyclerView=inflate.findViewById(R.id.rv_view_topic);
        }
    }
}
