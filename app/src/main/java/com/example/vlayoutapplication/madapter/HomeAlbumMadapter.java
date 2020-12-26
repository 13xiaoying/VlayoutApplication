package com.example.vlayoutapplication.madapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.vlayoutapplication.R;
import com.example.vlayoutapplication.bean.HomeBannerBean;

import java.util.ArrayList;

public class HomeAlbumMadapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<HomeBannerBean.DataBean.ChannelBean> albumlist;
    private GridLayoutHelper gridLayoutHelper;

    public HomeAlbumMadapter(Context context, ArrayList<HomeBannerBean.DataBean.ChannelBean> albumlist, GridLayoutHelper gridLayoutHelper) {
        this.context = context;
        this.albumlist = albumlist;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_album, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int position1 = position;
        HomeBannerBean.DataBean.ChannelBean channelBean = albumlist.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.text_album.setText(channelBean.getName());
        Glide.with(context).load(channelBean.getIcon_url()).into(viewHolder.img_album);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_album;
        TextView text_album;
        public ViewHolder(View inflate) {
            super(inflate);
            img_album=inflate.findViewById(R.id.iv_album);
            text_album=inflate.findViewById(R.id.tv_album);
        }
    }
}
