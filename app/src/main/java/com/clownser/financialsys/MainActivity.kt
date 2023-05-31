package com.clownser.financialsys

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.clownser.financialsys.ui.theme.FinancialSysTheme
import com.clownser.financialsys.views.ListaFinancial
import com.clownser.financialsys.views.SalvarFinancial

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinancialSysTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, "listaFinancial" ){
                    composable(
                        route = "listaFinancial"
                    ){
                        ListaFinancial(navController)
                    }

                    composable(
                        route = "salvarFinancial"
                    ){
                        SalvarFinancial(navController)
                    }
                }
            }
        }
    }
}



