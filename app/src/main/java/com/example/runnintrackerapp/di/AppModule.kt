package com.example.runnintrackerapp.di

import android.content.Context
import androidx.room.Room
import com.example.runnintrackerapp.data.local.RunDao
import com.example.runnintrackerapp.data.local.RunDatabase
import com.example.runnintrackerapp.utils.CONSTANTS.RUN_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRunDatabase(@ApplicationContext context: Context): RunDatabase {
        return Room.databaseBuilder(
            context,
            RunDatabase::class.java,
            RUN_DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideRunDao(db: RunDatabase): RunDao {
        return db.getRunDao()
    }
}