package com.example.vlayoutapplication.contract;

import com.example.vlayoutapplication.base.BaseModel;
import com.example.vlayoutapplication.base.BaseView;
import com.example.vlayoutapplication.bean.HomeBannerBean;
import com.example.vlayoutapplication.util.net.IneterCallBack;

public class HomeContract {
    public interface HomeModel extends BaseModel {
        <T> void getData(String url, IneterCallBack<T> callBack);
    }

    public interface HomePresenter {
        void Result(String s);
    }

    public interface HomeView extends BaseView{
        void getInit(HomeBannerBean bean);
        void getError(String error);
    }
}
