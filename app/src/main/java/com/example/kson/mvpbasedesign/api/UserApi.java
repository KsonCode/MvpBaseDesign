package com.example.kson.mvpbasedesign.api;

import com.example.kson.mvpbasedesign.entity.user.UploadEntity;

import java.io.File;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/04
 * Description:
 */
public interface UserApi {
    @POST("file/upload")
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
}
