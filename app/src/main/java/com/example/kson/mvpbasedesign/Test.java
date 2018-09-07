package com.example.kson.mvpbasedesign;


import com.example.kson.mvpbasedesign.entity.user.UploadEntity;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/05
 * Description:
 */
public class Test {
    public static void main(String[] a){
//        //1.observable,创建操作符
//        Observable observable = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter emitter) throws Exception {
//
//                emitter.onNext(2);
//                emitter.onNext(6);
//                emitter.onNext(7);
//                emitter.onComplete();
//                System.out.println("thread1:"+Thread.currentThread().getName());
//            }
//        });
//
//        observable.subscribeOn(Schedulers.io()).observeOn(Schedulers.newThread());
//
//
//        Observer<Integer> observer = new Observer<Integer>() {
//            int i = 0;
//            Disposable disposable;
//            @Override
//            public void onSubscribe(Disposable d) {
//
//                disposable = d;
//                System.out.println("boolean:"+disposable.isDisposed());
//
//
//
//
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                i++;
//                if (i==1){
//                    disposable.dispose();
//                }
//                System.out.println(integer);
//                System.out.println("thread2:"+Thread.currentThread().getName());
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };
//
//        //订阅
//        observable.subscribe(observer);

//        Observable<String> just = Observable.just("1", "2", "3");
////        UploadEntity[] uploadEntities = {new UploadEntity(),new UploadEntity()};
//
//        Observer<String> observer = new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                System.out.println(s);
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };
//        just.subscribe(observer);
//
//        //数组的创建操作符
//        Integer[] integers = {1,2,3,4,5,6};
//        Observable.fromArray(integers,integers).subscribe(new Consumer<Integer[]>() {
//            @Override
//            public void accept(Integer[] integers) throws Exception {
//
//                for (Integer integer : integers) {
//                    System.out.println(integer);
//                }
////                System.out.println(integers);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//
//            }
//        });
//
//        //集合创建操作符
//        Observable.fromIterable(new ArrayList<String>()).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//
//            }
//        });


        //延时发送0事件，收到后处理相关逻辑
//        Observable.timer(2, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Long aLong) {
//
//                System.out.println(aLong);
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });

        //轮询机制
//        Observable.interval(3,TimeUnit.SECONDS).subscribe(new Observer<Long>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Long aLong) {
//
//                System.out.println(aLong);
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });

//        Observable.create(new ObservableOnSubscribe<Integer>() {
//
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                emitter.onNext(1);
//                emitter.onNext(1);
//                emitter.onNext(1);
//                emitter.onNext(5);
//            }
//        }).map(new Function<Integer, String>() {
//
//            @Override
//            public String apply(Integer integer) throws Exception {
//                //
//                //
//
//                return integer.toString();
//            }
//        }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                System.out.println(s);
//            }
//        });


        Observable.create(new ObservableOnSubscribe<Integer>() {

            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                Thread.sleep(100);
                emitter.onNext(2);
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                //根据业务需求，返回响应的类型
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 2; i++) {
                    list.add(integer+"");
                }
                return Observable.fromIterable(list);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });



        toBase64("nigneongeiogneongeingiengeongoe");
    }


    public static void toBase64(String msg){
        System.out.println(android.util.Base64.encode(msg.getBytes(), android.util.Base64.DEFAULT));
    }









}
