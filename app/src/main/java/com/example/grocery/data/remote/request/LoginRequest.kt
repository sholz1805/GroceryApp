package com.example.grocery.data.remote.request

import com.example.grocery.auth.events.LoginFormEvent

data class LoginRequest(
    val email: String,
    val password: String
)
