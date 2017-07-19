package com.ultra.adapter;

import android.support.annotation.NonNull;

import java.util.Arrays;

/**
 * @author drakeet
 */
final class ClassLinkerWrapper<T> implements ItemViewLinker<T> {
    @NonNull
    private final OneToManyLinker<T> classLinker;
    @NonNull
    private ItemViewBinder<T, ?>[] binders;

    private ClassLinkerWrapper(
            @NonNull OneToManyLinker<T> classLinker,
            @NonNull ItemViewBinder<T, ?>[] binders) {
        this.classLinker = classLinker;
        this.binders = binders;
    }

    @NonNull
    static <T> ClassLinkerWrapper<T> wrap(
            @NonNull OneToManyLinker<T> classLinker,
            @NonNull ItemViewBinder<T, ?>[] binders) {
        return new ClassLinkerWrapper<T>(classLinker, binders);
    }

    @Override
    public int index(@NonNull T t) {
        Class<?> userIndexClass = classLinker.index(t);
        for (int i = 0; i < binders.length; i++) {
            if (binders[i].getClass().equals(userIndexClass)) {
                return i;
            }
        }
        throw new IndexOutOfBoundsException(
                String.format("%s is out of your registered binders'(%s) bounds.",
                        userIndexClass.getName(), Arrays.toString(binders))
        );
    }
}
