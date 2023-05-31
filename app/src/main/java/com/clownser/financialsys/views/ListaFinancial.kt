package com.clownser.financialsys.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.clownser.financialsys.R
import com.clownser.financialsys.itemLista.TarefaItem
import com.clownser.financialsys.model.Tarefa
import com.clownser.financialsys.ui.theme.LIGHT_BLUE
import java.text.DecimalFormat


fun calcularTotalReceita(listaTarefas: List<Tarefa>): Double {
    var totalReceita = 0.0
    for (tarefa in listaTarefas) {
        if (tarefa.tipo == 1) {
            totalReceita += tarefa.price ?: 0.0
        }
    }
    return totalReceita
}

fun calcularTotalDespesa(listaTarefas: List<Tarefa>): Double {
    var totalDespesa = 0.0
    for (tarefa in listaTarefas) {
        if (tarefa.tipo == 2) {
            totalDespesa += tarefa.price ?: 0.0
        }
    }
    return totalDespesa
}

fun calcularSaldo(listaTarefas: List<Tarefa>): Double {
    val totalReceita = calcularTotalReceita(listaTarefas)
    val totalDespesa = calcularTotalDespesa(listaTarefas)
    return totalReceita - totalDespesa
}


fun formatarValor(valor: Double): String {
    val decimalFormat = DecimalFormat("#0.00")
    return decimalFormat.format(valor)
}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListaFinancial(navController: NavController){

    val topAppBarHeight = 56.dp

    val listaTarefas: MutableList<Tarefa> = mutableListOf(
        Tarefa(
            nome = "Cinema",
            descricao = "Tempo de descontração e diversão",
            price = 55.85,
            tipo = 1
        ),
        Tarefa(
            nome = "Faculdade",
            descricao = "Tempo de descontração e diversão",
            price = 355.85,
            tipo = 2
        ),
        Tarefa(
            nome = "salario",
            descricao = "Tempo de descontração e diversão",
            price = 2000.85,
            tipo = 1
        ),
        Tarefa(
            nome = "investimento",
            descricao = "Tempo de descontração e diversão",
            price = 955.85,
            tipo = 1
        ),
        Tarefa(
            nome = "video-game",
            descricao = "Tempo de descontração e diversão",
            price = 555.85,
            tipo = 2
        )
    )

    val totalReceita = calcularTotalReceita(listaTarefas)
    val totalDespesa = calcularTotalDespesa(listaTarefas)
    val saldo = calcularSaldo(listaTarefas)

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
                    contentDescription = "Icone de Adicionar"
                )
            }
        },
        containerColor = Color.Black
    ) {
        Text(
            text = "Saldo: R$ ${formatarValor(saldo)}",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(80.dp)
        )

        LazyColumn(modifier = Modifier.padding(10.dp, 140.dp, 10.dp, 10.dp)) {
            itemsIndexed(listaTarefas) { position, _ ->
                TarefaItem(position, listaTarefas)
            }
        }
    }
}
