package com.android.ofornoapp.bd.mesas_db

import androidx.room.Database
import androidx.room.RoomDatabase

const val DATABASE_VERSION = 1

@Database(entities = [MesasEntity::class], version = DATABASE_VERSION)
abstract class MesasDBRoom : RoomDatabase() {
    abstract fun mesaDao(): MesaDao
}