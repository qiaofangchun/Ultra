package com.ultra.adapter;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

/**
 * An interface to link the items and binders by array integer index.
 *
 * @author drakeet
 */
public interface ItemViewLinker<T> {

    /**
     * Returns the index of your registered binders for your item. The result should be in range of
     * {@code [0, one-to-multiple-binders.length)}.
     * <p>
     * <p>Note: The argument of {@link OneToManyFlow#to(ItemViewBinder[])} is the
     * one-to-multiple-binders.</p>
     *
     * @param t Your item data
     * @return The index of your registered binders
     * @see OneToManyFlow#to(ItemViewBinder[])
     * @see OneToManyEndpoint#withLinker(ItemViewLinker)
     */
    @IntRange(from = 0)
    int index(@NonNull T t);
}
