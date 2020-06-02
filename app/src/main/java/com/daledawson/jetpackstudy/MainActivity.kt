package com.daledawson.jetpackstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.daledawson.jetpackstudy.Navigation.NavActivity
import com.daledawson.jetpackstudy.camerax.CameraXActivity
import com.daledawson.jetpackstudy.room.Person
import com.daledawson.jetpackstudy.room.PersonRoomDatabase
import com.daledawson.jetpackstudy.room.RoomTestActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        room.setOnClickListener {
            startActivity(Intent(this, RoomTestActivity::class.java))
        }
        navigation.setOnClickListener {
            startActivity(Intent(this, NavActivity::class.java))
        }
        camerax.setOnClickListener {
            startActivity(Intent(this, CameraXActivity::class.java))
        }
    }
}
