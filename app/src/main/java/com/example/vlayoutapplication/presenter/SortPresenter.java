package com.example.vlayoutapplication.presenter;

import android.util.Log;

import com.example.vlayoutapplication.base.BasePresenter;
import com.example.vlayoutapplication.base.BaseView;
import com.example.vlayoutapplication.bean.HomeBannerBean;
import com.example.vlayoutapplication.bean.SortBean;
import com.example.vlayoutapplication.contract.HomeContract;
import com.example.vlayoutapplication.contract.SortContract;
import com.example.vlayoutapplication.model.HomeModel;
import com.example.vlayoutapplication.model.SortModel;
import com.example.vlayoutapplication.util.net.IneterCallBack;
import com.example.vlayoutapplication.util.net.UrlContstant;

public class SortPresenter extends BasePresenter<SortContract.CSortView, SortModel> implements SortContract.CSortPresenter, BaseView {
    @Override
    public void Result(int id) {
        model.getData(id,new IneterCallBack<SortBean>() {
            @Override
            public void onInit(SortBean a) {
                iView.onInit(a);
            }

            @Override
            public void onError(String error) {

            }
        });
    }

    private static final String TAG = "SortPresenter";

    @Override
    public SortModel getModel() {
        return new SortModel();
    }
}
