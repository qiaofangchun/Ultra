package com.ultra.app.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ultra.app.NetWorkActivity;
import com.ultra.app.R;
import com.ultra.base.BaseFragment;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by qiaofc on 2017/3/20 0020.
 */

public class OneFragment extends BaseFragment {
    @Override
    protected void onCreatedView() {
        Log.e("qfc", "1------>初始化数据");
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.e("qfc", "emit 1");
                Log.e("qfc", "Observable thread is : " + Thread.currentThread().getName());
                emitter.onNext(1);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e("qfc", "onNext 1");
                        Log.e("qfc", "Observable thread is : " + Thread.currentThread().getName());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void click(View view) {
        Intent intent = new Intent(getActivity(), NetWorkActivity.class);
        startActivity(intent);
    }

    @Override
    protected View getLayoutView(LayoutInflater inflater, ViewGroup container) {
        Log.e("qfc", "1------>创建View");
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        view.findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(v);
            }
        });
        return view;
    }
}
