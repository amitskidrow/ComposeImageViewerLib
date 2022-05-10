package com.cirline.imageviewer.zoomableviewer

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget

@Composable
fun ZoomableImage(
    imageUrl: String?,
    maxScale: Float = 4f,
    minScale: Float = 0.7f,
    onToggle: () -> Unit,
) {
    val scaleState = remember { mutableStateOf(1f) }
    val bitmapState = remember { mutableStateOf<Bitmap?>(null) }
    val translationState = remember { mutableStateOf(Offset(0f, 0f)) }
    fun calculateNewScale(k: Float): Float =
        if ((scaleState.value <= maxScale && k > 1f) || (scaleState.value >= minScale && k < 1f))
            scaleState.value * k
        else scaleState.value
    Glide.with(LocalContext.current).asBitmap()
        .load(imageUrl)
        .into(object : CustomTarget<Bitmap>() {
            override fun onLoadCleared(placeholder: Drawable?) {}
            override fun onResourceReady(
                resource: Bitmap,
                transition: com.bumptech.glide.request.transition.Transition<in Bitmap>?,
            ) {
                bitmapState.value = resource
            }
        })

    bitmapState.value?.let { loadedBitmap ->
        Image(
            bitmap = loadedBitmap.asImageBitmap(), contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .pointerInput(scaleState.value) {
                    detectTransformGestures { centroid, pan, zoom, rotation ->
                        Log.d("draggest",
                            "detectTransformGestures invoked :${centroid} + pan $pan, zoom $zoom,rotation $rotation}")
                        scaleState.value = calculateNewScale(zoom)
                    }
//                    detectDragGestures { change, dragAmount ->
//                        Log.d("draggest", "detectDragGestures invoked : change ${change} dragAmount : ${dragAmount}")
//                        translationState.value = translationState.value.plus(dragAmount)
//                    }
                }
                .graphicsLayer {
                    scaleX = scaleState.value
                    scaleY = scaleState.value
                    translationX = translationState.value.x
                    translationY = translationState.value.y
                }
                .clickable { onToggle() }
        )
    } ?: kotlin.run {
        Text("Loading Image...", color = Color.White)
    }
}
