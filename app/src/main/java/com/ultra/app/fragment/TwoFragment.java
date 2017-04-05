package com.ultra.app.fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ultra.app.R;
import com.ultra.base.BaseFragment;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by qiaofc on 2017/3/20 0020.
 */

public class TwoFragment extends BaseFragment {
    @Override
    protected void onCreatedView() {
        Log.e("qfc", "2------>初始化数据");

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("第一次发送数据");
                e.onNext("第二次发送数据");
                e.onNext("第三次发送数据");
                Log.e("qfc", "-------------->数据发送线程：" + Thread.currentThread());
                Log.e("qfc", "-------------->数据发送完毕");
                e.onComplete();
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.e("qfc", "-------------->接收到数据线程：" + Thread.currentThread());
                Log.e("qfc", "-------------->接收到数据：" + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    @Override
    protected View getLayoutView(LayoutInflater inflater, ViewGroup container) {
        Log.e("qfc", "2------>创建View");
        return inflater.inflate(R.layout.fragment_two, container, false);
    }
}