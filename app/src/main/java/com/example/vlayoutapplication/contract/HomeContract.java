package com.example.vlayoutapplication.contract;

import com.example.vlayoutapplication.base.BaseView;
import com.example.vlayoutapplication.base.IBaseModel;
import com.example.vlayoutapplication.bean.HomeBannerBean;
import com.example.vlayoutapplication.util.net.IneterCallBack;

public class HomeContract {
    public interface CHomeModel extends IBaseModel {
         void getData(IneterCallBack<HomeBannerBean> callBack);
    }

    public interface CHomePresenter {
        void Result();
    }

    public interface CHomeView extends BaseView{
        void onInit(HomeBannerBean bean);
        void onError(String error);
    }
}
