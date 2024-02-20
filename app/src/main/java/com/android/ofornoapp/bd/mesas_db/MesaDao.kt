package com.android.ofornoapp.bd.mesas_db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MesaDao {
    @Query("SELECT * FROM MesasEntity")
    fun getAll(): List<MesasEntity>

    @Insert
    fun insertAll(vararg mesas: MesasEntity)

    @Delete
    fun delete(mesa: MesasEntity)
}