package com.cirline.imageviewer.data

import android.net.Uri
import android.os.Parcelable
import androidx.documentfile.provider.DocumentFile
import com.cirline.imageviewer.convertTimeInHours
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import java.util.*
import java.util.concurrent.TimeUnit

@Parcelize
data class WhatsappImageViewHelper(
    val id: Long,
    val displayName: String,
    val bucketName: String?,
    val dateMillis: Long,
    val contentUri: Uri,
    val isSelected: Boolean,
    val size: Long,
) : Parcelable {
    val date: Date
        get() = Date(TimeUnit.SECONDS.toMillis(dateMillis))

    val dateStr: String
        get() = convertTimeInHours(dateMillis) ?: ""
}

@Parcelize
data class StatusDataModelHelper(
    val file : @RawValue DocumentFile,
    val mime : String,
    val dateStr : String,
    val dateCreated : Long,
) : Parcelable