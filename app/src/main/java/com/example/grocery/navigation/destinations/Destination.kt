package com.example.grocery.navigation.destinations

sealed class Destination(val name: String, val route:String){
    object LoginDestination:
        Destination(name = "login", route = "login")

    object SignupDestination:
        Destination(name = "signup", route = "signup")
}
