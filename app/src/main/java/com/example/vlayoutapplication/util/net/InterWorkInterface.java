package com.example.vlayoutapplication.util.net;

public interface InterWorkInterface {
    public <T> void get(String url, IneterCallBack<T> callBack);

    public <T> void post(String url, IneterCallBack<T> callBack);
}
