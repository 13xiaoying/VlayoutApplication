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
import com.example.vlayoutapplication.madapter.HomeGoodImgMadapter;
import com.example.vlayoutapplication.madapter.HomeGoodTextMadapter;
import com.example.vlayoutapplication.madapter.HomeHotGoodsImgMadapter;
import com.example.vlayoutapplication.madapter.HomeHotGoodsTextMadapter;
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
    private ArrayList<HomeBannerBean.DataBean.ChannelBean> albumlist;
    private ArrayList<HomeBannerBean.DataBean.BrandListBean> brandlist;
    private HomeBrandTextMadapter homeBrandTextMadapter;
    private HomeBrandImgMadapter homeBrandImgMadapter;
    private HomeAlbumMadapter homeAlbumMadapter;
    private HomeBannerMadapter homeBannerMadapter;
    private HomeSeekMadapter homeSeekMadapter;
    private ArrayList<HomeBannerBean.DataBean.NewGoodsListBean> goodlist;
    private HomeGoodImgMadapter homeGoodImgMadapter;
    private HomeGoodTextMadapter homeGoodTextMadapter;
    private ArrayList<HomeBannerBean.DataBean.HotGoodsListBean> hotgoodslist;

    @Override
    public void initView(@NonNull final View itemView) {
//        mMainImgIv = (ImageView) itemView.findViewById(R.id.iv_main_img);
//        mMainTextTv = (TextView) itemView.findViewById(R.id.tv_main_text);
//        mHomeOutLl = (LinearLayout) itemView.findViewById(R.id.ll_home_out);
        mViewHomeRv = (RecyclerView) itemView.findViewById(R.id.rv_view_home);

        bannerlist = new ArrayList<>();//banner
        albumlist = new ArrayList<>();//album
        brandlist = new ArrayList<>();//brand
        goodlist = new ArrayList<>();//goodlist
        hotgoods = new ArrayList<>();//hotgoods


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
        brandText();
        brandImg();
        goodText();
        goodImg();
        hotgoodText();
        hotgoodImg();

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

        //设置通栏布局
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);       // 公共属性

        madapter();
    }
    //人气推荐
    private void hotgoodImg() {
        GridLayoutHelper gridLayoutHelpergood = new GridLayoutHelper(1);
        // 设置布局里Item个数
        gridLayoutHelpergood.setItemCount(3);
        // 设置布局里Item个数
        //gridLayoutHelperbrand.setItemCount(2);
        // 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        //gridLayoutHelperbrand.setPadding(30, 6, 6, 6);
        // 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        //gridLayoutHelperbrand.setMargin(30, 6, 6, 6);
        // 设置背景颜色
        //gridLayoutHelperbrand.setBgColor(Color.GREEN);
        // 设置设置布局内每行布局的宽与高的比
        //gridLayoutHelperbrand.setAspectRatio(10);
        //设置每行中 每个网格宽度 占 每行总宽度 的比例
        //gridLayoutHelperbrand.setWeights(new float[]{40, 40, 40, 40});
        // 控制子元素之间的垂直间距
        //gridLayoutHelperbrand.setVGap(10);
        // 控制子元素之间的水平间距
        //gridLayoutHelperbrand.setHGap(10);
        //是否自动填充空白区域
        //gridLayoutHelperbrand.setAutoExpand(false);
        // 设置每行多少个网格
        //gridLayoutHelperbrand.setSpanCount(2);
        //brand适配器图片
        gridLayoutHelpergood.setAutoExpand(true);
        //homeGoodImgMadapter = new HomeHotGoodsImgMadapter(getActivity(), goodlist, gridLayoutHelpergood);
    }

    private void hotgoodText() {
        SingleLayoutHelper singleLayoutHelpergood = new SingleLayoutHelper();
        singleLayoutHelpergood.setItemCount(1);
        singleLayoutHelpergood.setAspectRatio(6);
        singleLayoutHelpergood.setMarginTop(6);
        //brand适配器文字
        String text = "人气推荐";
        //homeGoodTextMadapter = new HomeHotGoodsTextMadapter(getActivity(), goodlist, text, singleLayoutHelpergood);
    }


    //周一周四·新品首发
    //good - text
    private void goodText() {
        SingleLayoutHelper singleLayoutHelpergood = new SingleLayoutHelper();
        singleLayoutHelpergood.setItemCount(1);
        singleLayoutHelpergood.setAspectRatio(6);
        singleLayoutHelpergood.setMarginTop(6);
        //brand适配器文字
        String text = "周一周四·新品首发";
        homeGoodTextMadapter = new HomeGoodTextMadapter(getActivity(), goodlist, text, singleLayoutHelpergood);
    }
    //good - img
    private void goodImg() {
        GridLayoutHelper gridLayoutHelpergood = new GridLayoutHelper(2);
        // 设置布局里Item个数
        gridLayoutHelpergood.setItemCount(2);
        // 设置布局里Item个数
        //gridLayoutHelperbrand.setItemCount(2);
        // 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        //gridLayoutHelperbrand.setPadding(30, 6, 6, 6);
        // 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        //gridLayoutHelperbrand.setMargin(30, 6, 6, 6);
        // 设置背景颜色
        //gridLayoutHelperbrand.setBgColor(Color.GREEN);
        // 设置设置布局内每行布局的宽与高的比
        //gridLayoutHelperbrand.setAspectRatio(10);
        //设置每行中 每个网格宽度 占 每行总宽度 的比例
        //gridLayoutHelperbrand.setWeights(new float[]{40, 40, 40, 40});
        // 控制子元素之间的垂直间距
        //gridLayoutHelperbrand.setVGap(10);
        // 控制子元素之间的水平间距
        //gridLayoutHelperbrand.setHGap(10);
        //是否自动填充空白区域
        //gridLayoutHelperbrand.setAutoExpand(false);
        // 设置每行多少个网格
        //gridLayoutHelperbrand.setSpanCount(2);
        //brand适配器图片
        gridLayoutHelpergood.setAutoExpand(true);
        homeGoodImgMadapter = new HomeGoodImgMadapter(getActivity(), goodlist, gridLayoutHelpergood);
    }
    //品牌制造商直供
    //bradn - text
    private void brandText() {
        SingleLayoutHelper singleLayoutHelperbrand = new SingleLayoutHelper();
        singleLayoutHelperbrand.setItemCount(1);
        singleLayoutHelperbrand.setAspectRatio(6);
        singleLayoutHelperbrand.setMarginTop(6);
        //brand适配器文字
        String text = "品牌制造商直供";
        homeBrandTextMadapter = new HomeBrandTextMadapter(getActivity(), text, brandlist, singleLayoutHelperbrand);
    }
    //brand - img
    private void brandImg() {
        GridLayoutHelper gridLayoutHelperbrand = new GridLayoutHelper(2);
        // 设置布局里Item个数
        //gridLayoutHelperbrand.setItemCount(2);
        // 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        //gridLayoutHelperbrand.setPadding(30, 6, 6, 6);
        // 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        //gridLayoutHelperbrand.setMargin(30, 6, 6, 6);
        // 设置背景颜色
        //gridLayoutHelperbrand.setBgColor(Color.GREEN);
        // 设置设置布局内每行布局的宽与高的比
        //gridLayoutHelperbrand.setAspectRatio(10);
        //设置每行中 每个网格宽度 占 每行总宽度 的比例
        //gridLayoutHelperbrand.setWeights(new float[]{40, 40, 40, 40});
        // 控制子元素之间的垂直间距
        //gridLayoutHelperbrand.setVGap(10);
        // 控制子元素之间的水平间距
        //gridLayoutHelperbrand.setHGap(10);
        //是否自动填充空白区域
        //gridLayoutHelperbrand.setAutoExpand(false);
        // 设置每行多少个网格
        //gridLayoutHelperbrand.setSpanCount(2);
        //brand适配器图片
        gridLayoutHelperbrand.setAutoExpand(true);
        homeBrandImgMadapter = new HomeBrandImgMadapter(getActivity(), brandlist, gridLayoutHelperbrand);
    }
    //album
    private void album() {
        //设置兰格布局
        ColumnLayoutHelper columnLayoutHelperalbum = new ColumnLayoutHelper();
        //columnLayoutHelper.setItemCount(5);// 设置布局里Item个数
        //columnLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        columnLayoutHelperalbum.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        //columnLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        columnLayoutHelperalbum.setAspectRatio(5);// 设置设置布局内每行布局的宽与高的比
        //album适配器
        homeAlbumMadapter = new HomeAlbumMadapter(getActivity(), albumlist, columnLayoutHelperalbum);
    }
    //banner
    private void banner() {
        //设置通栏布局
        ColumnLayoutHelper columnLayoutHelperBanner = new SingleLayoutHelper();
        columnLayoutHelperBanner.setItemCount(1);
        //banner适配器
        homeBannerMadapter = new HomeBannerMadapter(getActivity(), bannerlist, columnLayoutHelperBanner);
    }
    //搜索
    private void seek() {
        //设置通栏布局
        //设置兰格布局
        ColumnLayoutHelper columnLayoutHelperseek = new ColumnLayoutHelper();
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

        delegateAdapter.addAdapter(homeBrandTextMadapter);

        delegateAdapter.addAdapter(homeBrandImgMadapter);

        delegateAdapter.addAdapter(homeGoodTextMadapter);

        delegateAdapter.addAdapter(homeGoodImgMadapter);

        //布局管理器
//        mViewHomeRv.setLayoutManager(virtualLayoutManager);
        //绑定适配器
        mViewHomeRv.setAdapter(delegateAdapter);
    }

    @Override
    public void onInit(HomeBannerBean bean) {
        Log.i(TAG, "onInit: " + bean.toString());
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

            List<HomeBannerBean.DataBean.NewGoodsListBean> newGoodsList = bean.getData().getNewGoodsList();
            goodlist.addAll(newGoodsList);
            homeGoodImgMadapter.notifyDataSetChanged();
            homeGoodTextMadapter.notifyDataSetChanged();

            Log.i("goodlist", "onInit: good"+newGoodsList.toString());
        }
    }

    @Override
    public void onError(String error) {
        Log.i(TAG, "onError: 错误信息" + error);
    }

    private static final String TAG = "HomeFragment";
}