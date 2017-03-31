package com.example.li.rxmeitu.Api;

import com.example.li.rxmeitu.Modle.JokeBean;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by li on 2017/3/31.
 */
public interface Api {
    @GET("joke/content/text.from")
    Observable<JokeBean> getJokeBean(@Query("page") int page, @Query("pagesize") int pagesize, @Query("key") String key);
}
