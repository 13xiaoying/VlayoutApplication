package com.example.vlayoutapplication.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.vlayoutapplication.R;
import com.example.vlayoutapplication.bean.HomeAlbumBean;
import com.example.vlayoutapplication.bean.HomeBannerBean;
import com.example.vlayoutapplication.contract.HomeContract;
import com.example.vlayoutapplication.madapter.HomeAlbumMadapter;
import com.example.vlayoutapplication.madapter.HomeBannerMadapter;
import com.example.vlayoutapplication.presenter.HomeAlbumPresenter;
import com.example.vlayoutapplication.presenter.HomeBannerPresenter;
import com.example.vlayoutapplication.util.net.InterWorkInterface;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements HomeContract.CHomeView {
    private ImageView mMainImgIv;
    private TextView mMainTextTv;
    private LinearLayout mHomeOutLl;
    private RecyclerView mViewHomeRv;
    private ArrayList<HomeBannerBean.DataBean.BannerBean> list;
    private SingleLayoutHelper singleLayoutHelper;
    private VirtualLayoutManager virtualLayoutManager;
    private HomeAlbumMadapter homeAlbumMadapter;
    private GridLayoutHelper gridLayoutHelper;

    Handler her=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                homeAlbumMadapter.notifyDataSetChanged();
                homeBannerMadapter.notifyDataSetChanged();
            }
        }
    };
    private HomeBannerMadapter homeBannerMadapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        initView(inflate);
        initDate();
        initShju();
        return inflate;
    }

    private void initShju() {
        HomeAlbumPresenter homeAlbumPresenter = new HomeAlbumPresenter(getActivity());
        HomeBannerPresenter homeBannerPresenter = new HomeBannerPresenter(getActivity());
        homeAlbumPresenter.Result();
        homeBannerPresenter.Result();
    }

    private void initDate() {
        //设置通栏布局
        singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(3);// 设置布局里Item个数
        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比

        //设置网格布局
        gridLayoutHelper = new GridLayoutHelper(5);
        // 设置布局里Item个数
        gridLayoutHelper.setItemCount(2);
        // 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper.setPadding(10, 10, 10, 10);
        // 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setMargin(10, 10, 10, 10);
        // 设置背景颜色
        gridLayoutHelper.setBgColor(Color.GREEN);
        // 设置设置布局内每行布局的宽与高的比
        gridLayoutHelper.setAspectRatio(5);
        //设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setWeights(new float[]{10, 10, 10, 10});
        // 控制子元素之间的垂直间距
        gridLayoutHelper.setVGap(10);
        // 控制子元素之间的水平间距
        gridLayoutHelper.setHGap(10);
        //是否自动填充空白区域
        gridLayoutHelper.setAutoExpand(false);
        // 设置每行多少个网格
        gridLayoutHelper.setSpanCount(5);

        madapter();
    }

    private void madapter() {
        //banner适配器
        homeBannerMadapter = new HomeBannerMadapter(getActivity(), list, singleLayoutHelper);
        //album适配器
        homeAlbumMadapter = new HomeAlbumMadapter(getActivity(), gridLayoutHelper);
        //


        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager,true);
        delegateAdapter.addAdapter(homeBannerMadapter);
        delegateAdapter.addAdapter(homeAlbumMadapter);



        //布局管理器
        mViewHomeRv.setLayoutManager(virtualLayoutManager);
        //绑定适配器
        mViewHomeRv.setAdapter(delegateAdapter);
    }

    private void initView(@NonNull final View itemView) {
        mMainImgIv = (ImageView) itemView.findViewById(R.id.iv_main_img);
        mMainTextTv = (TextView) itemView.findViewById(R.id.tv_main_text);
        mHomeOutLl = (LinearLayout) itemView.findViewById(R.id.ll_home_out);
        mViewHomeRv = (RecyclerView) itemView.findViewById(R.id.rv_view_home);

        list = new ArrayList<>();


        virtualLayoutManager = new VirtualLayoutManager(getActivity());

        // 设置组件复用回收池
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mViewHomeRv.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
    }


    @Override
    public void onInit(HomeBannerBean bean) {
        List<HomeBannerBean.DataBean.BannerBean> banner = bean.getData().getBanner();

    }

    @Override
    public void onInit1(HomeAlbumBean bean) {

    }

    @Override
    public void onError(String error) {

    }
}