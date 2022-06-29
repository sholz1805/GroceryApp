package com.example.grocery.domain.repositories

import com.example.grocery.data.remote.request.LoginRequest
import com.example.grocery.data.remote.response.LoginResponse

interface UserRepository {
    suspend fun login(request: LoginRequest) : LoginResponse
}