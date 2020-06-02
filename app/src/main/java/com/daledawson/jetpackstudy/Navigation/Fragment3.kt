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
import kotlinx.android.synthetic.main.fragment3_layout.*

/**
 * 创 建 人：zhengquan
 * 创建日期：2020/5/27
 * 修改时间：
 * 修改备注：
 */
class Fragment3 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment3_layout, null, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        arguments?.let {
//            Log.i("日志", it.getString("title"))
//        }
        var title: String = Fragment3Args.fromBundle(requireArguments()).title
        Log.i("日志", title)
        Toast.makeText(
            context, "safe args传递过来的值$title", Toast.LENGTH_LONG
        ).show()
        ThreeToOne.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.fragment3_action)
        }
    }
}