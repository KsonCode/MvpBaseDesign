package com.example.kson.mvpbasedesign.presenter;

import com.example.kson.mvpbasedesign.contract.user.UploadContract;
import com.example.kson.mvpbasedesign.entity.user.UploadEntity;

import java.io.File;

import io.reactivex.functions.Consumer;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/04
 * Description:
 */
public class UploadPresenter extends UploadContract.UploadPresenter {
    @Override
    public void upload(String s, File file) {
        //subcribeon,被观察者发射事件的线程，网络请求过程中，指的是被观察者对象（请求网络的对象）的线程
        //observeon,观察者接收事件的线程，也就是得到响应的线程
        mModel.upload(s,file).subscribe(new Consumer<UploadEntity>() {
            @Override
            public void accept(UploadEntity uploadEntity) throws Exception {
                mView.success(uploadEntity);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

                mView.fail("网络有问题，请稍后再试");
            }
        });;
    }
}
