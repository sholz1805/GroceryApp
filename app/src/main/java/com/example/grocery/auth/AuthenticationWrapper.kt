package com.example.grocery.auth

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.rememberNavController
import com.example.grocery.auth.viewmodels.AuthViewModel
import com.example.grocery.navigation.navhost.AuthenticationNavigationHost

@Composable
fun AuthenticationWrapper(
    viewModel: AuthViewModel
) {
    val navHostController = rememberNavController()
    AuthenticationNavigationHost(
        navHostController = navHostController,
        authViewModel = viewModel
    )
}