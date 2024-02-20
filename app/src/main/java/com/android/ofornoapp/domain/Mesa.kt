package com.android.ofornoapp.domain

import com.android.ofornoapp.bd.mesas_db.MesasEntity

data class Mesa(
    val ID :Int,
    val NumMesa: Int,
    val NumComensales: Int,
    val Cobrada: Boolean,
    val Ticket: List<String>,
){

    companion object {
        private var contadorId: Int = 0

        fun getNextId(): Int {
            return contadorId++
        }
    }

    constructor(numMesa: Int, numComensales: Int, cobrada: Boolean, ticket: List<String>) :
            this(getNextId(), numMesa, numComensales, cobrada, ticket)
}
fun Mesa.toEntity() = MesasEntity(
    IDMesa = ID,
    NumMesa = NumMesa,
    NumComensales = NumComensales,
    Cobrada = Cobrada,
    Ticket = Ticket.first()
    ,
)