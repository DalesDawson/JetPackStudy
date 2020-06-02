package com.daledawson.jetpackstudy.room

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * 创 建 人：zhengquan
 * 创建日期：2020/5/25
 * 修改时间：
 * 修改备注：
 */
@Entity
class Person constructor() {
    constructor(name: String, age: Int) : this() {
        this.name = name
        this.age = age
    }

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
    var name: String? = null
    var age: Int? = null

    @Ignore
    var sex: Int? = null

    override fun toString(): String {
        return "PersonBean(id=$id, name=$name, age=$age, sex=$sex)"
    }
}