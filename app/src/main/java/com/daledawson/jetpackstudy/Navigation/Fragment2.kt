package com.daledawson.jetpackstudy.Navigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.daledawson.jetpackstudy.R
import kotlinx.android.synthetic.main.fragment2_layout.*

/**
 * 创 建 人：zhengquan
 * 创建日期：2020/5/27
 * 修改时间：
 * 修改备注：
 */
class Fragment2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment2_layout, null, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //参数接收
        arguments?.let {
            Log.i("日志", it.getString("name"))
            Log.i("日志", it.getInt("age", 0).toString())
            Toast.makeText(
                context,
                "bundle传递过来的值" + it.getString("name") + it.getInt("age", 0).toString(),
                Toast.LENGTH_LONG
            ).show()
        }
        //---------------------------------------------------------------------------
        //页面跳转加通过bundle传参
        TwoToThree.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(Fragment2Directions.fragment2Action("我是safe-args传参"))
        }
    }
}