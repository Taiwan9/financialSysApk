package com.clownser.financialsys.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.clownser.financialsys.ui.theme.BLACK
import com.clownser.financialsys.ui.theme.LIGHT_BLUE
import com.clownser.financialsys.ui.theme.ShapeEditText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaixaTexto(value:String,
               onValueChange:(String)->Unit,
               modifier:Modifier,
               label:String,
                maxLines:Int,
                keyboardType: KeyboardType){

    OutlinedTextField(
        value = value,
        onValueChange,
        modifier,
        label = {
            Text(text = label)
        },
        maxLines = maxLines,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = BLACK,
            focusedBorderColor = LIGHT_BLUE,
            focusedLabelColor = LIGHT_BLUE,
            cursorColor = LIGHT_BLUE
        ),
        shape = ShapeEditText.small,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}
