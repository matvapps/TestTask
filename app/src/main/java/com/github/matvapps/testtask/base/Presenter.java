package com.github.matvapps.testtask.base;

/**
 * Created by Alexandr.
 */
public interface Presenter<V> {

    void attachView(V view);

    void detachView();
}

