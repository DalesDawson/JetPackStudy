package com.daledawson.jetpackstudy

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.daledawson.jetpackstudy.lifecycle.AppLifecycleListener

/**
 * 创 建 人：zhengquan
 * 创建日期：2020/6/19
 * 修改时间：
 * 修改备注：
 */
class App : Application() {
    private val appLifecycleListener by lazy { AppLifecycleListener() }

    override fun onCreate() {
        super.onCreate()

//        ProcessLifecycleOwner
        ProcessLifecycleOwner.get().lifecycle.addObserver(appLifecycleListener)

    }
}