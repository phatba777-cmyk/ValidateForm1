package com.example.validateform1.utils

import android.util.Patterns
import androidx.annotation.StringRes
import com.example.validateform1.R

object ValidationHelper {

    private val NAME_REGEX = Regex("^[\\p{L} ]{2,50}$")
    private val PHONE_REGEX = Regex("^0\\d{9}$")
    private val STUDENT_ID_REGEX = Regex("^[A-Za-z0-9]{6,12}$")
    private val CLASS_REGEX = Regex("^[A-Za-z0-9._-]{2,20}$")

    // Trả về id chuỗi lỗi, null nghĩa là hợp lệ
    @StringRes
    fun validateFullName(value: String): Int? = when {
        value.isEmpty() -> R.string.err_name_empty
        !NAME_REGEX.matches(value) -> R.string.err_name_invalid
        else -> null
    }

    @StringRes
    fun validateEmail(value: String): Int? = when {
        value.isEmpty() -> R.string.err_email_empty
        !Patterns.EMAIL_ADDRESS.matcher(value).matches() -> R.string.err_email_invalid
        else -> null
    }

    @StringRes
    fun validatePhone(value: String): Int? = when {
        value.isEmpty() -> R.string.err_phone_empty
        !PHONE_REGEX.matches(value) -> R.string.err_phone_invalid
        else -> null
    }

    @StringRes
    fun validateStudentId(value: String): Int? = when {
        value.isEmpty() -> R.string.err_student_id_empty
        !STUDENT_ID_REGEX.matches(value) -> R.string.err_student_id_invalid
        else -> null
    }

    @StringRes
    fun validateClass(value: String): Int? = when {
        value.isEmpty() -> R.string.err_class_empty
        !CLASS_REGEX.matches(value) -> R.string.err_class_invalid
        else -> null
    }
}