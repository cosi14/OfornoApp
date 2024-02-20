package com.android.ofornoapp.feature.mesa

import android.util.Log
import com.android.ofornoapp.bd.mesas_db.MesaDao
import com.android.ofornoapp.bd.mesas_db.toDomain
import com.android.ofornoapp.domain.Mesa
import com.android.ofornoapp.domain.toEntity
import javax.inject.Inject


class MesaRepository @Inject constructor(
    private val mesasDao: MesaDao
) {
    fun getDao(): List<Mesa> {
        Log.d("PilasRepository", "getPilas: ")
        val mesas = mesasDao.getAll().map { it.toDomain() }
        Log.d("PilasRepository", "getPilas: FINISHED $mesas")
        return mesas
    }

    fun guardarMesa(mesa: Mesa) = mesasDao.insertAll(mesa.toEntity())

}