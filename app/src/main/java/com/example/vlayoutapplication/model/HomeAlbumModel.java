package com.example.vlayoutapplication.model;

import com.example.vlayoutapplication.contract.HomeContract;
import com.example.vlayoutapplication.util.net.IneterCallBack;
import com.example.vlayoutapplication.util.net.RetrofitUrils;

public class HomeAlbumModel implements HomeContract.CHomeModel {
    private HomeContract.CHomePresenter presenter;

    public HomeAlbumModel(HomeContract.CHomePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void getData(String url, IneterCallBack<T> callBack) {
        RetrofitUrils.getInstance().get(url,callBack);
    }
}
