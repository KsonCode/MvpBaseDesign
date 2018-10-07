package com.example.kson.mvpbasedesign;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kson.base.base.mvp.BaseMvpActivity;
import com.example.kson.base.base.mvp.BasePresenter;
import com.example.kson.base.net.RetrofitUtils;
import com.example.kson.mvpbasedesign.api.UserApi;
import com.example.kson.mvpbasedesign.common.Contants;
import com.example.kson.mvpbasedesign.contract.user.UploadContract;
import com.example.kson.mvpbasedesign.entity.user.UploadEntity;
import com.example.kson.mvpbasedesign.entity.user.UserEntity;
import com.example.kson.mvpbasedesign.presenter.UploadPresenter;
import com.jakewharton.rxbinding2.view.RxView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseMvpActivity<UploadContract.IUploadModel, UploadContract.UploadPresenter> implements UploadContract.IUploadView {


    long time = 1000 * 60 * 60 * 2;//服务器返回的毫秒数
    @BindView(R.id.upload)
    Button upload;
    @BindView(R.id.time_tv)
    TextView mTimeTv;
    @BindView(R.id.moreClick)
    Button moreclick;

    private List<String> list;

    @Override
    protected void initData() {
        super.initData();
        list = new ArrayList<>();
        System.out.println(android.util.Base64.encodeToString("123456".getBytes(), android.util.Base64.DEFAULT));

        //developer
    }

    /**
     * 倒计时功能
     */
    private void time() {

//        Observable.interval(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Long>() {
//            @Override
//            public void accept(Long aLong) throws Exception {
//                System.out.println("long:"+aLong);
//                time -= 1000;
//                timeFormat(aLong);
//
//                RetrofitUtils.getInstance().createApi(Contants.BASE_RELEASE_URL,UserApi.class)
//                        .upload2("",new File("")).subscribe(new Consumer<UploadEntity>() {
//                    @Override
//                    public void accept(UploadEntity uploadEntity) throws Exception {
//                        System.out.println();
//                    }
//                });
//            }
//        });
    }

    /**
     * 把毫秒数，转换成时间格式
     *
     * @param aLong
     */
    private void timeFormat(Long aLong) {

        System.out.println("time:" + time);

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");//初始化Formatter的转换格式。

        String hms = formatter.format(time);

        mTimeTv.setText(hms);
    }

    @OnClick(R.id.upload)
    public void upload(View view) {
        System.out.println("presenter：" + presenter);

        //上传头像
//        File file = new File("");
//        presenter.upload("71",file);

    }

    @OnClick({R.id.moreClick})
    public void setMoreclick(View view) {
        RxView.clicks(moreclick).throttleFirst(6, TimeUnit.SECONDS)
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Object o) {



                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

//        HashMap<String, String> p = new HashMap<>();
//        p.put("mobile", "18612991023");
//        p.put("password", "222222");
//        RetrofitUtils.getInstance().createApi(Contants.BASE_RELEASE_URL, UserApi.class)
//                .reg(p).throttleFirst(5,TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<UserEntity>() {
//            @Override
//            public void accept(UserEntity userEntity) throws Exception {
//
//                System.out.println("msg:" + userEntity.msg);
//
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//
//            }
//        });

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
