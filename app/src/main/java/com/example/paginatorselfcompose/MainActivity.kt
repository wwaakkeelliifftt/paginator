package com.example.paginatorselfcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.paginatorselfcompose.list_screen.ListScreen
import com.example.paginatorselfcompose.list_screen.ListScreenViewModel
import com.example.paginatorselfcompose.ui.theme.PaginatorSelfComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaginatorSelfComposeTheme {
                val viewModel by viewModels<ListScreenViewModel>()
                ListScreen(
                    viewModel = viewModel,
                    modifier = Modifier
                )
            }
        }
    }
}
