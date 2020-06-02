package com.daledawson.jetpackstudy.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * 创 建 人：zhengquan
 * 创建日期：2020/5/25
 * 修改时间：
 * 修改备注：
 */
@Database(entities = [Person::class], version = 1)
abstract class PersonRoomDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao

    companion object {

        @Volatile
        private var instance: PersonRoomDatabase? = null

        fun getPersonRoomDatabase(context: Context): PersonRoomDatabase {
            if (null == instance) {
                synchronized(PersonRoomDatabase::class) {
                    if (null == instance) {
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            PersonRoomDatabase::class.java,
                            "db_test"
                        ).allowMainThreadQueries().build()
                    }
                }
            }
            return instance!!
        }

    }
}