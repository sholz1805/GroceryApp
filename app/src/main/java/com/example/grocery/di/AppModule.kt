package com.example.grocery.di

import com.example.grocery.data.remote.Api
import com.example.grocery.data.repositories.UserRepositoryImpl
import com.example.grocery.domain.repositories.UserRepository
import com.example.grocery.domain.usecases.auth.AuthenticationUseCases
import com.example.grocery.domain.usecases.auth.Login
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    val baseUrl = "https://gorceriesonline.herokuapp.com"

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient{
        return OkHttpClient.Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideGroceriesApi( client: OkHttpClient) : Api {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(client)
            .build()
            .create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: Api) : UserRepository{
        return UserRepositoryImpl(api = api)
    }

    @Provides
    @Singleton
    fun provideAuthenticationUseCases(repository: UserRepository) : AuthenticationUseCases{
        return AuthenticationUseCases(
            login = Login(userRepository = repository)
        )
    }


}