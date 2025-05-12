package com.crowns.discountapp.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.crowns.discountapp.components.Alert
import com.crowns.discountapp.components.MainButton
import com.crowns.discountapp.components.MainTextField
import com.crowns.discountapp.components.SpaceH
import com.crowns.discountapp.components.TwoCards
import com.crowns.discountapp.viewModels.CalculateViewModel3

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView3(viewModel: CalculateViewModel3) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "App Discount", color = Color.White) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }) {
        ContentHomeView3(it, viewModel)
    }
}

@Composable
fun ContentHomeView3(paddingValues: PaddingValues, viewModel: CalculateViewModel3) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val state = viewModel.state
        TwoCards(
            title1 = "Total",
            number1 = state.totalDiscount,
            title2 = "Discount",
            number2 = state.priceDiscount,
        )
        MainTextField(
            value = state.price,
            onValueChange = { viewModel.onValueChange(it, "price") },
            label = "Price"
        )
        SpaceH()
        MainTextField(
            value = state.discount,
            onValueChange = { viewModel.onValueChange(it, "discount") },
            label = "Discount %"
        )
        SpaceH(10.dp)
        MainButton(text = "Get Discount") {
            viewModel.calculate()
        }
        SpaceH()
        MainButton(text = "Clean", color = Color.Red) {
            viewModel.clean()
        }
        if (state.showAlert) {
            Alert(
                title = "Alert",
                message = "Complete all fields",
                confirmText = "Ok",
                onConfirmClick = { viewModel.cancelAlert() }) {}
        }
    }
}