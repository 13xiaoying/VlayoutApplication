package com.example.vlayoutapplication.util.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUrils implements InterWorkInterface {
    public static RetrofitUrils retrofitUrils;

    public RetrofitUrils(){
        Retrofit build = new Retrofit.Builder()
                .baseUrl(UrlContstant)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    @Override
    public <T> void get(String url, IneterCallBack<T> callBack) {

    }

    @Override
    public <T> void post(String url, IneterCallBack<T> callBack) {

    }
}
