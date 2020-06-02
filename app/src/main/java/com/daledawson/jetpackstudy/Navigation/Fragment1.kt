package com.daledawson.jetpackstudy.Navigation

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.daledawson.jetpackstudy.R
import kotlinx.android.synthetic.main.fragment1_layout.*

/**
 * 创 建 人：zhengquan
 * 创建日期：2020/5/27
 * 修改时间：
 * 修改备注：
 */
class Fragment1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment1_layout, null, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        OneToTwo.setOnClickListener {
            //页面跳转加通过bundle传参
            Navigation.findNavController(it).navigate(R.id.fragment1_action, Bundle().apply {
                putString("name", "Dale")
                putInt("age", 18)
            })
            //--------------------------------------------------------------------------------------
        }
        deepLink1.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("dlValue", "通知跳转")
            val deepLink = findNavController()
                .createDeepLink()
                .setArguments(bundle)
                .setDestination(R.id.fragment3)
                .createPendingIntent()
            val notificationManager =
                context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationManager.createNotificationChannel(
                    NotificationChannel(
                        "Deep Link", "Deep Links", NotificationManager.IMPORTANCE_HIGH
                    )
                )
            }
            val builder = NotificationCompat.Builder(
                requireContext(), "Deep Link"
            )
                .setContentTitle("通知")
                .setContentText("跳转到Deep Link")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(deepLink)
                .setAutoCancel(true)
            notificationManager.notify(0, builder.build())
        }
    }
}
