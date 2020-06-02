package com.daledawson.jetpackstudy.Navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.daledawson.jetpackstudy.R

/**
 * 创 建 人：zhengquan
 * 创建日期：2020/5/27
 * 修改时间：
 * 修改备注：
 */
class FragmentOne : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_one, null)
    }
}