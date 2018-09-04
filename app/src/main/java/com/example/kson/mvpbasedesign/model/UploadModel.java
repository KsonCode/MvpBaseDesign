package com.example.kson.mvpbasedesign.model;

import com.example.kson.base.net.RetrofitUtils;
import com.example.kson.mvpbasedesign.api.UserApi;
import com.example.kson.mvpbasedesign.common.Contants;
import com.example.kson.mvpbasedesign.contract.user.UploadContract;
import com.example.kson.mvpbasedesign.entity.user.UploadEntity;

import java.io.File;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/04
 * Description:
 */
public class UploadModel implements UploadContract.IUploadModel {

    @Override
    public Observable<UploadEntity> upload(String uid, File file) {
        //f为file路径,三个参数：文件的key，文件名字，key所对应的文件请求体，类型是：流application/octet-stream
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(
                MediaType.parse("application/octet-stream"), file));//image/*

//        UserApi userApi = RetrofitUtils.getInstance().createApi(Contants.BASE_RELEASE_URL, UserApi.class);
//        //第二种方式  上传头像
//        Observable<UploadEntity> upload = userApi.upload2("10134", filePart);

        return RetrofitUtils.getInstance().createApi(Contants.BASE_RELEASE_URL, UserApi.class)
                .upload2(uid, filePart).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
