package com.example.kson.mvpbasedesign.api;

import com.example.kson.mvpbasedesign.entity.user.UploadEntity;
import com.example.kson.mvpbasedesign.entity.user.UserEntity;

import java.io.File;
import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/04
 * Description:
 */
public interface UserApi {
    @POST("file/upload")
    @Headers({"Cache-Control: max-age=560000","Accept: text/html","token: xxxxxxxxxxxxxxxx"})
    @Multipart
    Observable<UploadEntity> upload(String uid, File file);

    //第一种方式上传头像
    @POST("file/upload")
    @Multipart
    Observable<UploadEntity> upload(@Part("uid") RequestBody uid, @Part MultipartBody.Part file);


    //第二种方式上传头像
    @POST("file/upload")
    @Multipart
    Observable<UploadEntity> upload2(@Query("uid") String uid, @Part MultipartBody.Part file);


//    @GET("product?pid=1")//普通接口设计风格
    @GET("product/{pid}/{name}")
    Call<ResponseBody> getBookDetails(@Path("pid") int id,@Path("productName") String name);

    @GET("user/login")
    Call<RequestBody> get(@Query("mobile") String str);

    @GET
    Call<RequestBody> get2(@Url String url,@Query("mobile") String str,@Query("password") String pwd);



    @POST("user/reg")
    @FormUrlEncoded
    Observable<UserEntity> reg(@FieldMap HashMap<String,String> params);

}
