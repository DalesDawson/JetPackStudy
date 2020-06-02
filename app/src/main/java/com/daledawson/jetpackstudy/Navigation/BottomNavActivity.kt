package com.daledawson.jetpackstudy.Navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.daledawson.jetpackstudy.R
import kotlinx.android.synthetic.main.activity_bottom_nav.*
import kotlinx.android.synthetic.main.activity_bottom_nav.view.*
import kotlinx.android.synthetic.main.activity_bottom_nav.view.bottom_nav

/**
 * 创 建 人：zhengquan
 * 创建日期：2020/5/27
 * 修改时间：
 * 修改备注：
 */
class BottomNavActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)
        var controller: NavController = Navigation.findNavController(this, R.id.bottom_fragment)
//        var configuration: AppBarConfiguration =
//            AppBarConfiguration.Builder(bottom_nav.menu).build()
//        NavigationUI.setupActionBarWithNavController(this, controller, configuration)
        NavigationUI.setupWithNavController(bottom_nav, controller)
    }
}