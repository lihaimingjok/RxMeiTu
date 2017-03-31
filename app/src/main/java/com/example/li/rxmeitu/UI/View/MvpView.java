package com.example.li.rxmeitu.UI.View;

import android.view.View;

/**
 * Created by li on 2017/3/31.
 */
public interface  MvpView {
    //正在加载
    void showLoading(String msg);
    //隐藏正在加载
    void hideLoading();
    //加载错误
    void showError(String msg, View.OnClickListener onClickListener);
    //加载数据为空
    void showEmpty(String msg, View.OnClickListener onClickListener);
    //加载数据为空
    void showEmpty(String msg,View.OnClickListener onClickListener,int imageResId);
    //网络错误
    void showNetError(View.OnClickListener onClickListener);
}
