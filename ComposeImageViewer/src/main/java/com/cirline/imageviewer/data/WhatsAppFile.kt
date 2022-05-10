package com.cirline.imageviewer.data
import android.net.Uri
import android.text.Spannable
import android.text.style.ForegroundColorSpan

interface WhatsAppFile {
    val id: Long
    val displayName : Spannable
    val mimeStr : String?
    val bucketName : String?
    val dateMillis: Long
    val contentUri: Uri
    val dateStr: String
    val isSelected: Boolean
    val size: Long

    fun highlight(subStr : String, spanHighLight : ForegroundColorSpan)
}