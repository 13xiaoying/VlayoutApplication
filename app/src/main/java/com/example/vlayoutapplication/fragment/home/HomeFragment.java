package com.example.vlayoutapplication.fragment.home;

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
import com.example.vlayoutapplication.homemadapter.HomeAlbumMadapter;
import com.example.vlayoutapplication.homemadapter.HomeBadyMadapter;
import com.example.vlayoutapplication.homemadapter.HomeBannerMadapter;
import com.example.vlayoutapplication.homemadapter.HomeBrandImgMadapter;
import com.example.vlayoutapplication.homemadapter.HomeBrandTextMadapter;
import com.example.vlayoutapplication.homemadapter.HomeClothingMadapter;
import com.example.vlayoutapplication.homemadapter.HomeDietMadapter;
import com.example.vlayoutapplication.homemadapter.HomeGoodImgMadapter;
import com.example.vlayoutapplication.homemadapter.HomeGoodTextMadapter;
import com.example.vlayoutapplication.homemadapter.HomeHotGoodsImgMadapter;
import com.example.vlayoutapplication.homemadapter.HomeHotGoodsTextMadapter;
import com.example.vlayoutapplication.homemadapter.HomeHouseMadapter;
import com.example.vlayoutapplication.homemadapter.HomeKitchenMadapter;
import com.example.vlayoutapplication.homemadapter.HomePartsMadapter;
import com.example.vlayoutapplication.homemadapter.HomeSeekMadapter;
import com.example.vlayoutapplication.homemadapter.HomeTopicImgRecyclerMadapter;
import com.example.vlayoutapplication.homemadapter.HomeTopicTextMadapter;
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
    private HomeHotGoodsImgMadapter homeHotGoodsImgMadapter;
    private HomeHotGoodsTextMadapter homeHotGoodsTextMadapter;
    private ArrayList<HomeBannerBean.DataBean.TopicListBean> topiclist;
    private HomeTopicImgRecyclerMadapter homeTopicImgRecyclerMadapter;
    private HomeTopicTextMadapter homeTopicTextMadapter;
    private ArrayList<HomeBannerBean.DataBean.CategoryListBean> houselist;
    private ArrayList<HomeBannerBean.DataBean.CategoryListBean> kitchenlist;
    private ArrayList<HomeBannerBean.DataBean.CategoryListBean> dietlist;
    private ArrayList<HomeBannerBean.DataBean.CategoryListBean> partslist;
    private ArrayList<HomeBannerBean.DataBean.CategoryListBean> clothinglist;
    private ArrayList<HomeBannerBean.DataBean.CategoryListBean> badylist;
    private HomeHouseMadapter homeHouseMadapter;
    private HomeKitchenMadapter homeKitchenMadapter;
    private HomeBadyMadapter homeBadyMadapter;
    private HomeClothingMadapter homeClothingMadapter;
    private HomePartsMadapter homePartsMadapter;
    private HomeTopicTextMadapter homeDietTextMadapter;
    private HomeDietMadapter homeDietMadapter;
    private HomeTopicTextMadapter homeClothingTextMadapter;
    private HomeTopicTextMadapter homePartsTextMadapter;
    private HomeTopicTextMadapter homeKitchenTextMadapter;
    private HomeTopicTextMadapter homeHouseTextMadapter;
    private HomeTopicTextMadapter homeBadyTextMadapter;

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
        hotgoodslist = new ArrayList<>();//hotgoods
        topiclist = new ArrayList<>();//topic
        houselist = new ArrayList<>();//house
        kitchenlist = new ArrayList<>();//kitchen
        dietlist = new ArrayList<>();//diet
        partslist = new ArrayList<>();//parts
        clothinglist = new ArrayList<>();//clothing
        badylist = new ArrayList<>();//bady


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
        TopicImg();
        TopicText();
        title();
        /*house();
        kitchen();
        diet();
        parts();
        clothing();
        bady();*/

        //设置通栏布局
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);       // 公共属性

        madapter();
    }

    private void title() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        homeHouseMadapter = new HomeHouseMadapter(getActivity(), houselist,linearLayoutHelper);
    }

    private void bady() {
        /*SingleLayoutHelper singleLayoutHelpertopic = new SingleLayoutHelper();
        singleLayoutHelpertopic.setItemCount(1);
        singleLayoutHelpertopic.setAspectRatio(6);
        singleLayoutHelpertopic.setMarginTop(6);
        //brand适配器文字
        String text = "婴童";
        homeBadyTextMadapter = new HomeTopicTextMadapter(getActivity(), topiclist, text, singleLayoutHelpertopic);
*/
        GridLayoutHelper gridLayoutHelpergood = new GridLayoutHelper(2);
        // 设置布局里Item个数
        gridLayoutHelpergood.setItemCount(2);
        gridLayoutHelpergood.setAutoExpand(true);
        homeBadyMadapter = new HomeBadyMadapter(getActivity(), badylist, gridLayoutHelpergood);
    }

    private void clothing() {
        /*SingleLayoutHelper singleLayoutHelpertopic = new SingleLayoutHelper();
        singleLayoutHelpertopic.setItemCount(1);
        singleLayoutHelpertopic.setAspectRatio(6);
        singleLayoutHelpertopic.setMarginTop(6);
        //brand适配器文字
        String text = "服装";
        homeClothingTextMadapter = new HomeTopicTextMadapter(getActivity(), topiclist, text, singleLayoutHelpertopic);
*/
        GridLayoutHelper gridLayoutHelpergood = new GridLayoutHelper(2);
        // 设置布局里Item个数
        gridLayoutHelpergood.setItemCount(4);
        gridLayoutHelpergood.setAutoExpand(true);
        homeClothingMadapter = new HomeClothingMadapter(getActivity(), clothinglist, gridLayoutHelpergood);
    }

    private void parts() {
        /*SingleLayoutHelper singleLayoutHelpertopic = new SingleLayoutHelper();
        singleLayoutHelpertopic.setItemCount(1);
        singleLayoutHelpertopic.setAspectRatio(6);
        singleLayoutHelpertopic.setMarginTop(6);
        //brand适配器文字
        String text = "配件";
        homePartsTextMadapter = new HomeTopicTextMadapter(getActivity(), topiclist, text, singleLayoutHelpertopic);
*/
        GridLayoutHelper gridLayoutHelpergood = new GridLayoutHelper(2);
        // 设置布局里Item个数
        gridLayoutHelpergood.setItemCount(4);
        gridLayoutHelpergood.setAutoExpand(true);
        homePartsMadapter = new HomePartsMadapter(getActivity(), partslist, gridLayoutHelpergood);
    }

    private void diet() {
        /*SingleLayoutHelper singleLayoutHelpertopic = new SingleLayoutHelper();
        singleLayoutHelpertopic.setItemCount(1);
        singleLayoutHelpertopic.setAspectRatio(6);
        singleLayoutHelpertopic.setMarginTop(6);
        //brand适配器文字
        String text = "饮品";
        homeDietTextMadapter = new HomeTopicTextMadapter(getActivity(), topiclist, text, singleLayoutHelpertopic);
*/
        GridLayoutHelper gridLayoutHelpergood = new GridLayoutHelper(2);
        // 设置布局里Item个数
        gridLayoutHelpergood.setItemCount(4);
        gridLayoutHelpergood.setAutoExpand(true);
        homeDietMadapter = new HomeDietMadapter(getActivity(), dietlist, gridLayoutHelpergood);
    }

    private void kitchen() {
        /*SingleLayoutHelper singleLayoutHelpertopic = new SingleLayoutHelper();
        singleLayoutHelpertopic.setItemCount(1);
        singleLayoutHelpertopic.setAspectRatio(6);
        singleLayoutHelpertopic.setMarginTop(6);
        //brand适配器文字
        String text = "餐厨";
        homeKitchenTextMadapter = new HomeTopicTextMadapter(getActivity(), topiclist, text, singleLayoutHelpertopic);
*/
        GridLayoutHelper gridLayoutHelpergood = new GridLayoutHelper(2);
        // 设置布局里Item个数
        gridLayoutHelpergood.setItemCount(4);
        gridLayoutHelpergood.setAutoExpand(true);
        homeKitchenMadapter = new HomeKitchenMadapter(getActivity(), kitchenlist, gridLayoutHelpergood);
    }

    private void house() {
        /*SingleLayoutHelper singleLayoutHelpertopic = new SingleLayoutHelper();
        singleLayoutHelpertopic.setItemCount(1);
        singleLayoutHelpertopic.setAspectRatio(6);
        singleLayoutHelpertopic.setMarginTop(6);
        //brand适配器文字
        String text = "居家";
        homeHouseTextMadapter = new HomeTopicTextMadapter(getActivity(), topiclist, text, singleLayoutHelpertopic);
*/
        GridLayoutHelper gridLayoutHelpergood = new GridLayoutHelper(2);
        // 设置布局里Item个数
        gridLayoutHelpergood.setItemCount(4);
        gridLayoutHelpergood.setAutoExpand(true);
        homeHouseMadapter = new HomeHouseMadapter(getActivity(), houselist, gridLayoutHelpergood);
    }

    private void TopicText() {
        SingleLayoutHelper singleLayoutHelpertopic = new SingleLayoutHelper();
        singleLayoutHelpertopic.setItemCount(1);
        singleLayoutHelpertopic.setAspectRatio(6);
        singleLayoutHelpertopic.setMarginTop(6);
        //brand适配器文字
        String text = "专题精选";
        homeTopicTextMadapter = new HomeTopicTextMadapter(getActivity(), topiclist, text, singleLayoutHelpertopic);
    }

    private void TopicImg() {
        ColumnLayoutHelper columnLayoutHelpertopic = new ColumnLayoutHelper();
        columnLayoutHelpertopic.setItemCount(1);
        columnLayoutHelpertopic.setAspectRatio(2);
        columnLayoutHelpertopic.setPadding(1, 1, 1, 1);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        columnLayoutHelpertopic.setMargin(1, 1, 1, 1);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        columnLayoutHelpertopic.setAspectRatio(1);// 设置设置布局内每行布局的宽与高的比
        columnLayoutHelpertopic.setWeights(new float[]{100});// 设置该行每个Item占该行总宽度的比例
        homeTopicImgRecyclerMadapter = new HomeTopicImgRecyclerMadapter(getActivity(), columnLayoutHelpertopic, topiclist);
        /*LinearLayoutHelper linearLayoutHelpertopic = new LinearLayoutHelper();
        linearLayoutHelpertopic.setItemCount(4);// 设置布局里Item个数
        linearLayoutHelpertopic.setPadding(10,10,10,10);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        linearLayoutHelpertopic.setMargin(10,10,10,10);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        linearLayoutHelpertopic.setBgColor(Color.GRAY);// 设置背景颜色
        linearLayoutHelpertopic.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        homeTopicImgRecyclerMadapter = new HomeTopicImgRecyclerMadapter(getActivity(), linearLayoutHselpertopic,topiclist);*/
    }

    //人气推荐
    private void hotgoodImg() {
        GridLayoutHelper gridLayoutHelpergood = new GridLayoutHelper(1);
        // 设置布局里Item个数
        gridLayoutHelpergood.setItemCount(4);
        gridLayoutHelpergood.setAutoExpand(true);
        homeHotGoodsImgMadapter = new HomeHotGoodsImgMadapter(getActivity(), hotgoodslist, gridLayoutHelpergood);
    }

    private void hotgoodText() {
        SingleLayoutHelper singleLayoutHelpergood = new SingleLayoutHelper();
        singleLayoutHelpergood.setItemCount(1);
        singleLayoutHelpergood.setAspectRatio(6);
        singleLayoutHelpergood.setMarginTop(6);
        //brand适配器文字
        String text = "人气推荐";
        homeHotGoodsTextMadapter = new HomeHotGoodsTextMadapter(getActivity(), hotgoodslist, text, singleLayoutHelpergood);
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

        delegateAdapter.addAdapter(homeHotGoodsTextMadapter);

        delegateAdapter.addAdapter(homeHotGoodsImgMadapter);

        delegateAdapter.addAdapter(homeTopicTextMadapter);

        delegateAdapter.addAdapter(homeTopicImgRecyclerMadapter);
        /*//居家
        delegateAdapter.addAdapter(homeHouseTextMadapter);
        delegateAdapter.addAdapter(homeHouseMadapter);
        //餐厨 kitchen
        delegateAdapter.addAdapter(homeKitchenTextMadapter);
        delegateAdapter.addAdapter(homeKitchenMadapter);
        //饮食 diet
        delegateAdapter.addAdapter(homeDietTextMadapter);
        delegateAdapter.addAdapter(homeDietMadapter);
        //配件 parts
        delegateAdapter.addAdapter(homePartsTextMadapter);
        delegateAdapter.addAdapter(homePartsMadapter);
        //服装 clothing
        delegateAdapter.addAdapter(homeClothingTextMadapter);
        delegateAdapter.addAdapter(homeClothingMadapter);
        //婴童 bady
        delegateAdapter.addAdapter(homeBadyTextMadapter);
        delegateAdapter.addAdapter(homeBadyMadapter);*/
        delegateAdapter.addAdapter(homeHouseMadapter);
        //布局管理器
        mViewHomeRv.setLayoutManager(virtualLayoutManager);
        //绑定适配器
        mViewHomeRv.setAdapter(delegateAdapter);
    }

    @Override
    public void onInit(HomeBannerBean bean) {
        Log.i(TAG, "onInit: " + bean.toString());
        if (bean != null) {

//            homeSeekMadapter.notifyDataSetChanged();

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

            List<HomeBannerBean.DataBean.HotGoodsListBean> hotGoodsList = bean.getData().getHotGoodsList();
            hotgoodslist.addAll(hotGoodsList);
            homeHotGoodsTextMadapter.notifyDataSetChanged();
            homeHotGoodsImgMadapter.notifyDataSetChanged();

            List<HomeBannerBean.DataBean.TopicListBean> topicList = bean.getData().getTopicList();
            topiclist.addAll(topicList);
            homeTopicTextMadapter.notifyDataSetChanged();
            homeTopicImgRecyclerMadapter.notifyDataSetChanged();

            List<HomeBannerBean.DataBean.CategoryListBean> categoryList = bean.getData().getCategoryList();
            houselist.addAll(categoryList);
            homeHouseMadapter.notifyDataSetChanged();

        }
    }

    @Override
    public void onError(String error) {
        Log.i(TAG, "onError: 错误信息" + error);
    }

    private static final String TAG = "HomeFragment";
}