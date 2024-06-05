//package com.duyle.roomdbex3
//
//import androidx.room.Dao
//import androidx.room.Database
//import androidx.room.Delete
//import androidx.room.Insert
//import androidx.room.Query
//import androidx.room.RoomDatabase
//
//@Database(entities = arrayOf(StudentModel::class), version = 1)
//abstract class StudentDB : RoomDatabase() {
//    abstract fun studentDAO(): StudentDAO
//}
//
//@Dao
//interface StudentDAO {
//    @Query("SELECT * FROM Student")
//    fun getAll(): List<StudentModel>
//
//    @Query("SELECT * FROM Student WHERE uid IN (:userIds)")
//    fun loadAllByIds(userIds: IntArray): List<StudentModel>
//
//    @Insert
//    fun insert(vararg user: StudentModel)
//
//    @Delete
//    fun delete(user: StudentModel)
//
//    @Query("UPDATE Student SET hoten = :name, mssv = :mssv, diemTB = :diemTB, daratruong = :daratruong WHERE uid = :uid")
//    fun update(uid: Int, name: String, mssv: String, diemTB: Float, daratruong: Boolean)
//}