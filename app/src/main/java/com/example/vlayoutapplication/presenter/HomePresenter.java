package com.example.vlayoutapplication.presenter;

import android.util.Log;

import com.example.vlayoutapplication.base.BasePresenter;
import com.example.vlayoutapplication.base.BaseView;
import com.example.vlayoutapplication.base.IBaseModel;
import com.example.vlayoutapplication.bean.HomeBannerBean;
import com.example.vlayoutapplication.contract.HomeContract;
import com.example.vlayoutapplication.model.HomeBannerModel;
import com.example.vlayoutapplication.util.net.IneterCallBack;
import com.example.vlayoutapplication.util.net.UrlContstant;

public class HomePresenter extends BasePresenter<HomeContract.CHomeView,HomeBannerModel> implements HomeContract.CHomePresenter, BaseView {


    @Override
    public void Result() {
        model.getData(new IneterCallBack<HomeBannerBean>() {
            @Override
            public void onInit(HomeBannerBean a) {
                iView.onInit(a);
            }

            @Override
            public void onError(String error) {
                Log.i(TAG, "onError: 错误信息"+error);
            }
        });
    }

    private static final String TAG = "HomePresenter";

    @Override
    public HomeBannerModel getModel() {
        return new HomeBannerModel();
    }
}
