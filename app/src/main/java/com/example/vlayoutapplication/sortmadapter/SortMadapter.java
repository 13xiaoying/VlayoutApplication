package com.example.vlayoutapplication.sortmadapter;

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
import com.example.vlayoutapplication.bean.SortBean;

import java.util.ArrayList;

public class SortMadapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<SortBean.DataBeanX.DataBean> list;

    public SortMadapter(Context context, ArrayList<SortBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_sort_madapter, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final SortBean.DataBeanX.DataBean dataBean = list.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        Glide.with(context).load(dataBean.getScene_pic_url()).into(viewHolder.img_sort);
        viewHolder.text_sort_title.setText(dataBean.getTitle());
        viewHolder.text_sort_discounts.setText(dataBean.getSubtitle());
        viewHolder.text_sort_price.setText("￥ "+dataBean.getPrice_info());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnclickItem.iOnclick(dataBean.getScene_pic_url());
            }
        });
    }

    @Override
    public int getItemCount() {
        if(list.size()>0){
           return list.size();
        }else{
            return 0;
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_sort;
        TextView text_sort_title;
        TextView text_sort_discounts;
        TextView text_sort_price;
        public ViewHolder(View inflate) {
            super(inflate);
            img_sort=inflate.findViewById(R.id.iv_sort_img);
            text_sort_title=inflate.findViewById(R.id.tv_sort_title);
            text_sort_discounts=inflate.findViewById(R.id.tv_sort_discounts);
            text_sort_price=inflate.findViewById(R.id.tv_sort_price);
        }
    }
    public interface iOnclickItem{
        void iOnclick(String url);
    }
    iOnclickItem iOnclickItem;

    public void setiOnclickItem(SortMadapter.iOnclickItem iOnclickItem) {
        this.iOnclickItem = iOnclickItem;
    }
}
