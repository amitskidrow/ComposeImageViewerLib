package com.cirline.imageviewer

import android.text.format.DateUtils
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*


val sizes = arrayOf("Bytes", "KB", "MB", "GB", "TB")
fun bytesToSize(bytes: Long): String {
    if (bytes == 0L) return "0 Byte"
    val i = (Math.log(bytes.toDouble()) / Math.log(1024.0)).toInt()
    return DecimalFormat("#.00").format((bytes / Math.pow(1024.0, i.toDouble()))) +
            ' ' +
            sizes[i]
}

fun formatToDateStr(milliSeconds: Long, dateFormat: String?): String? {
    // Create a DateFormatter object for displaying date in specified format.
    val formatter = SimpleDateFormat(dateFormat)

    // Create a calendar object that will convert the date and time value in milliseconds to date.
    val calendar: Calendar = Calendar.getInstance()
    calendar.timeInMillis = milliSeconds
    return formatter.format(calendar.time)
}

fun convertTimeInHours(timeCreated: Long): String? {
    return DateUtils.getRelativeTimeSpanString(
        timeCreated,
        System.currentTimeMillis(),
        DateUtils.MINUTE_IN_MILLIS,
        DateUtils.FORMAT_ABBREV_ALL
    ).toString()
}