package com.example.li.rxmeitu.UI.View.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.li.rxmeitu.UI.View.MvpView;

/**
 * Created by li on 2017/3/31.
 */
public class BaseActivity extends AppCompatActivity implements MvpView {
    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg, View.OnClickListener onClickListener) {

    }

    @Override
    public void showEmpty(String msg, View.OnClickListener onClickListener) {

    }

    @Override
    public void showEmpty(String msg, View.OnClickListener onClickListener, int imageResId) {

    }

    @Override
    public void showNetError(View.OnClickListener onClickListener) {

    }
}
