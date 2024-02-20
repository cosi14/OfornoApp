package com.android.ofornoapp.di

import android.content.Context
import androidx.room.Room
import com.android.ofornoapp.bd.mesas_db.MesasDBRoom
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object MesasDbModule {
    const val DATABASE_NAME = "MesasRoom.db"

    @Provides
    fun providesPilasDbRoom(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        MesasDBRoom::class.java, DATABASE_NAME
    ).build()

    @Provides
    fun providesPilaDao(mesasDBRoom: MesasDBRoom) = mesasDBRoom.mesaDao()
}