package com.ultra.adapter;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * An ordered collection to hold the types, binders and linkers.
 *
 * @author drakeet
 */
public interface ItemViewPool {

    /**
     * Registers a type class and its item view binder.
     *
     * @param clazz  the class of a item
     * @param binder the item view binder
     * @param linker the linker to link the class and view binder
     * @param <T>    the item data type
     */
    <T> void register(
            @NonNull Class<? extends T> clazz,
            @NonNull ItemViewBinder<T, ?> binder,
            @NonNull ItemViewLinker<T> linker);

    /**
     * For getting index of the item class. If the subclass is already registered,
     * the registered mapping is used. If the subclass is not registered, then look
     * for its parent class if is registered, if the parent class is registered,
     * the subclass is regarded as the parent class.
     *
     * @param clazz the item class.
     * @return The index of the first occurrence of the specified class
     * in this pool, or -1 if this pool does not contain the class.
     */
    int firstIndexOf(@NonNull Class<?> clazz);

    /**
     * Gets the item classes.
     *
     * @return The item classes list
     */
    @NonNull
    List<Class<?>> getClasses();

    /**
     * Gets the item view binders list.
     *
     * @return the binders list
     */
    @NonNull
    List<ItemViewBinder<?, ?>> getItemViewBinders();

    /**
     * Gets the linkers list.
     *
     * @return the linkers list
     */
    @NonNull
    List<ItemViewLinker<?>> getLinkers();
}
