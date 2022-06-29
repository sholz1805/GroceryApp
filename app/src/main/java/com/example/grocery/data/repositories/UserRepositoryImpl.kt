package com.example.grocery.data.repositories

import com.example.grocery.data.remote.Api
import com.example.grocery.data.remote.request.LoginRequest
import com.example.grocery.data.remote.response.LoginResponse
import com.example.grocery.domain.repositories.UserRepository

class UserRepositoryImpl(
    private val api: Api
    ): UserRepository {
    override suspend fun login(request: LoginRequest): LoginResponse {
        return api.login(request)
    }
}