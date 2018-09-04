package com.example.kson.mvpbasedesign;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kson.base.base.mvp.BaseMvpActivity;
import com.example.kson.base.base.mvp.BasePresenter;
import com.example.kson.mvpbasedesign.contract.user.UploadContract;
import com.example.kson.mvpbasedesign.entity.user.UploadEntity;
import com.example.kson.mvpbasedesign.presenter.UploadPresenter;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseMvpActivity<UploadContract.IUploadModel,UploadContract.UploadPresenter> implements UploadContract.IUploadView{


    @BindView(R.id.upload)
    Button upload;

    @Override
    protected void initData() {

    }

    @OnClick(R.id.upload)
    public void upload(View view){
        //上传头像
        File file = new File("");
        presenter.upload("71",file);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public BasePresenter initPresenter() {
        return new UploadPresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void success(UploadEntity uploadEntity) {
        showToast(uploadEntity.msg);
        startActivity(MainActivity.class);
//        Toast.makeText(this, uploadEntity.msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void fail(String msg) {

    }
}
