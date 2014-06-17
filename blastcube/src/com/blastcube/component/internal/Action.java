package com.blastcube.component.internal;

// Generic function with a single object parameter
public interface Action<T> {

    public void call(T data);

}
