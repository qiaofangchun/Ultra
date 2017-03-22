package com.ultra.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ultra.lifecycle.AndroidLifecycle;
import com.ultra.lifecycle.FragmentEvent;
import com.ultra.lifecycle.LifecycleProvider;
import com.ultra.lifecycle.LifecycleTransformer;
import com.ultra.lifecycle.RxLifecycle;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by Administrator on 2017/3/19 0019.
 */

public abstract class BaseFragment extends Fragment implements LifecycleProvider<FragmentEvent> {
    private View layout;
    protected Context context;
    private boolean isFirstLoad = true;
    private boolean isViewCreated = false;
    protected boolean isNeedInitView = false;

    private final BehaviorSubject<FragmentEvent> lifecycleSubject = BehaviorSubject.create();

    @Override
    @NonNull
    @CheckResult
    public final Observable<FragmentEvent> lifecycle() {
        return lifecycleSubject.hide();
    }

    @Override
    @NonNull
    @CheckResult
    public final <T> LifecycleTransformer<T> bindUntilEvent(@NonNull FragmentEvent event) {
        return RxLifecycle.bindUntilEvent(lifecycleSubject, event);
    }

    @Override
    @NonNull
    @CheckResult
    public final <T> LifecycleTransformer<T> bindToLifecycle() {
        return AndroidLifecycle.bindFragment(lifecycleSubject);
    }

    @Override
    @CallSuper
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context != null) {
            this.context = context;
        } else {
            this.context = getActivity();
        }
        lifecycleSubject.onNext(FragmentEvent.ATTACH);
    }

    @Override
    @CallSuper
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lifecycleSubject.onNext(FragmentEvent.CREATE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (layout == null) {
            layout = getLayoutView(inflater, container);
        }
        ViewGroup parent = (ViewGroup) layout.getParent();
        if (parent != null) {
            parent.removeView(layout);
        }
        return layout;
    }

    protected abstract View getLayoutView(LayoutInflater inflater, ViewGroup container);

    @Override
    @CallSuper
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lifecycleSubject.onNext(FragmentEvent.CREATE_VIEW);
        isViewCreated = true;
        if (isNeedInitView) {
            onCreatedView();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isFirstLoad) {
            if (isViewCreated) {
                isFirstLoad = false;
                onCreatedView();
            } else {
                isNeedInitView = true;
            }
        }
    }

    protected abstract void onCreatedView();

    @Override
    @CallSuper
    public void onStart() {
        super.onStart();
        lifecycleSubject.onNext(FragmentEvent.START);
    }

    @Override
    @CallSuper
    public void onResume() {
        super.onResume();
        lifecycleSubject.onNext(FragmentEvent.RESUME);
    }

    @Override
    @CallSuper
    public void onPause() {
        lifecycleSubject.onNext(FragmentEvent.PAUSE);
        super.onPause();
    }

    @Override
    @CallSuper
    public void onStop() {
        lifecycleSubject.onNext(FragmentEvent.STOP);
        super.onStop();
    }

    @Override
    @CallSuper
    public void onDestroyView() {
        lifecycleSubject.onNext(FragmentEvent.DESTROY_VIEW);
        super.onDestroyView();
    }

    @Override
    @CallSuper
    public void onDestroy() {
        lifecycleSubject.onNext(FragmentEvent.DESTROY);
        super.onDestroy();
    }

    @Override
    @CallSuper
    public void onDetach() {
        lifecycleSubject.onNext(FragmentEvent.DETACH);
        super.onDetach();
    }
}