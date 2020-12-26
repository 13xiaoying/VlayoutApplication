package com.example.vlayoutapplication.base;

import io.reactivex.disposables.Disposable;

public interface IBaseModel {
    void addDIsposable(Disposable disposable);
    void clear();
}
