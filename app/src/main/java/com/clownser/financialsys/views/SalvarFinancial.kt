package com.clownser.financialsys.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.clownser.financialsys.components.Botao
import com.clownser.financialsys.components.CaixaTexto
import com.clownser.financialsys.ui.theme.LIGHT_BLUE
import com.clownser.financialsys.ui.theme.RADIO_BUTTON_GREEN_DISABLE
import com.clownser.financialsys.ui.theme.RADIO_BUTTON_GREEN_SELECTED
import com.clownser.financialsys.ui.theme.RADIO_BUTTON_RED_DISABLE
import com.clownser.financialsys.ui.theme.RADIO_BUTTON_RED_SELECTED
import com.clownser.financialsys.ui.theme.RADIO_BUTTON_YELLOW_DISABLE
import com.clownser.financialsys.ui.theme.RADIO_BUTTON_YELLOW_SELECTED

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalvarFinancial(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Adicionar Receita") },
                colors = TopAppBarDefaults.largeTopAppBarColors(LIGHT_BLUE)

            )
        },
    ) {
        var tituloTarefa by remember {
            mutableStateOf("")
        }
        var descricao by remember {
            mutableStateOf("")
        }

        var price by remember {
            mutableStateOf("")
        }

        var receita by remember {
            mutableStateOf(false)
        }

        var despesa by remember {
            mutableStateOf(false)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            CaixaTexto(
                    value = tituloTarefa,
            onValueChange = {
                tituloTarefa = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 60.dp, 20.dp, 0.dp),
            label = "Titulo Tarefa",
            maxLines = 1,
            keyboardType = KeyboardType.Text
            )

            CaixaTexto(
                value = price,
                onValueChange = {
                    price = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                label = "Preço",
                maxLines = 1,
                keyboardType = KeyboardType.Number
            )

            CaixaTexto(
                value = descricao,
                onValueChange = {
                    descricao = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                label = "Descrição",
                maxLines = 2,
                keyboardType = KeyboardType.Text
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Receita/Despesa")
                RadioButton(
                    selected =receita,
                    onClick = {
                        receita = !receita
                    },
                colors = RadioButtonDefaults.colors(
                    unselectedColor = RADIO_BUTTON_GREEN_DISABLE,
                    selectedColor = RADIO_BUTTON_GREEN_SELECTED
                ))

                RadioButton(
                    selected = despesa,
                    onClick = {
                        despesa = !despesa
                    },
                colors = RadioButtonDefaults.colors(
                    unselectedColor = RADIO_BUTTON_RED_DISABLE,
                    selectedColor = RADIO_BUTTON_RED_SELECTED
                )
                )
            }
        Botao(
            onCLick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(20.dp),
            texto = "Salvar")
        }
    }
}