package com.crowns.discountapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.crowns.discountapp.ui.theme.DiscountAppTheme
import com.crowns.discountapp.views.HomeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiscountAppTheme {
                HomeView()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    DiscountAppTheme {
        HomeView()
    }
}