package com.example.vlayoutapplication.util.net;

public interface IneterCallBack<T> {
    void onInit(T a);
    void onError(String error);
}
