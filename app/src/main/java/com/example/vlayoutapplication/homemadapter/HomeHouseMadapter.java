package com.example.vlayoutapplication.homemadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.vlayoutapplication.R;
import com.example.vlayoutapplication.bean.HomeBannerBean;

import java.util.ArrayList;
import java.util.List;

public class HomeHouseMadapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<HomeBannerBean.DataBean.CategoryListBean> houselist;
    private LayoutHelper layoutHelper;

    public HomeHouseMadapter(Context context, ArrayList<HomeBannerBean.DataBean.CategoryListBean> houselist, LayoutHelper layoutHelper) {
        this.context = context;
        this.houselist = houselist;
        this.layoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_house_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        HomeBannerBean.DataBean.CategoryListBean goodsListBean = houselist.get(position);
        viewHolder.house_title.setText(goodsListBean.getName());
        List<HomeBannerBean.DataBean.CategoryListBean.GoodsListBean> goodsList = goodsListBean.getGoodsList();
        ArrayList<HomeBannerBean.DataBean.CategoryListBean.GoodsListBean> goodlist = new ArrayList<>();
        GridLayoutManager gridLayoutHelper = new GridLayoutManager(context, 2);
        //gridLayoutHelper.setItemCount(6);// 设置布局里Item个数
        viewHolder.recyclerView.setLayoutManager(gridLayoutHelper);

        if (goodsListBean.getGoodsList().size()>0){
            goodlist.addAll(goodsList);
            HomeHouseRecyclerMadapter homeHouseRecyclerMadapter = new HomeHouseRecyclerMadapter(context, goodlist);
            viewHolder.recyclerView.setAdapter(homeHouseRecyclerMadapter);
        }
    }

    @Override
    public int getItemCount() {
        if(houselist.size()>0){
            return houselist.size();
        }else{
            return 0;
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView house_title;
        public ViewHolder(View inflate) {
            super(inflate);
            recyclerView=inflate.findViewById(R.id.rv_view_goods);
            house_title=inflate.findViewById(R.id.tv_house_title);
        }
    }
}
