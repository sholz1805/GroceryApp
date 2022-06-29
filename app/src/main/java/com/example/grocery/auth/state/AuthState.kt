package com.example.grocery.auth.state

data class AuthState(

    val isAuthenticated: Boolean = false,
    val isLoading: Boolean =  false,
    val errorOccurred: Boolean =  false,
    val errorMessage: String = ""

)
