package com.example.vlayoutapplication.base;

import android.view.View;

public class BasePresenter<T extends BaseView> {
    public T iView;
    public void attachView(T v) {
        iView=v;
    }
}
