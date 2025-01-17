package com.example.account.ui.main.components

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.account.viewmodel.MainViewModel

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun ActivityContent(context: Context, mainViewModel: MainViewModel) {
    val invoices by mainViewModel.invoices.observeAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(top = 30.dp, start = 20.dp, end = 20.dp, bottom = 10.dp)
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {
            InvoiceHeader(num = invoices?.size) //发票标题
            Buttons(modifier = Modifier.align(Alignment.CenterVertically), context)
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Body(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                invoices = invoices,
                context = context
            )
        }
    }
}
