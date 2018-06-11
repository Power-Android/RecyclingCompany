package com.power.recyclingcompany.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * @author power
 * @date 2018/5/29 下午5:53
 * @description:
 */
public abstract class BasePresenter<T> {

    protected Reference<T> mViewRef;


    public void attachView(T view){
        mViewRef = new WeakReference<T>(view);
    }

    public void detachView(){
        if(mViewRef!=null){
            mViewRef.clear();
            mViewRef = null;
        }
    }

    public boolean isViewAttached(){
        return mViewRef != null&&mViewRef.get()!=null;
    }

    protected T getView(){
        return mViewRef.get();
    }
}