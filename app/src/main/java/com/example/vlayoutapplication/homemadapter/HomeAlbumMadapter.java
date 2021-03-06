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
import com.bumptech.glide.Glide;
import com.example.vlayoutapplication.R;
import com.example.vlayoutapplication.bean.HomeBannerBean;

import java.util.ArrayList;

public class HomeAlbumMadapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<HomeBannerBean.DataBean.ChannelBean> albumlist;
    private LayoutHelper layoutHelper;

    public HomeAlbumMadapter(Context context, ArrayList<HomeBannerBean.DataBean.ChannelBean> albumlist, LayoutHelper layoutHelper) {
        this.context = context;
        this.albumlist = albumlist;
        this.layoutHelper = layoutHelper;






    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_album, parent, false);
        return new ViewHol(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBannerBean.DataBean.ChannelBean channelBean = albumlist.get(position);
        ViewHol viewHolder= (ViewHol) holder;
        viewHolder.text_album.setText(channelBean.getName());
        Glide.with(context).load(channelBean.getIcon_url()).into(viewHolder.img_album);
    }

    @Override
    public int getItemCount() {
        if (albumlist.size()>0){
            return albumlist.size();
        }else {
            return 0;
        }
    }


    private class ViewHol extends RecyclerView.ViewHolder {
        ImageView img_album;
        TextView text_album;

        public ViewHol(@NonNull View itemView) {
            super(itemView);
            img_album=itemView.findViewById(R.id.iv_album);
            text_album=itemView.findViewById(R.id.tv_album);
        }
    }
}
