package com.daledawson.jetpackstudy.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayMap
import com.daledawson.jetpackstudy.R

/**
 * 创 建 人：zhengquan
 * 创建日期：2020/6/19
 * 修改时间：
 * 修改备注：
 */
class DataBindingTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_databinding)
        val binding: ActivityDatabindingBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_databinding
        )
        val map = ObservableArrayMap<String, Any>()
        map["name"] = "我是你大爷"
        map["age"] = 20
        binding.studentInfo = map
    }
}