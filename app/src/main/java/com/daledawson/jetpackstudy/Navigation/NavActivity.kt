package com.daledawson.jetpackstudy.Navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.daledawson.jetpackstudy.R

/**
 * 创 建 人：zhengquan
 * 创建日期：2020/5/27
 * 修改时间：
 * 修改备注：
 */
class NavActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav)
    }

//    val navController: NavController = Navigation.findNavController(this, R.id.fragment)
//    //显示左上角返回键
////    NavigationUI.setupActionBarWithNavController(this,navController)
//
//    //设置左上角返回键的点击
//    override fun onSupportNavigateUp(): Boolean {
//        return Navigation.findNavController(this, R.id.fragment)
//            .navigateUp()
//
//    }
}