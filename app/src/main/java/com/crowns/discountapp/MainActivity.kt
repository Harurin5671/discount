package com.crowns.discountapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.crowns.discountapp.ui.theme.DiscountAppTheme
import com.crowns.discountapp.viewModels.CalculateViewModel1
import com.crowns.discountapp.viewModels.CalculateViewModel2
import com.crowns.discountapp.viewModels.CalculateViewModel3
import com.crowns.discountapp.views.HomeView
import com.crowns.discountapp.views.HomeView2
import com.crowns.discountapp.views.HomeView3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: CalculateViewModel3 by viewModels()
        enableEdgeToEdge()
        setContent {
            DiscountAppTheme {
                HomeView3(viewModel = viewModel)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    val viewModelPreview = CalculateViewModel1()
    DiscountAppTheme {
        HomeView(viewModel = viewModelPreview)
    }
}