package com.example.vlayoutapplication.presenter;

import android.util.Log;

import com.example.vlayoutapplication.base.BasePresenter;
import com.example.vlayoutapplication.base.BaseView;
import com.example.vlayoutapplication.bean.AlbumBean;
import com.example.vlayoutapplication.contract.AlbumContract;
import com.example.vlayoutapplication.model.AlbumModel;
import com.example.vlayoutapplication.util.net.IneterCallBack;

public class AlbumPresenter extends BasePresenter<AlbumContract.CAlbumView, AlbumModel> implements AlbumContract.CAlbumPresenter, BaseView {

    @Override
    public void Result() {
        model.getData(new IneterCallBack<AlbumBean>() {
            @Override
            public void onInit(AlbumBean a) {
                iView.onInit(a);
            }

            @Override
            public void onError(String error) {
                Log.i(TAG, "onError: Album错误信息"+error);
            }
        });
    }

    private static final String TAG = "AlbumPresenter";

    @Override
    public AlbumModel getModel() {
        return new AlbumModel();
    }
}
