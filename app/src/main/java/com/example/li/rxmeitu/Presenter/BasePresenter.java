package com.example.li.rxmeitu.Presenter;

import com.example.li.rxmeitu.UI.View.MvpView;

/**
 * Created by li on 2017/3/31.
 */
public class BasePresenter<T extends MvpView> implements Presenter<T> {
    private T mMvpView;
    @Override
    public void attachView(T mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }
    public boolean isViewAttach(){
        return  mMvpView!=null;
    }
    public T getMvpView(){
        return mMvpView;
    }
    public void checkViewAttached(){
        if(!isViewAttach())throw  new MvpViewNotAttachedException();
    }
    //自定义异常，精准定位
    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
