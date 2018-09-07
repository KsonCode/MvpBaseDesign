package com.example.kson.mvpbasedesign.api;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/07
 * Description:
 */
public interface PayApi {
    @POST("movieApi/movie/v1/verify/pay")
    @FormUrlEncoded
    Observable<String> pay(@FieldMap Map<String,String> params);
}
