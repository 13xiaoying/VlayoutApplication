package com.example.vlayoutapplication.model;

import com.example.vlayoutapplication.base.BaseModel;
import com.example.vlayoutapplication.bean.HomeBannerBean;
import com.example.vlayoutapplication.contract.HomeContract;
import com.example.vlayoutapplication.util.net.IneterCallBack;
import com.example.vlayoutapplication.util.net.HomeRetrofitUrils;
import com.example.vlayoutapplication.util.net.UrlContstant;

public class HomeModel extends BaseModel implements HomeContract.CHomeModel{
    @Override
    public void getData( IneterCallBack<HomeBannerBean> callBack) {
        //网络请求
        HomeRetrofitUrils.getInstance().get(UrlContstant.baseurl,callBack);
        //RetrofitUrils.getInstance().post(url,callBack);
    }

}
