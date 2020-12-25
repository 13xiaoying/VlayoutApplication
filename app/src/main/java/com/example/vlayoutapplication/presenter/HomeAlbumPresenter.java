package com.example.vlayoutapplication.presenter;

import com.example.vlayoutapplication.base.BasePresenter;
import com.example.vlayoutapplication.bean.HomeAlbumBean;
import com.example.vlayoutapplication.contract.HomeContract;
import com.example.vlayoutapplication.model.HomeBannerModel;
import com.example.vlayoutapplication.util.net.IneterCallBack;
import com.example.vlayoutapplication.util.net.UrlContstant;

import java.util.List;

public class HomeAlbumPresenter extends BasePresenter<HomeContract.CHomeView> implements HomeContract.CHomePresenter {
    public final HomeBannerModel homeBannerModel;

    public HomeAlbumPresenter(HomeContract.CHomeView cHomeView) {
        this.homeBannerModel = new HomeBannerModel(this);
    }

    @Override
    public void Result() {
        homeBannerModel.getData(UrlContstant.albumurl, new IneterCallBack<HomeAlbumBean>() {
            @Override
            public void onInit(HomeAlbumBean a) {
                List<HomeAlbumBean.DataBean.CategoryListBean> categoryList = a.getData().getCategoryList();
                iView.onInit1(a);
            }

            @Override
            public void onError(String error) {

            }
        });
    }
}
