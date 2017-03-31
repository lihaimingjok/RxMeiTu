package com.example.li.rxmeitu.UI.View;

import com.example.li.rxmeitu.Modle.JokeBean;

import java.util.List;

/**
 * Created by li on 2017/3/31.
 */
public interface JokeView extends MvpView {
    void refresh(List<JokeBean.ResultEntity.DataEntity> list);
    void loadMore(List<JokeBean.ResultEntity.DataEntity> list);
}
