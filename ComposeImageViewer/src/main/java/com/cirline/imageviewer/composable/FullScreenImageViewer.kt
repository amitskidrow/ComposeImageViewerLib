package com.cirline.imageviewer.composable

import android.content.Context
import android.os.Build
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.size.Scale
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.whatsapp.composeimageviewer.R
import com.cirline.imageviewer.bytesToSize
import com.cirline.imageviewer.data.StatusDataModelHelper
import com.cirline.imageviewer.data.WhatsAppFile

@OptIn(ExperimentalComposeUiApi::class, ExperimentalPagerApi::class)
@Composable
fun FullScreenImageViewer(
    showDialog : Boolean,
    imageList : List<WhatsAppFile>,
    initialPageIndex : Int,
    onClose: () -> Unit,
    share : () -> Unit,
    info : () -> Unit,
    delete : () -> Unit,
    openwith : () -> Unit,
) {
    val pagerState = rememberPagerState(initialPage = initialPageIndex)
    val currentPagerState = remember{ mutableStateOf(initialPageIndex) }
    val context = LocalContext.current
    if (showDialog) {
        Dialog(onDismissRequest = onClose,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                usePlatformDefaultWidth = false
            )
        ) {
            Surface(
                modifier = Modifier
                    .padding(horizontal = 4.dp, vertical = 2.dp)
                    .fillMaxSize(),
                shape = RoundedCornerShape(4.dp),
                color = MaterialTheme.colors.surface
            ) {
                Column(modifier = Modifier
                    .background(color = MaterialTheme.colors.surface)
                    .fillMaxSize()) {
                    /* add support for rename */
                    /*  menu bar with overflow menu */
                    /* add support for gif imageviewer */
                        ImageInfoHeader(imageList[currentPagerState.value], null)
                        HorizontalPager(
                            state = pagerState,
                            modifier = Modifier.weight(1f),
                            count = imageList.size,
                        ) { index ->
                            currentPagerState.value = index
                            CoilImageViewComposable(context, imageList[index],null)
                        }
                    ImageViewerMenuBar(share, info, delete, openwith)
                }
            }
        }
    }
}

enum class BoxState { Collapsed, Expanded }

@Composable
fun AnimatingBox(boxState: BoxState) {
    val transitionData = updateTransitionData(boxState)
    // UI tree
    Box(
        modifier = Modifier
            .background(color  = transitionData.color.value)
//            .height(transitionData.height)
//            .width(transitionData.height)
    )
}

// Holds the animation values.
private class TransitionData(
    val color: State<Color>,
    val height: State<Dp>,
    val width: State<Dp>
)

// Create a Transition and return its animation values.
@Composable
private fun updateTransitionData(boxState: BoxState): TransitionData {
    LocalConfiguration.current.screenWidthDp
    val transition = updateTransition(boxState)
    val color = transition.animateColor { state ->
        when (state) {
            BoxState.Collapsed -> Color.Gray
            BoxState.Expanded -> Color.Red
        }
    }
    val height = transition.animateDp { state ->
        when (state) {
            BoxState.Collapsed -> 64.dp
            BoxState.Expanded -> 128.dp
        }
    }
    val width = transition.animateDp { state ->
        when (state) {
            BoxState.Collapsed -> 64.dp
            BoxState.Expanded -> 128.dp
        }
    }
    return remember(transition) { TransitionData(color, height,width) }
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FullScreenStatusViewer(
    showDialog: Boolean,
    statusHelper: StatusDataModelHelper,
    onClose: () -> Unit,
    share : () -> Unit,
    delete : () -> Unit,
    openwith : () -> Unit,
) {
    val context = LocalContext.current
    if (showDialog) {
        Dialog(onDismissRequest = onClose,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                usePlatformDefaultWidth = true
            )
        ) {
            Surface(
                modifier = Modifier
                    .padding(horizontal = 4.dp, vertical = 2.dp)
                    .fillMaxSize(),
                shape = RoundedCornerShape(4.dp),
                color = MaterialTheme.colors.surface
            ) {
                Column(modifier = Modifier
                    .background(color = MaterialTheme.colors.surface)
                    .fillMaxSize()) {
                    /* add support for rename */
                    /*  menu bar with overflow menu */
                    ImageInfoHeader(statushelper = statusHelper, whatsappImage = null)
                    /* add support for gif imageviewer */
                    Box(modifier = Modifier.weight(1f)) {
                        CoilImageViewComposable(context, statushelper = statusHelper, whatsappImage = null)
                    }
                    ImageViewerMenuBar(share, null, delete, openwith)
                }
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
private fun CoilImageViewComposable(
    context: Context,
    whatsappImage: WhatsAppFile?,
    statushelper: StatusDataModelHelper?,
) {
    val imageLoader = ImageLoader.Builder(context)
        .componentRegistry {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder(context))
            } else {
                add(GifDecoder())
            }
        }
        .build()
    val painter = rememberImagePainter(
        data = when {
            whatsappImage != null -> whatsappImage.contentUri
            statushelper != null -> statushelper.file
            else -> ""
         },
        imageLoader = imageLoader,
        builder = {
            scale(Scale.FIT)
        }
    )

    val scale = remember { mutableStateOf(1f) }
    val rotationState = remember { mutableStateOf(1f) }
    Box(modifier = Modifier
        .clip(RectangleShape) // Clip the box content
        .fillMaxSize() // Give the size you want...
        .background(MaterialTheme.colors.background)
        .pointerInput(Unit) {
//            detectTapGestures(onDoubleTap = {
//                scale.value *= .20f
//            })
            detectTransformGestures { centroid, pan, zoom, rotation ->
                scale.value *= zoom
                rotationState.value += rotation
            }
        }) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Inside,
            modifier =  Modifier
                .align(alignment = Alignment.Center)
                .graphicsLayer(
                    // adding some zoom limits (min 50%, max 200%)
                    scaleX = maxOf(.5f, minOf(3f, scale.value)),
                    scaleY = maxOf(.5f, minOf(3f, scale.value)),
                    rotationZ = rotationState.value
                )
                .fillMaxSize()
        )
    }
}

