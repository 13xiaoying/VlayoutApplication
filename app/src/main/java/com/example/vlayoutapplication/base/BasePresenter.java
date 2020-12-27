package com.example.vlayoutapplication.base;

import android.view.View;

public abstract class BasePresenter<T extends BaseView,M extends IBaseModel> {
    public T iView;
    public M model;
    public void attachView(T v) {
        iView=v;
        model=getModel();
    }
    public abstract M getModel();
    public void detchView(){
        if(iView!=null){
            iView=null;
            model=null;
        }
    }
}
