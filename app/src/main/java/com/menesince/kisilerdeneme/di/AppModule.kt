package com.menesince.kisilerdeneme.di

import android.content.Context
import androidx.room.Room
import com.menesince.kisilerdeneme.data.datasource.KisilerDataSource
import com.menesince.kisilerdeneme.data.repo.KisilerRepository
import com.menesince.kisilerdeneme.room.Database
import com.menesince.kisilerdeneme.room.IKisilerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideKisilerDataSource(kDao : IKisilerDao) : KisilerDataSource{
        return KisilerDataSource(kDao)
    }

    @Provides
    @Singleton
    fun provideKisilerRepository(kds : KisilerDataSource) : KisilerRepository{
        return KisilerRepository(kds)
    }

    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context : Context) : IKisilerDao{
        val db = Room.databaseBuilder(context,Database::class.java,"rehber.sqlite")
            .createFromAsset("rehber.sqlite").build()
        return db.getKisileriGoster()

    }

}