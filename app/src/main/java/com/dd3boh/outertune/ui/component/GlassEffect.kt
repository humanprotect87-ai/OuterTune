package com.dd3boh.outertune.ui.component

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

fun Modifier.ultraGlass(): Modifier {
    return this
        .clip(RoundedCornerShape(28.dp))
        .background(
            brush = Brush.linearGradient(
                colors = listOf(
                    Color.White.copy(alpha = 0.22f),
                    MaterialTheme.colorScheme.surface.copy(alpha = 0.12f)
                )
            )
        )
        .border(
            width = 1.dp,
            color = Color.White.copy(alpha = 0.25f),
            shape = RoundedCornerShape(28.dp)
        )
        .graphicsLayer {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                renderEffect = RenderEffect.createBlurEffect(
                    35f,
                    35f,
                    Shader.TileMode.CLAMP
                )
            }
        }
}
