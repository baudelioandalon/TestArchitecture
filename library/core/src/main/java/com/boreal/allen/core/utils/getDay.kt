package com.boreal.allen.core.utils

import com.google.firebase.Timestamp
import java.text.SimpleDateFormat
import java.util.*

fun Timestamp.getDay(format: String = "dd", locale: Locale = Locale("es", "MX")) =
    SimpleDateFormat(format, locale).format(Date(toDate().time)).capitalize(locale)

fun Timestamp.getMonth(format: String = "MM", locale: Locale = Locale("es", "MX")) =
    SimpleDateFormat(format, locale).format(Date(toDate().time)).capitalize(locale)

fun Timestamp.getYear(format: String = "yyyy", locale: Locale = Locale("es", "MX")) =
    SimpleDateFormat(format, locale).format(Date(toDate().time)).capitalize(locale)

fun String.toTimestamp(
    format: String = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX",
    locale: Locale = Locale("es", "MX")
) = with(Calendar.getInstance()) {
    try{
        time = SimpleDateFormat(format, locale).parse("${this@toTimestamp}")
        Timestamp(Date(time.time))
    }catch (exception: Exception){
        Timestamp(Date(time.time))
    }
}