package com.example.validateform1.utils

import androidx.annotation.StringRes
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

fun TextInputEditText.trimmedText(): String = text?.toString()?.trim().orEmpty()

// resId = null thì xóa lỗi
fun TextInputLayout.setErrorRes(@StringRes resId: Int?) {
    error = resId?.let { context.getString(it) }
}