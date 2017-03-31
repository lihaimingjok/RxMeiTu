package com.example.li.rxmeitu.Api;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by li on 2017/3/31.
 */
public class ApiService {
    private static OkHttpClient okHttpClient = new OkHttpClient.Builder().
            addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build();
    private static Retrofit retrofit  = new Retrofit.Builder()
            .baseUrl("http://japi.juhe.cn/")
            .client(okHttpClient)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private ApiService(){

    }
    public static <T> T createApi(Class<T> clazz) {

        return retrofit.create(clazz);
    }
}
