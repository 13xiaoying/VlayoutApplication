package com.example.vlayoutapplication.presenter;

import com.example.vlayoutapplication.base.BasePresenter;
import com.example.vlayoutapplication.bean.HomeBannerBean;
import com.example.vlayoutapplication.contract.HomeContract;
import com.example.vlayoutapplication.model.HomeBannerModel;
import com.example.vlayoutapplication.util.net.IneterCallBack;
import com.example.vlayoutapplication.util.net.UrlContstant;

public class HomeBannerPresenter extends BasePresenter<HomeContract.CHomeView> implements HomeContract.CHomePresenter {

    private final HomeBannerModel homeBannerModel;

    public HomeBannerPresenter(HomeContract.CHomeView cHomeModel) {
        this.homeBannerModel =new HomeBannerModel(this);
    }


    @Override
    public void Result() {
        homeBannerModel.getData(UrlContstant.bannerurl, new IneterCallBack<HomeBannerBean>() {
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
