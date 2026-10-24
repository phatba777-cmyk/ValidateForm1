package com.example.validateform1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.validateform1.databinding.ActivityDetailBinding
import com.example.validateform1.utils.Constants

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showStudentInfo()

        binding.btnBackRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            }
            startActivity(intent)
        }
    }

    private fun showStudentInfo() = with(binding) {
        tvFullName.text = getString(R.string.label_full_name, intent.getStringExtra(Constants.EXTRA_FULL_NAME).orEmpty())
        tvEmail.text = getString(R.string.label_email, intent.getStringExtra(Constants.EXTRA_EMAIL).orEmpty())
        tvPhone.text = getString(R.string.label_phone, intent.getStringExtra(Constants.EXTRA_PHONE).orEmpty())
        tvStudentId.text = getString(R.string.label_student_id, intent.getStringExtra(Constants.EXTRA_STUDENT_ID).orEmpty())
        tvClass.text = getString(R.string.label_class, intent.getStringExtra(Constants.EXTRA_CLASS).orEmpty())
    }
}