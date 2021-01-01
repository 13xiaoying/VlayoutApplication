package com.example.vlayoutapplication.contract;

import com.example.vlayoutapplication.base.BaseView;
import com.example.vlayoutapplication.base.IBaseModel;
import com.example.vlayoutapplication.bean.HomeBannerBean;
import com.example.vlayoutapplication.bean.SortBean;
import com.example.vlayoutapplication.util.net.IneterCallBack;

public class SortContract {
    public interface CSortModel extends IBaseModel {
         void getData(IneterCallBack<SortBean> callBack);
    }

    public interface CSortPresenter {
        void Result();
    }

    public interface CSortView extends BaseView{
        void onInit(SortBean bean);
        void onError(String error);
    }
}
