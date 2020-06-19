package com.daledawson.jetpackstudy.room

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.daledawson.jetpackstudy.Common
import com.daledawson.jetpackstudy.R
import kotlinx.android.synthetic.main.activity_room.*

/**
 * 创 建 人：zhengquan
 * 创建日期：2020/5/25
 * 修改时间：
 * 修改备注：
 */
class RoomTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        var position: String = intent.getStringExtra("position")
        var traceId: String = intent.getStringExtra("traceId")
        Log.d("TAG", "position= $position+ traceId= $traceId")
        roomTest()
    }

    private fun roomTest() {
        val personDao = PersonRoomDatabase.getPersonRoomDatabase(this).personDao()
        var personList: MutableList<Person> = arrayListOf()
//        val person = Person("张大爷", 80)
//        personDao.insert(person)
//        Log.d(Common.TAG, "插入数据：$person")
//        val person1 = Person("小张", 8)
//        personDao.insert(person1)
//        Log.d(Common.TAG, "插入数据：$person1")

//        val personBean = Person("小张来了", 23)
//        personBean.id = 2
//        personDao.update(personBean)
//
//        var personList: MutableList<Person> = personDao.getPersonList()
//        Log.d(Common.TAG, "共有${personList.size}个人")
//        personList.forEach {
//            Log.d(Common.TAG, it.toString())
//        }

        add.setOnClickListener {
            val personDao = PersonRoomDatabase.getPersonRoomDatabase(this).personDao()
            val person = Person("张三", 18)
            personDao.insert(person)
            Log.d(Common.TAG, "插入数据：$person")
            personList = personDao.getPersonList()
            result.text = personList.toString()
        }
        delete.setOnClickListener {
            val personBean = Person()
            personBean.id = personList.size - 1
            personDao.delete(personBean)
            personList = personDao.getPersonList()
            result.text = personList.toString()
        }
        alter.setOnClickListener {
            val personBean = Person("修改的数据", 23)
            personBean.id = personList.size - 1
            personDao.update(personBean)
            personList = personDao.getPersonList()
            result.text = personList.toString()
        }
        search.setOnClickListener {
            personList = personDao.getPersonList()
            Log.d(Common.TAG, "共有${personList.size}个人")
            personList.forEach {
                Log.d(Common.TAG, it.toString())
            }
            Toast.makeText(this, "共有${personList.size}个人", Toast.LENGTH_SHORT).show()
        }
    }
}