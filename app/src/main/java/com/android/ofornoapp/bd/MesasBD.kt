package com.android.ofornoapp.bd


    import android.provider.BaseColumns

    object MesasDBScheme: BaseColumns {
        const val TABLE_NAME = "Mesas"
        const val COLUMN_ID = "ID"
        const val COLUMN_NUMEROMESA = "Identificacion mesa"
        const val COLUMN_NUMEROCOMENSALES = "Numero de personas en la mesa"
        const val COLUMN_COBRADA = "Si esta mesa a pagado"
        const val COLUMN_TICKET = "Elticjet de la misma "
    }

    const val SQL_CREATE_ENTRIES = """
    CREATE TABLE ${MesasDBScheme.TABLE_NAME} (
        ${MesasDBScheme.COLUMN_ID} INT  PRIMARY KEY,
        ${MesasDBScheme.COLUMN_NUMEROMESA} INT ,
        ${MesasDBScheme.COLUMN_NUMEROCOMENSALES} INT ,
        ${MesasDBScheme.COLUMN_COBRADA} BOOLEAN
        ${MesasDBScheme.COLUMN_TICKET} TEXT
    )
"""


private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${MesasDBScheme.TABLE_NAME}"
