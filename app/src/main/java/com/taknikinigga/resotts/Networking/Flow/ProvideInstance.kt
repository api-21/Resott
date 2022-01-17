package com.taknikinigga.resotts.Networking.Flow

import android.content.Context
import androidx.room.Room
import com.taknikinigga.resotts.Networking.room.ResottDao
import com.taknikinigga.resotts.Networking.room.ResottDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProvideInstance {

    @Provides
    @Singleton
    fun provideApi(): ApiServices {
        return Retrofit.Builder().baseUrl(ApiServices.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiServices::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ResottDatabase {
        return Room.databaseBuilder(
            context, ResottDatabase::class.java,
            "ResottLocalDatabase"
        )
            .build()
    }

    @Provides
    fun provideDao(resottDatabase: ResottDatabase): ResottDao {
        return resottDatabase.getDao()
    }

}