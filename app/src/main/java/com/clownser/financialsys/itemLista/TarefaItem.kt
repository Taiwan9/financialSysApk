package com.clownser.financialsys.itemLista

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.clownser.financialsys.R
import com.clownser.financialsys.model.Tarefa
import com.clownser.financialsys.ui.theme.RADIO_BUTTON_GREEN_SELECTED
import com.clownser.financialsys.ui.theme.RADIO_BUTTON_RED_SELECTED
import com.clownser.financialsys.ui.theme.RADIO_BUTTON_YELLOW_SELECTED
import com.clownser.financialsys.ui.theme.ShapeCardPrioridade

@Composable
fun TarefaItem(position:Int, listaTarefas:MutableList<Tarefa>){

    val tituloNome = listaTarefas[position].nome
    val descricaoTarefa = listaTarefas[position].descricao
    val tipo = listaTarefas[position].tipo
    val price = listaTarefas[position].price


    var tipoReceita: String = when(tipo){


        1 ->{
            "Receita"
        }

        else ->{
            "Despesa"
        }
    }


        val color = when(tipo){
            0->{Color.Black}
            1->{
                RADIO_BUTTON_GREEN_SELECTED
            }

            else->{
                RADIO_BUTTON_RED_SELECTED
            }
        }


    Card(
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
       ConstraintLayout(
           modifier = Modifier.padding(20.dp)
       ) {
           val(txtTitulo,txtPrice, txtDescricao, cardPrioridade, txtPrioridade, btDeletar)= createRefs()

           Text(text = tituloNome.toString(),
                modifier = Modifier.constrainAs(txtTitulo){
                    top.linkTo(parent.top,margin = 10.dp)
                    start.linkTo(parent.start, margin=10.dp)

                },

           )
           Text(text =price.toString(),
               modifier = Modifier.constrainAs(txtPrice){
                   top.linkTo(txtTitulo.bottom, margin =40.dp)
                   start.linkTo(parent.start, margin=10.dp)
               }
           )
           Text(text = descricaoTarefa.toString(),
                modifier = Modifier.constrainAs(txtDescricao){
                    top.linkTo(txtPrice.bottom,margin = 10.dp)
                    start.linkTo(parent.start, margin=10.dp)
                }
           )
           Text(text = tipoReceita,
                modifier = Modifier.constrainAs(txtPrioridade){
                    top.linkTo(txtDescricao.bottom,margin = 10.dp)
                    start.linkTo(parent.start, margin=10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
           )
           Card(
               colors = CardDefaults.cardColors(color),
               modifier = Modifier
                   .size(30.dp)
                   .constrainAs(cardPrioridade) {
                       top.linkTo(txtDescricao.bottom, margin = 10.dp)
                       start.linkTo(txtPrioridade.end, margin = 10.dp)
                       bottom.linkTo(parent.bottom, margin = 10.dp)
                   },
               shape = ShapeCardPrioridade.large
           ) {
               
           }
           IconButton(
               onClick ={

               },
               modifier = Modifier.constrainAs(btDeletar){
                   top.linkTo(txtDescricao.bottom, margin=10.dp)
                   start.linkTo(cardPrioridade.end, margin = 30.dp)
                   end.linkTo(parent.end, margin = 10.dp)
                   bottom.linkTo(parent.bottom, margin= 10.dp)
               }
           ) {
               Image(
                   imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete),
                   contentDescription = "Icone de Deletar a tarefa" )
           }
       }
    }
}

