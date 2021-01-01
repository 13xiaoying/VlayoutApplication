package com.example.vlayoutapplication.model;

import com.example.vlayoutapplication.base.BaseModel;
import com.example.vlayoutapplication.bean.HomeBannerBean;
import com.example.vlayoutapplication.bean.SortBean;
import com.example.vlayoutapplication.contract.HomeContract;
import com.example.vlayoutapplication.contract.SortContract;
import com.example.vlayoutapplication.util.net.HomeRetrofitUrils;
import com.example.vlayoutapplication.util.net.IneterCallBack;
import com.example.vlayoutapplication.util.net.UrlContstant;

public class SortModel extends BaseModel implements SortContract.CSortModel{

    @Override
    public void getData(IneterCallBack<SortBean> callBack) {
        //网络请求
        HomeRetrofitUrils.getInstance().get(UrlContstant.sorturl,callBack);
        //RetrofitUrils.getInstance().post(url,callBack);
    }
}
