package com.android.ofornoapp.bd.mesas_db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.ofornoapp.domain.Mesa


@Entity
    class MesasEntity (
    @PrimaryKey val IDMesa: Int,
    @ColumnInfo(name = "Numero Mesa") val NumMesa: Int,
    @ColumnInfo(name = "Numero Comensales") val NumComensales: Int,
    @ColumnInfo(name = "Cobrada") val Cobrada: Boolean,
    @ColumnInfo(name = "Ticket") val Ticket: String,
    ) {

}

fun MesasEntity.toDomain() = Mesa(
    ID = IDMesa,
    NumMesa = NumMesa,
    NumComensales = NumComensales,
    Cobrada = Cobrada,
    Ticket = emptyList()
)



