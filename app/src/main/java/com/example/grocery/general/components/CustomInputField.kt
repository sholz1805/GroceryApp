package com.example.grocery.general.components

import android.view.View
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CustomInputField(
    value: String,
    onValueChange: (String) -> Unit,
    onFocusChange: (FocusState) -> Unit,
    modifier: Modifier,
    headerText: String,
    hasError: Boolean,
    errorMessage: String,
    hasTrailingIcon: Boolean =  false,
    hasLeadingIcon: Boolean = false,
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    imeAction: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Text
    
    
){
    val touched = remember{
        mutableStateOf(false)
    }

    Column(modifier= modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = {
                touched.value = true
                onValueChange(it)
            },
        modifier = Modifier.onFocusChanged {
            if (touched.value) onFocusChange(it)
        },
        label = {
                Text(text = headerText)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction,
            ),
            trailingIcon = if (hasTrailingIcon){
                trailingIcon
            } else{
                {}
            },
            leadingIcon = if (hasLeadingIcon){
                leadingIcon
            } else{
                {}
            }
        )
        if(hasError){
            Text(text = errorMessage)
        }
    }
    
}