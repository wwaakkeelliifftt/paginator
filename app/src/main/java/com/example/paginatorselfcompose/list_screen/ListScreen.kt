package com.example.paginatorselfcompose.list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.paginatorselfcompose.data.model.ListItem
import com.example.paginatorselfcompose.ui.theme.Purple200
import com.example.paginatorselfcompose.ui.theme.Purple700

@Composable
fun ListScreen(
    viewModel: ListScreenViewModel,
    modifier: Modifier
) {
    val state = viewModel.state
    LazyColumn(
        modifier = modifier
            .background(Purple700)
            .fillMaxSize()
            .padding(horizontal = 8.dp)
    ) {
        item { Spacer(modifier = Modifier.height(8.dp)) }
        items(count = state.items.size) { i ->
            val item = state.items[i]

            if (i >= state.items.size - 1 && !state.endReached && !state.isLoading) {
                viewModel.loadNextItems()
            }
            // item composable box
            ListItemBox(item = item)
            Spacer(modifier = Modifier.height(6.dp))
        }
        item { 
            if (state.isLoading) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                   CircularProgressIndicator()
                }
            }
        }
    }

}

@Composable
fun ListItemBox(item: ListItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Purple200)
            .border(width = 1.dp, color = Color.Magenta, shape = RoundedCornerShape(10.dp))
    ) {
        Text(
            text = item.title,
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
        )
        Text(
            text = item.description,
            fontWeight = FontWeight.ExtraLight,
            modifier = Modifier.padding(start = 8.dp, bottom = 2.dp)
        )
    }
}