package com.clownser.financialsys.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.clownser.financialsys.R
import com.clownser.financialsys.itemLista.TarefaItem
import com.clownser.financialsys.model.Tarefa
import com.clownser.financialsys.ui.theme.LIGHT_BLUE



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListaFinancial(navController: NavController){

    val topAppBarHeight = 56.dp

    Scaffold(
        topBar = {
                TopAppBar(
                    title = { Text(text = "Home") },
                    colors = TopAppBarDefaults.largeTopAppBarColors(LIGHT_BLUE)
                )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("salvarFinancial")

                },
                containerColor = LIGHT_BLUE
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
                    contentDescription = "Icone de Adicionar")
            }
        },
        containerColor = Color.Black
    ) {
        val listaTarefas: MutableList<Tarefa> = mutableListOf(
            Tarefa(
                nome = "Cinema",
                descricao = "Tempo de descontração e diversão",
                price = 55.85,
                prioridade = 1
            ),
            Tarefa(
                nome = "Faculdade",
                descricao = "Tempo de descontração e diversão",
                price = 355.85,
                prioridade = 2
            ),
            Tarefa(
                nome = "salario",
                descricao = "Tempo de descontração e diversão",
                price = 11155.85,
                prioridade = 1
            ),
            Tarefa(
                nome = "investimento",
                descricao = "Tempo de descontração e diversão",
                price = 155.85,
                prioridade = 1
            ),
            Tarefa(
                nome = "video-game",
                descricao = "Tempo de descontração e diversão",
                price = 555.85,
                prioridade = 2
            )
        )
        LazyColumn( modifier= Modifier.padding(10.dp,80.dp,10.dp,10.dp)){
            itemsIndexed(listaTarefas){
                position, _->
                TarefaItem(position, listaTarefas)
            }

        }
    }
}