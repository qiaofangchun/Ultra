package com.ultra.adapter;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A convenient class for creating a {@code ArrayList<Object>}.
 *
 * @author drakeet
 */
public class DataCollection<T> extends ArrayList<T> {

    /**
     * Constructs an empty Items with an initial capacity of ten.
     */
    public DataCollection() {
        super();
    }


    /**
     * Constructs an empty Items with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the Items
     * @throws IllegalArgumentException if the specified initial capacity
     *                                  is negative
     */
    public DataCollection(int initialCapacity) {
        super(initialCapacity);
    }


    /**
     * Constructs a Items containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param c the collection whose elements are to be placed into this Items
     * @throws NullPointerException if the specified collection is null
     */
    public DataCollection(@NonNull Collection<T> c) {
        super(c);
    }
}
