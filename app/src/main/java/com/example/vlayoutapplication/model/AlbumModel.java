package com.example.vlayoutapplication.model;

import com.example.vlayoutapplication.base.BaseModel;
import com.example.vlayoutapplication.bean.AlbumBean;
import com.example.vlayoutapplication.bean.SortBean;
import com.example.vlayoutapplication.contract.AlbumContract;
import com.example.vlayoutapplication.contract.SortContract;
import com.example.vlayoutapplication.util.net.AlbumRetrofitUrils;
import com.example.vlayoutapplication.util.net.IneterCallBack;
import com.example.vlayoutapplication.util.net.SortRetrofitUrils;
import com.example.vlayoutapplication.util.net.UrlContstant;

public class AlbumModel extends BaseModel implements AlbumContract.CAlbumModel{

    @Override
    public void getData(IneterCallBack<AlbumBean> callBack) {
        AlbumRetrofitUrils.getInstance().get(UrlContstant.,callBack);
    }
}
