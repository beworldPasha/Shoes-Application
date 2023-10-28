package com.beworld.shoesapplication.feature_welcome.presentation.components

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun PagerIndicatorItem(currentPage: Int, iteration: Int) {
    val transition = updateTransition(
        targetState = currentPage == iteration,
        label = null
    )
    val itemWidth by transition.animateDp(label = "") { state ->
        when (state) {
            true -> 44.dp
            false -> 32.dp
        }
    }
    val color = if (currentPage == iteration) Color.White
    else Color(0xFFFFB21A)

    Box(
        modifier = Modifier
            .padding(2.dp)
            .clip(CircleShape)
            .background(color)
            .size(width = itemWidth, height = 8.dp)
    )
}