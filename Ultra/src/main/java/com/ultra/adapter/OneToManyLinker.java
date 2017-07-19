package com.ultra.adapter;

import android.support.annotation.NonNull;

/**
 * An interface to link the items and binders by the classes of binders.
 *
 * @author drakeet
 */
public interface OneToManyLinker<T> {

    /**
     * Returns the class of your registered binders for your item.
     *
     * @param t Your item data
     * @return The index of your registered binders
     * @see OneToManyEndpoint#withClassLinker(OneToManyLinker)
     */
    @NonNull
    Class<? extends ItemViewBinder<T, ?>> index(@NonNull T t);
}