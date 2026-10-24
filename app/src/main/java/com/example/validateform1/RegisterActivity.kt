package com.example.validateform1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.validateform1.databinding.ActivityRegisterBinding
import com.example.validateform1.utils.ValidationHelper
import com.example.validateform1.utils.setErrorRes
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
            // Câu 3 sẽ xử lý khi tất cả hợp lệ
        }
    }
}