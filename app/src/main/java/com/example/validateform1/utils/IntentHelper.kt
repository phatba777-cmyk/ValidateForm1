package com.example.validateform1.utils

import android.content.Context
import android.content.Intent
import com.example.validateform1.DetailActivity

fun Context.createDetailIntent(
    fullName: String,
    email: String,
    phone: String,
    studentId: String,
    className: String
): Intent = Intent(this, DetailActivity::class.java).apply {
    putExtra(Constants.EXTRA_FULL_NAME, fullName)
    putExtra(Constants.EXTRA_EMAIL, email)
    putExtra(Constants.EXTRA_PHONE, phone)
    putExtra(Constants.EXTRA_STUDENT_ID, studentId)
    putExtra(Constants.EXTRA_CLASS, className)
}