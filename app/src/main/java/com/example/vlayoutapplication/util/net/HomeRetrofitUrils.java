package com.example.vlayoutapplication.util.net;

import com.example.vlayoutapplication.Api.ApiServer;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class HomeRetrofitUrils implements InterWorkInterface {
    public static HomeRetrofitUrils homeRetrofitUrils;
    private final ApiServer apiServer;

    public HomeRetrofitUrils() {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(UrlContstant.baseurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiServer = build.create(ApiServer.class);
    }

    public static HomeRetrofitUrils getInstance() {
        if (homeRetrofitUrils == null) {
            synchronized (HomeRetrofitUrils.class) {
                if (homeRetrofitUrils == null) {
                    homeRetrofitUrils = new HomeRetrofitUrils();
                }
            }
        }
        return homeRetrofitUrils;
    }


    @Override
    public <T> void get(String url, final IneterCallBack<T> callBack) {
        apiServer.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type = actualTypeArguments[0];
                            Gson gson = new Gson();
                            T json = gson.fromJson(string, type);
                            callBack.onInit(json);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <T> void post(String url, final IneterCallBack<T> callBack) {
        apiServer.post(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type = actualTypeArguments[0];
                            Gson gson = new Gson();
                            T json = gson.fromJson(string, type);
                            callBack.onInit(json);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
