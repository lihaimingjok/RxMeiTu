package com.example.li.rxmeitu.Presenter;

import com.example.li.rxmeitu.UI.View.MvpView;

/**
 * Created by li on 2017/3/31.
 */
public interface Presenter<V extends MvpView> {
    void attachView(V mvpView);
    void detachView();
}
