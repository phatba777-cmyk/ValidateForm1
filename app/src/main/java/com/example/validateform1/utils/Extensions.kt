package com.example.validateform1.utils

import android.view.View
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

fun TextInputEditText.trimmedText(): String = text?.toString()?.trim().orEmpty()

// resId = null thì xóa lỗi
fun TextInputLayout.setErrorRes(@StringRes resId: Int?) {
    error = resId?.let { context.getString(it) }
}

fun View.showSnackbarWithAction(
    @StringRes message: Int,
    @StringRes actionText: Int,
    onAction: () -> Unit
) {
    Snackbar.make(this, message, Snackbar.LENGTH_INDEFINITE)
        .setDuration(8000)
        .setAction(actionText) { onAction() }
        .show()
}