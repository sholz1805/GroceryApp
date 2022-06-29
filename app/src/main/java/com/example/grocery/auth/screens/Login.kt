package com.example.grocery.auth.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.grocery.navigation.destinations.Destination
import com.example.grocery.R
import com.example.grocery.auth.events.AuthEvent
import com.example.grocery.auth.events.LoginFormEvent
import com.example.grocery.auth.viewmodels.AuthViewModel
import com.example.grocery.auth.viewmodels.LoginViewModel
import com.example.grocery.general.components.CustomInputField
import com.example.grocery.general.components.PasswordInputField
import kotlinx.coroutines.flow.collectLatest

@Composable
fun Login(
    navController: NavController,
    loginViewModel: LoginViewModel = hiltViewModel(),
    authViewModel: AuthViewModel
){
    val loginFormState = loginViewModel.state.value
    val isLoading = authViewModel.state.value.isLoading
    LaunchedEffect(Unit){
        authViewModel.eventFlow.collectLatest {
                event -> when(event){
            is AuthEvent.LoginSuccess ->{
                Log.i("login","logged in successfully")
            }
            else->{

            }
        }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.2f),
            contentAlignment = Alignment.Center
        ){
            Image(painter = painterResource(
                id = R. drawable.logo),
                contentDescription = ""
            )
        }
        Text(
            text = "Login",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Enter your email and password",
            fontSize = 16.sp,
            color = Color(0xFF7C7C7C)
        )
        Spacer(modifier = Modifier.height(20.dp))
        CustomInputField(
            value = loginFormState.email,
            onValueChange = {newValue ->
                loginViewModel.createEvent(
                    LoginFormEvent.EnteredEmail(value = newValue)
                )
            },
            onFocusChange = {
                loginViewModel.createEvent(
                    LoginFormEvent.FocusChange("email")
                )
            },
            modifier = Modifier.fillMaxWidth(),
            headerText = "Email" ,
            hasError = !loginFormState.emailValid,
            errorMessage = loginFormState.emailErrorMessage,
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        )
        Spacer(modifier = Modifier.height(20.dp))
        PasswordInputField(
            value = loginFormState.password,
            onValueChange = {newValue ->
                loginViewModel.createEvent(
                    LoginFormEvent.EnteredPassword(value = newValue)
                )
            },
            onFocusChange = {
                loginViewModel.createEvent(
                    LoginFormEvent.FocusChange("password")
                )
            },
            modifier = Modifier.fillMaxWidth(),
            headerText = "Password" ,
            hasError = !loginFormState.passwordValid,
            errorMessage = loginFormState.passwordErrorMessage,
            imeAction = ImeAction.Done
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextButton(
            onClick = { },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Forgot Password ?")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                authViewModel.createEvent(
                    AuthEvent.Login(
                        email = loginFormState.email,
                        password = loginFormState.password
                    )
                )
            },
            modifier = Modifier.fillMaxWidth()
        ){
            if(isLoading) {
                CircularProgressIndicator(
                    color = Color.White,
                    strokeWidth = 2.dp
                )
            }
            else{
                Text(text = "Login")
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        TextButton(
            onClick = { navController.navigate(Destination.SignupDestination.route) },
            modifier =  Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Don't have an account? Sign Up")
        }
    }
}
//
//@Preview
//@Composable
//fun PreviewLogin(){
//    Login(navController = rememberNavController())
//}