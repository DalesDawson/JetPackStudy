package com.daledawson.jetpackstudy

import Activity_Results_API.FirstActivity
import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.daledawson.jetpackstudy.DataStore.DataStoreActivity
import com.daledawson.jetpackstudy.Navigation.NavActivity
import com.daledawson.jetpackstudy.camerax.CameraXActivity
import com.daledawson.jetpackstudy.databinding.DataBindingTest
import com.daledawson.jetpackstudy.lifecycle.LifeCycleActivity
import com.daledawson.jetpackstudy.livedata.NameActivity
import com.daledawson.jetpackstudy.room.Person
import com.daledawson.jetpackstudy.room.PersonRoomDatabase
import com.daledawson.jetpackstudy.room.RoomTestActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        room.setOnClickListener {
            var intent = Intent(this, RoomTestActivity::class.java)
//            var bundle: Bundle = Bundle();
//            bundle.putString("position", "PTP-JSX-120")
//            intent.putExtra("traceId", "DSJ-JSB-445")
//            intent.putExtras(bundle)
            startActivity(intent)
        }
        navigation.setOnClickListener {
            startActivity(Intent(this, NavActivity::class.java))
        }
        camerax.setOnClickListener {

            startActivity(Intent(this, CameraXActivity::class.java))
        }
        dataBinding.setOnClickListener {
            startActivity(Intent(this, DataBindingTest::class.java))
        }
        lifecycle_btn.setOnClickListener {
            startActivity(Intent(this, LifeCycleActivity::class.java))
        }
        DataStore_btn.setOnClickListener {
            startActivity(Intent(this, DataStoreActivity::class.java))
        }
        ResultsAPI_btn.setOnClickListener {
            startActivity(Intent(this, FirstActivity::class.java))
        }
        LiveData_btn.setOnClickListener {
            startActivity(Intent(this, NameActivity::class.java))
        }
    }
}
