package com.example.kson.mvpbasedesign.contract.user;

import com.example.kson.base.base.mvp.BasePresenter;
import com.example.kson.base.base.mvp.IBaseModel;
import com.example.kson.base.base.mvp.IBaseView;
import com.example.kson.mvpbasedesign.entity.user.UploadEntity;
import com.example.kson.mvpbasedesign.model.UploadModel;

import java.io.File;

import io.reactivex.Observable;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/04
 * Description:
 */
public interface UploadContract {


     abstract class UploadPresenter extends BasePresenter<IUploadModel,IUploadView>{

        @Override
        public IUploadModel getmModel() {
            return new UploadModel();
        }
        public abstract void upload(String s, File file);
    }

    /**
     * model层接口
     */
    interface IUploadModel extends IBaseModel{

        Observable<UploadEntity> upload(String uid, File file);

    }

    /**
     * view层接口
     */
    interface IUploadView extends IBaseView{

        void success(UploadEntity uploadEntity);
        void fail(String msg);

    }
}
