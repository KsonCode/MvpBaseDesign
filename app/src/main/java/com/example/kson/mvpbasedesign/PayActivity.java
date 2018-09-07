package com.example.kson.mvpbasedesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.example.kson.base.base.mvp.BaseMvpActivity;
import com.example.kson.base.net.RetrofitUtils;
import com.example.kson.mvpbasedesign.api.PayApi;
import com.example.kson.mvpbasedesign.common.Contants;
import com.example.kson.mvpbasedesign.utils.PayResult;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PayActivity extends AppCompatActivity {

    @BindView(R.id.alipayBtn)
    Button payBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
    }

    @OnClick(R.id.alipayBtn)
    public void pay(View view){
        //1.通过订单id，orderid请求接口，paytype=2，获取签名后的订单信息
        final Map<String,String> params = new HashMap<>();
        params.put("payType","2");
        params.put("orderId","3232323232323232323");
        RetrofitUtils.getInstance().createApi(Contants.BASE_RELEASE_URL, PayApi.class)
                .pay(params).subscribeOn(Schedulers.io()).observeOn(Schedulers.newThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        //2.字符串
                        String orderInfo = s;
                        PayTask payTask = new PayTask(PayActivity.this);
                        //同步请求支付
                        Map<String, String> result =  payTask.payV2(orderInfo,true);

                        //解析map的result
                        PayResult payResult = new PayResult(result);
                        String status = payResult.getResultStatus();
                        String  payresult = payResult.getResult();

                        //演示支付成功，非正常逻辑
                        if (status.equals("9000")){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(PayActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }




                    }
                });


    }
}
