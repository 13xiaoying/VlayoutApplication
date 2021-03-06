package com.example.vlayoutapplication.presenter;

import android.util.Log;

import com.example.vlayoutapplication.base.BasePresenter;
import com.example.vlayoutapplication.base.BaseView;
import com.example.vlayoutapplication.bean.HomeBannerBean;
import com.example.vlayoutapplication.contract.HomeContract;
import com.example.vlayoutapplication.model.HomeModel;
import com.example.vlayoutapplication.util.net.IneterCallBack;

public class HomePresenter extends BasePresenter<HomeContract.CHomeView, HomeModel> implements HomeContract.CHomePresenter, BaseView {

    @Override
    public void Result() {
        model.getData(new IneterCallBack<HomeBannerBean>() {
            @Override
            public void onInit(HomeBannerBean a) {
                iView.onInit(a);
            }

            @Override
            public void onError(String error) {
                Log.i(TAG, "onError: home错误信息"+error);
            }
        });
    }

    private static final String TAG = "HomePresenter";

    @Override
    public HomeModel getModel() {
        return new HomeModel();
    }
}
