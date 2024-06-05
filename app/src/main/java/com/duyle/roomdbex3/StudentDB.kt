package com.duyle.roomdbex3

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [StudentModel::class], version = 1)
abstract class StudentDB : RoomDatabase() {
    abstract fun studentDAO(): StudentDAO
}
