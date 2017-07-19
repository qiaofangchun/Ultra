package com.ultra.adapter;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * An List implementation of TypePool.
 *
 * @author drakeet
 */
public class ItemManager implements ItemViewPool {
    private final List<Class<?>> classes;
    private final List<ItemViewLinker<?>> linkers;
    private final List<ItemViewBinder<?, ?>> binders;


    /**
     * Constructs a MultiTypePool with default lists.
     */
    public ItemManager() {
        classes = new ArrayList<>();
        binders = new ArrayList<>();
        linkers = new ArrayList<>();
    }


    /**
     * Constructs a MultiTypePool with default lists and a specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the list
     */
    public ItemManager(int initialCapacity) {
        classes = new ArrayList<>(initialCapacity);
        binders = new ArrayList<>(initialCapacity);
        linkers = new ArrayList<>(initialCapacity);
    }


    /**
     * Constructs a MultiTypePool with specified lists.
     *
     * @param classes the list for classes
     * @param binders the list for binders
     * @param linkers the list for linkers
     */
    public ItemManager(List<Class<?>> classes, List<ItemViewBinder<?, ?>> binders, List<ItemViewLinker<?>> linkers) {
        this.classes = classes;
        this.binders = binders;
        this.linkers = linkers;
    }


    @Override
    public <T> void register(
            @NonNull Class<? extends T> clazz,
            @NonNull ItemViewBinder<T, ?> binder,
            @NonNull ItemViewLinker<T> linker) {
        classes.add(clazz);
        binders.add(binder);
        linkers.add(linker);
    }


    @Override
    public int firstIndexOf(@NonNull final Class<?> clazz) {
        int index = classes.indexOf(clazz);
        if (index != -1) {
            return index;
        } else {
            for (int i = 0; i < classes.size(); i++) {
                if (classes.get(i).isAssignableFrom(clazz)) {
                    index = i;
                }
            }
            return index;
        }
    }


    @NonNull
    @Override
    public List<Class<?>> getClasses() {
        return classes;
    }


    @NonNull
    @Override
    public List<ItemViewBinder<?, ?>> getItemViewBinders() {
        return binders;
    }


    @NonNull
    public List<ItemViewLinker<?>> getLinkers() {
        return linkers;
    }
}
