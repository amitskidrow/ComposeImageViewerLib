package com.cirline.imageviewer.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.SystemUiController
import com.cirline.imageviewer.zoomableviewer.ZoomableImage

@OptIn(ExperimentalPagerApi::class)
@Composable
fun imageviewPagerComposable(
    systemUiController: SystemUiController,
    activeImgIndex: Int = 0,
    toggleAppbarVisibility: () -> Unit,
    onDestroy: () -> Unit,
    imageUriList: Array<String?>? = emptyArray(),
) {
    if (imageUriList?.isEmpty()!!) return
    ZoomableImage(imageUrl = imageUriList.get(activeImgIndex)) {
        systemUiController.isStatusBarVisible =
            !systemUiController.isStatusBarVisible // Status bar
        systemUiController.isNavigationBarVisible =
            !systemUiController.isNavigationBarVisible  // Navigation bar
        systemUiController.isSystemBarsVisible =
            !systemUiController.isSystemBarsVisible // Status & Navigation bars
        toggleAppbarVisibility()
    }
    // If `lifecycleOwner` changes, dispose and reset the effect
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        // Create an observer that triggers our remembered callbacks
        // for sending analytics events
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_STOP) onDestroy()
        }
        // Add the observer to the lifecycle
        lifecycleOwner.lifecycle.addObserver(observer)
        // When the effect leaves the Composition, remove the observer
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}