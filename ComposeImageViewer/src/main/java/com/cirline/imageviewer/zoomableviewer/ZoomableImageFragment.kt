package com.cirline.imageviewer.zoomableviewer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

class ZoomableImageFragment : Fragment() {
    //    private var imageUrl: String? = null
    private lateinit var imageList: List<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageList = it.getStringArrayList(ARG_IMAGE_ARRAY)?.toList() ?: emptyList()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList(ARG_IMAGE_ARRAY, arrayListOf(*imageList.toTypedArray()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = ComposeView(requireContext()).apply {
        setContent {
            MaterialTheme {
//                ZoomableImage(imageList.first())
            }
        }
    }

    companion object {
        const val ARG_IMAGE_ARRAY = "ARG_IMAGE_ARRAY_URL"

        @JvmStatic
        fun newInstance(imageArr: Array<String>): ZoomableImageFragment {
            val instance = ZoomableImageFragment()
            val args = Bundle()
            args.putStringArray("someInt", imageArr)
            instance.arguments = args
            return instance
        }
    }
}
