package com.example.grocery.data.remote.response

import com.example.grocery.data.remote.model.User

data class LoginResponse(
    val status: String,
    val token: String,
    val data: User
)
