package com.calmperson.gameoflife.ui.component

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Line(
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    strokeWidth: Dp
) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(strokeWidth)
    ) {
        drawRect(
            color = color,
            topLeft = Offset(0f, 0f),
            size = Size(size.width, size.height)

        )
    }
}