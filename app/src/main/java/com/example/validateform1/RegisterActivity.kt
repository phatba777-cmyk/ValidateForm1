package com.example.validateform1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.validateform1.databinding.ActivityRegisterBinding
import com.example.validateform1.utils.ValidationHelper
import com.example.validateform1.utils.createDetailIntent
import com.example.validateform1.utils.setErrorRes
import com.example.validateform1.utils.showSnackbarWithAction
import com.example.validateform1.utils.trimmedText

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGoDetail.setOnClickListener {
            startActivity(Intent(this, DetailActivity::class.java))
        }

        binding.btnRegister.setOnClickListener { handleRegister() }
    }

    private fun handleRegister() = with(binding) {
        val results = listOf(
            tilFullName to ValidationHelper.validateFullName(edtFullName.trimmedText()),
            tilEmail to ValidationHelper.validateEmail(edtEmail.trimmedText()),
            tilPhone to ValidationHelper.validatePhone(edtPhone.trimmedText()),
            tilStudentId to ValidationHelper.validateStudentId(edtStudentId.trimmedText()),
            tilClass to ValidationHelper.validateClass(edtClass.trimmedText())
        )

        // Hiện lỗi (hoặc xóa lỗi) cho từng ô
        results.forEach { (layout, error) -> layout.setErrorRes(error) }

        val isAllValid = results.all { it.second == null }
        if (isAllValid) {
            val name = edtFullName.trimmedText()
            val email = edtEmail.trimmedText()
            val phone = edtPhone.trimmedText()
            val studentId = edtStudentId.trimmedText()
            val className = edtClass.trimmedText()

            root.showSnackbarWithAction(
                message = R.string.msg_register_success,
                actionText = R.string.action_detail
            ) {
                startActivity(createDetailIntent(name, email, phone, studentId, className))
            }
        }
    }
}