package com.example.soccerleagueorganizer.di

import android.content.Context
import androidx.room.Room
import com.example.soccerleagueorganizer.data.local.LocalDataSource
import com.example.soccerleagueorganizer.utils.room.AppDatabase
import com.example.soccerleagueorganizer.utils.room.WeekDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(
    SingletonComponent::class
)
class DatabaseModule {

    @Provides
    fun localDataSource(weekDao: WeekDao): LocalDataSource {
        return LocalDataSource(weekDao)
    }

    @Provides
    fun provideRoomDb(@ApplicationContext context: Context): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "LocalDb")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideFixtureDao(appDatabase: AppDatabase): WeekDao {
        return appDatabase.fixtureDao()
    }
}