@Composable
private fun ImageViewerMenuBar(
    share : () -> Unit,
    info : (() -> Unit)?,
    delete : () -> Unit,
    openwith : () -> Unit,
) {
    Row(modifier = Modifier
        .height(height = 48.dp)
        .fillMaxWidth()
        .background(color = MaterialTheme.colors.background)) {
        /*  share  */
        IconButton(onClick = share, modifier = Modifier.weight(1f)) {
            Icon(
                imageVector = Icons.Outlined.Share,
                contentDescription = "More Options",
                tint = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .padding(all = 10.dp)
                    .size(size = 48.dp)
            ) // vertical more icon
        }
        /*  Info  */
        if(info != null) {
            IconButton(onClick = info, modifier = Modifier.weight(1f)) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "More Options",
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .padding(all = 10.dp)
                        .size(size = 48.dp)
                ) // vertical more icon
            }
        }

        /*  Delete  */
        IconButton(onClick = delete, modifier = Modifier.weight(1f)) {
            Icon(
                imageVector = Icons.Outlined.Delete,
                contentDescription = "More Options",
                tint = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .padding(all = 10.dp)
                    .size(size = 48.dp)
            ) // vertical more icon
        }

        /*  openwith  */
        IconButton(onClick = openwith, modifier = Modifier.weight(1f)) {
            Icon(
                painter = painterResource(id = R.drawable.vector_icon_open_with),
                contentDescription = "More Options",
                tint = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .padding(all = 0.dp)
                    .size(size = 48.dp)
            ) // vertical more icon
        }
    }
}

@Composable
private fun ImageInfoHeader(whatsappImage: WhatsAppFile?, statushelper: StatusDataModelHelper?) {
    /* header */
    /* filename |  size : date */
    Column(modifier = Modifier
        .background(color = MaterialTheme.colors.background)
        .height(height = 56.dp)
        .fillMaxWidth()
        .padding(vertical = 4.dp, horizontal = 8.dp), verticalArrangement = Arrangement.Center) {
        Text(
            text = when {
                whatsappImage != null -> whatsappImage.displayName.toString()
                statushelper != null -> statushelper.file.name.toString()
                else -> ""
            },
            style = TextStyle(color = MaterialTheme.colors.onBackground, fontSize = 14.sp),
            modifier = Modifier
                .wrapContentSize(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Row(
            modifier = Modifier
                .wrapContentSize()
                .graphicsLayer { alpha = .8f },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                // file size
                Text(
                    text = bytesToSize(
                        when {
                            whatsappImage != null -> whatsappImage.size
                            statushelper != null -> statushelper.file.length()
                            else -> 0
                        }
                    ),
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.caption.copy(fontSize = 12.sp),
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(horizontal = 4.dp)
                )
                // date
                Text(
                    text = when {
                        whatsappImage != null -> whatsappImage.dateStr
                        statushelper != null -> statushelper.dateStr
                        else -> ""
                    },
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.caption.copy(fontSize = 12.sp),
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .wrapContentHeight()
                )
            } // Row
        } // row
    } // header col
}

