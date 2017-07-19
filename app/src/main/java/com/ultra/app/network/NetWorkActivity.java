package com.ultra.app.network;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ultra.app.R;
import com.ultra.base.BaseActivity;
import com.ultra.lifecycle.ActivityEvent;
import com.ultra.network.HttpClient;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;

public class NetWorkActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_work);
        initNetWrok();
    }

    private void initNetWrok() {
        Log.e("qfc", "start init network tools---->" + System.currentTimeMillis());
        HttpClient httpClient = new HttpClient.Builder()
                .baseUrl("http://www.jianshu.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Log.e("qfc", "start request network---->" + System.currentTimeMillis());
        httpClient.create(Api.class).getNetData()
                .delay(2,TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .compose(this.<String>bindUntilEvent(ActivityEvent.DESTROY))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        Toast.makeText(NetWorkActivity.this,s,Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Toast.makeText(NetWorkActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private interface Api {
        @GET("http://www.jianshu.com/p/11235e7bcd8e")
        Observable<String> getNetData();
    }
}
