package com.example.vlayoutapplication.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel implements IBaseModel{
    CompositeDisposable disposableSet=new CompositeDisposable();

    @Override
    public void addDIsposable(Disposable disposable) {
        disposableSet.add(disposable);
    }

    @Override
    public void clear() {
        disposableSet.clear();
    }
}
