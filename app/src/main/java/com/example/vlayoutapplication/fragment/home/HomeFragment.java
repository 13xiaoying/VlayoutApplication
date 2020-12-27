package com.example.vlayoutapplication.fragment.home;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.vlayoutapplication.R;
import com.example.vlayoutapplication.base.BaseHomeFragment;
import com.example.vlayoutapplication.bean.HomeBannerBean;
import com.example.vlayoutapplication.contract.HomeContract;
import com.example.vlayoutapplication.madapter.HomeAlbumMadapter;
import com.example.vlayoutapplication.madapter.HomeBannerMadapter;
import com.example.vlayoutapplication.madapter.HomeBrandImgMadapter;
import com.example.vlayoutapplication.madapter.HomeBrandTextMadapter;
import com.example.vlayoutapplication.madapter.HomeSeekMadapter;
import com.example.vlayoutapplication.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseHomeFragment<HomePresenter> implements HomeContract.CHomeView {
    private ImageView mMainImgIv;
    private TextView mMainTextTv;
    private LinearLayout mHomeOutLl;
    private RecyclerView mViewHomeRv;
    private ArrayList<HomeBannerBean.DataBean.BannerBean> bannerlist;
    private VirtualLayoutManager virtualLayoutManager;
    private HomeAlbumMadapter homeAlbumMadapter;
    private GridLayoutHelper gridLayoutHelperbrand;
    private HomeBannerMadapter homeBannerMadapter;
    private ArrayList<HomeBannerBean.DataBean.ChannelBean> albumlist;
    private SingleLayoutHelper singleLayoutHelper;
    private ColumnLayoutHelper columnLayoutHelper;
    private LinearLayoutHelper linearLayoutHelper;
    private HomeSeekMadapter homeSeekMadapter;
    private ColumnLayoutHelper columnLayoutHelperseek;
    private ArrayList<HomeBannerBean.DataBean.BrandListBean> brandlist;
    private HomeBrandImgMadapter homeBrandImgMadapter;
    private HomeBrandTextMadapter homeBrandTextMadapter;
    private SingleLayoutHelper singleLayoutHelperBanner;
    private ColumnLayoutHelper columnLayoutHelperalbum;
    private SingleLayoutHelper singleLayoutHelperbrand;

    @Override
    public void initView(@NonNull final View itemView) {
//        mMainImgIv = (ImageView) itemView.findViewById(R.id.iv_main_img);
//        mMainTextTv = (TextView) itemView.findViewById(R.id.tv_main_text);
//        mHomeOutLl = (LinearLayout) itemView.findViewById(R.id.ll_home_out);
        mViewHomeRv = (RecyclerView) itemView.findViewById(R.id.rv_view_home);

        bannerlist = new ArrayList<>();//banner
        albumlist = new ArrayList<>();//album
        brandlist = new ArrayList<>();//brand




        virtualLayoutManager = new VirtualLayoutManager(getActivity());

        mViewHomeRv.setLayoutManager(virtualLayoutManager);
        // 设置组件复用回收池
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mViewHomeRv.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
    }


    @Override
    public void initDate() {
        presenter.Result();

        seek();
        banner();
        album();
        brand();



        //singleLayoutHelper.setItemCount(3);// 设置布局里Item个数
        //singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        //singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        //singleLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        //singleLayoutHelper.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比


        //columnLayoutHelper特有属性
        //columnLayoutHelper.setWeights(new float[]{20, 20, 20,20,20});// 设置该行每个Item占该行总宽度的比例*/

        /*//设置线性布局
        linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(5);// 设置布局里Item个数
        linearLayoutHelper.setPadding(10,10,10,10);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        linearLayoutHelper.setMargin(10,10,10,10);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        linearLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        linearLayoutHelper.setAspectRatio(10);// 设置设置布局内每行布局的宽与高的比

        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离
        /*gridLayoutHelper = new GridLayoutHelper(5);
        // 设置布局里Item个数
        gridLayoutHelper.setItemCount(6);
        // 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        //gridLayoutHelper.setPadding(30, 6, 6, 6);
        // 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        //gridLayoutHelper.setMargin(30, 6, 6, 6);
        // 设置背景颜色
        gridLayoutHelper.setBgColor(Color.WHITE);
        // 设置设置布局内每行布局的宽与高的比
        gridLayoutHelper.setAspectRatio(10);
        //设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setWeights(new float[]{20, 20, 20, 20,20});
        // 控制子元素之间的垂直间距
        //gridLayoutHelper.setVGap(10);
        // 控制子元素之间的水平间距
        gridLayoutHelper.setHGap(10);
        //是否自动填充空白区域
        gridLayoutHelper.setAutoExpand(false);
        // 设置每行多少个网格
        gridLayoutHelper.setSpanCount(5);*/

        madapter();
    }

    private void brand() {
        singleLayoutHelperbrand = new SingleLayoutHelper();
        singleLayoutHelperbrand.setItemCount(1);

        //brand适配器文字
        homeBrandTextMadapter = new HomeBrandTextMadapter(getActivity(),singleLayoutHelperbrand);

        gridLayoutHelperbrand = new GridLayoutHelper(1);
        // 设置布局里Item个数
        gridLayoutHelperbrand.setItemCount(2);
        // 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelperbrand.setPadding(30, 6, 6, 6);
        // 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelperbrand.setMargin(30, 6, 6, 6);
        // 设置背景颜色
        gridLayoutHelperbrand.setBgColor(Color.GREEN);
        // 设置设置布局内每行布局的宽与高的比
        gridLayoutHelperbrand.setAspectRatio(10);
        //设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelperbrand.setWeights(new float[]{20, 20, 20, 20,20});
        // 控制子元素之间的垂直间距
        gridLayoutHelperbrand.setVGap(10);
        // 控制子元素之间的水平间距
        gridLayoutHelperbrand.setHGap(10);
        //是否自动填充空白区域
        gridLayoutHelperbrand.setAutoExpand(false);
        // 设置每行多少个网格
        gridLayoutHelperbrand.setSpanCount(2);
        //brand适配器
        homeBrandImgMadapter = new HomeBrandImgMadapter(getActivity(), brandlist, gridLayoutHelperbrand);

    }

    private void album() {
        //设置兰格布局
        columnLayoutHelperalbum = new ColumnLayoutHelper();
        //columnLayoutHelper.setItemCount(5);// 设置布局里Item个数
        //columnLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        columnLayoutHelperalbum.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        //columnLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        columnLayoutHelperalbum.setAspectRatio(5);// 设置设置布局内每行布局的宽与高的比
        //album适配器
        homeAlbumMadapter = new HomeAlbumMadapter(getActivity(), albumlist, columnLayoutHelperalbum);

    }

    private void banner() {
        //设置通栏布局
        singleLayoutHelperBanner = new SingleLayoutHelper();
        singleLayoutHelperBanner.setItemCount(2);
        //banner适配器
        homeBannerMadapter = new HomeBannerMadapter(getActivity(), bannerlist, singleLayoutHelperBanner);
    }

    private void seek() {
        //设置通栏布局 搜索
        //设置兰格布局
        columnLayoutHelperseek = new ColumnLayoutHelper();
        //columnLayoutHelper.setItemCount(5);// 设置布局里Item个数
        //columnLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        columnLayoutHelperseek.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        //columnLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        columnLayoutHelperseek.setAspectRatio(5);// 设置设置布局内每行布局的宽与高的比
        //搜索
        homeSeekMadapter = new HomeSeekMadapter(getActivity(), columnLayoutHelperseek);
    }

    @Override
    public int getIcount() {
        return R.layout.fragment_home;
    }

    @Override
    public HomePresenter getInterface() {
        return new HomePresenter();
    }

    private void madapter() {
        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager, true);

        delegateAdapter.addAdapter(homeSeekMadapter);
        delegateAdapter.addAdapter(homeBannerMadapter);
        delegateAdapter.addAdapter(homeAlbumMadapter);
        delegateAdapter.addAdapter(homeBrandImgMadapter);
        delegateAdapter.addAdapter(homeBrandTextMadapter);

        //布局管理器
//        mViewHomeRv.setLayoutManager(virtualLayoutManager);
        //绑定适配器
        mViewHomeRv.setAdapter(delegateAdapter);
    }

    @Override
    public void onInit(HomeBannerBean bean) {
        if (bean != null) {
            homeSeekMadapter.notifyDataSetChanged();

            List<HomeBannerBean.DataBean.BannerBean> banner = bean.getData().getBanner();
            bannerlist.addAll(banner);
            homeBannerMadapter.notifyDataSetChanged();

            List<HomeBannerBean.DataBean.ChannelBean> channel = bean.getData().getChannel();
            albumlist.addAll(channel);
            homeAlbumMadapter.notifyDataSetChanged();

            List<HomeBannerBean.DataBean.BrandListBean> brandList = bean.getData().getBrandList();
            brandlist.addAll(brandList);
            homeBrandImgMadapter.notifyDataSetChanged();
            homeBrandTextMadapter.notifyDataSetChanged();




        }
    }

    @Override
    public void onError(String error) {
        Log.i(TAG, "onError: 错误信息" + error);
    }

    private static final String TAG = "HomeFragment";
}