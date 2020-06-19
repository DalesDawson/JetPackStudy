package com.daledawson.jetpackstudy.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.daledawson.jetpackstudy.R

/**
 * 创 建 人：zhengquan
 * 创建日期：2020/6/19
 * 修改时间：
 * 修改备注：
 */
class LifeCycleActivity : AppCompatActivity(), LifecycleOwner {

    private lateinit var lifecycleRegistry: LifecycleRegistry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)

        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.addObserver(AppLifecycleListener())
        lifecycleRegistry.markState(Lifecycle.State.CREATED)

    }

    override fun onResume() {
        super.onResume()
        lifecycleRegistry.markState(Lifecycle.State.RESUMED)
    }

    override fun onPause() {
        super.onPause()
        lifecycleRegistry.markState(Lifecycle.State.STARTED)
    }

//    override fun getLifecycle(): Lifecycle {
//        return lifecycleRegistry
//    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleRegistry.markState(Lifecycle.State.DESTROYED)
    }

}