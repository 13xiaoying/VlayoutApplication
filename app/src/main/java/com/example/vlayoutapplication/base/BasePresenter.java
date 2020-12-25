package com.example.vlayoutapplication.base;

public class BasePresenter<T> {
    public T iView;
    public void attachView(T v) {
        iView=v;
    }
}
