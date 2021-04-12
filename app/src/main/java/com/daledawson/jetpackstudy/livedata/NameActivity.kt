package com.daledawson.jetpackstudy.livedata

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.daledawson.jetpackstudy.R
import kotlinx.android.synthetic.main.activity_name.*

/**
 * 创 建 人：zhengquan
 * 创建日期：2021/3/4
 * 修改时间：
 * 修改备注：
 */
class NameActivity : AppCompatActivity() {
    private val model: NameViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        val nameObserver = Observer<String> { newName ->
            nameTextView.text = newName
        }

        model.currentName.observe(this, nameObserver)

        button.setOnClickListener {
            val anotherName = "John Doe"
            model.currentName.setValue(anotherName)
        }
    }
}