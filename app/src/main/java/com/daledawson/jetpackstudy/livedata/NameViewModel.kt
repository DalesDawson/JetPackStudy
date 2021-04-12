package com.daledawson.jetpackstudy.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * 创 建 人：zhengquan
 * 创建日期：2021/3/4
 * 修改时间：
 * 修改备注：
 */
class NameViewModel : ViewModel() {
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}