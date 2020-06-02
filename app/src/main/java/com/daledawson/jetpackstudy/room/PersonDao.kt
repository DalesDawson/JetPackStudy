package com.daledawson.jetpackstudy.room

import androidx.room.*

/**
 * 创 建 人：zhengquan
 * 创建日期：2020/5/25
 * 修改时间：
 * 修改备注：
 */
@Dao
abstract class PersonDao {

    @Insert
    abstract fun insert(person: Person)

    @Delete
    abstract fun delete(person: Person)

    @Update
    abstract fun update(person: Person)

    @Query("SELECT * FROM Person")
    abstract fun getPersonList(): MutableList<Person>

    @Query("insert into Person values (:id,:name,:age)")
    abstract fun insertQuery(id: Int?, name: String?, age: Int?)

    @Query("delete from Person where id = :id")
    abstract fun deleteQuery(id: Int?)

    @Query("update Person set name = :name , age = :age where id= :id")
    abstract fun updateQuery(id: Int?, name: String?, age: Int?)

    @Query("select * from Person where id= :id")
    abstract fun findById(id: Int?): MutableList<Person>

    @Query("select * from Person where age > :age")
    abstract fun findByAge(age: Int?): MutableList<Person>

    @Query("select * from Person where name like :name")
    abstract fun findByNameRule(name: String?): MutableList<Person>
}