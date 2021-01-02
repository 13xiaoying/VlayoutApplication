package com.example.vlayoutapplication.contract;

import com.example.vlayoutapplication.base.BaseView;
import com.example.vlayoutapplication.base.IBaseModel;
import com.example.vlayoutapplication.bean.AlbumBean;
import com.example.vlayoutapplication.util.net.IneterCallBack;

public class AlbumContract {
    public interface CAlbumModel extends IBaseModel {
         void getData(IneterCallBack<AlbumBean> callBack);
    }

    public interface CAlbumPresenter {
        void Result();
    }

    public interface CAlbumView extends BaseView{
        void onInit(AlbumBean bean);
        void onError(String error);
    }
}
