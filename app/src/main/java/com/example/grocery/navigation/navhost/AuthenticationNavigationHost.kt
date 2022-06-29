package com.example.grocery.navigation.navhost

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.grocery.auth.screens.Login
import com.example.grocery.auth.screens.Register
import com.example.grocery.auth.viewmodels.AuthViewModel
import com.example.grocery.navigation.destinations.Destination

@Composable
fun AuthenticationNavigationHost(
    navHostController: NavHostController,
    authViewModel: AuthViewModel
){
    NavHost(
        navController = navHostController,
        startDestination = Destination.LoginDestination.route
    ){
        composable(route = Destination.LoginDestination.route){
            Login(
                navController = navHostController,
                authViewModel = authViewModel
            )
        }

        composable(route = Destination.SignupDestination.route){
            Register(navController = navHostController)
        }
    }
}