package com.daledawson.jetpackstudy.DataStore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import com.daledawson.jetpackstudy.R
import kotlinx.android.synthetic.main.activity_data_store.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

/**
 * 创 建 人：zhengquan
 * 创建日期：2020/10/27
 * 修改时间：
 * 修改备注：
 */
class DataStoreActivity : AppCompatActivity() {
    private val dataStoreKey = preferencesKey<String>("example_counter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_store)
        save_btn.setOnClickListener {
            GlobalScope.launch {
                saveData()
            }
        }

        get_btn.setOnClickListener {
            //Read from a Preferences DataStore
            GlobalScope.launch {
                val dataFlow: Flow<String> = dataStore.data
                    .map { preferences ->
                        // No type safety.
                        preferences[dataStoreKey] ?: ""
                    }
                dataFlow.collect { value -> println(value) }
            }
        }
    }

    private val dataStore: DataStore<Preferences> = this.createDataStore(
        name = "Data"
    )


//    //Read from a Preferences DataStore
//
//    val exampleCounterFlow: Flow<Int> = dataStore.data
//        .map { preferences ->
//            // No type safety.
//            preferences[dataStoreKey] ?: 0
//        }

    // Write to a Preferences DataStore
    suspend fun saveData() {
        dataStore.edit { settings ->
//            val currentCounterValue = settings[dataStoreKey] ?: ""
            settings[dataStoreKey] = "我是存入的数据"+System.currentTimeMillis()
        }
    }
}