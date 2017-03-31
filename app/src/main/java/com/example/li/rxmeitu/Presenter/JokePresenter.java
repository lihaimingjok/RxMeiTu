package com.example.li.rxmeitu.Presenter;

import com.example.li.rxmeitu.Api.Api;
import com.example.li.rxmeitu.Api.ApiService;
import com.example.li.rxmeitu.Modle.JokeBean;
import com.example.li.rxmeitu.UI.View.JokeView;
import com.orhanobut.logger.Logger;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by li on 2017/3/31.
 */
public class JokePresenter extends BasePresenter<JokeView> {
    @Override
    public void attachView(JokeView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }
    public void loadList(final int page,final int pagesize,final String key){
            ApiService.createApi(Api.class)
                    .getJokeBean(page,pagesize,key)
                    .subscribeOn(Schedulers.io())
                    .map(new Func1<JokeBean, List<JokeBean.ResultEntity.DataEntity>>() {
                        @Override
                        public List<JokeBean.ResultEntity.DataEntity> call(JokeBean jokeBean) {
                            return jokeBean.getResult().getData();
                        }
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<List<JokeBean.ResultEntity.DataEntity>>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            Logger.e(e.getMessage());
                            getMvpView().showEmpty(null,null);
                        }

                        @Override
                        public void onNext(List<JokeBean.ResultEntity.DataEntity> dataEntities) {
                            if(page==1){
                                getMvpView().refresh(dataEntities);
                            }else{
                                getMvpView().loadMore(dataEntities);
                            }
                        }
                    });

    }
}
