package com.daledawson.jetpackstudy.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * 创 建 人：zhengquan
 * 创建日期：2020/6/19
 * 修改时间：
 * 修改备注：
 */
class AppLifecycleListener : LifecycleObserver {
    private val TAG: String = "Lifecycle"

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public fun connectOnCreate() {
        Log.d(TAG, "connectOnCreate================")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public fun connectOnStart() {
        Log.d(TAG, "connectOnStart================")
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public fun connectOnResume() {
        Log.d(TAG, "connectOnResume================")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public fun connectOnPause() {
        Log.d(TAG, "connectOnPause================")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public fun connectOnStop() {
        Log.d(TAG, "connectOnStop================")
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public fun connectOnDestroy() {
        Log.d(TAG, "connectOnDestroy================")
    }

}
