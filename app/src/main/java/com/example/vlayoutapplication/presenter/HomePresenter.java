package com.example.vlayoutapplication.presenter;

import com.example.vlayoutapplication.base.BasePresenter;
import com.example.vlayoutapplication.bean.HomeBannerBean;
import com.example.vlayoutapplication.contract.HomeContract;
import com.example.vlayoutapplication.model.HomeModel;
import com.example.vlayoutapplication.util.net.IneterCallBack;
import com.example.vlayoutapplication.util.net.UrlContstant;

public class HomePresenter extends BasePresenter<HomeContract.CHomeView> implements HomeContract.CHomePresenter {

    private final HomeModel homeModel;

    public HomePresenter(HomeContract.CHomeView cHomeModel) {
        this.homeModel =new HomeModel(this);
    }


    @Override
    public void Result() {
        homeModel.getData(UrlContstant.baseurl, new IneterCallBack<HomeBannerBean>() {
            @Override
            public void onInit(HomeBannerBean a) {
                HomeBannerBean.DataBean data = a.getData();
                iView.onInit(a);
            }

            @Override
            public void onError(String error) {

            }
        });
    }

}
