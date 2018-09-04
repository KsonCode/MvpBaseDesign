package com.example.kson.base.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/04
 * Description:网络框架二次封装
 */
public class RetrofitUtils {

    private static volatile RetrofitUtils retrofitUtils;
    private OkHttpClient okHttpClient = null;

    private RetrofitUtils() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();


    }

    public <T> T createApi(String baseurl,Class<T> clz){
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseurl).build();

//        UserApi userApi = retrofit.create(UserApi.class);

        return retrofit.create(clz);


    }

    /**
     * 双重检验锁，同步锁
     *
     * @return
     */
    public static RetrofitUtils getInstance() {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (retrofitUtils == null) {
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }


}
