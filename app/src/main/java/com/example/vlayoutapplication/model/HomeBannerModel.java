package com.example.vlayoutapplication.model;

import com.example.vlayoutapplication.contract.HomeContract;
import com.example.vlayoutapplication.util.net.IneterCallBack;
import com.example.vlayoutapplication.util.net.RetrofitUrils;

public class HomeBannerModel implements HomeContract.CHomeModel{
    public HomeContract.CHomePresenter presenter;

    public HomeBannerModel(HomeContract.CHomePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void getData(String url, IneterCallBack<T> callBack) {
        //网络请求
        RetrofitUrils.getInstance().get(url,callBack);
        //RetrofitUrils.getInstance().post(url,callBack);
    }
}
