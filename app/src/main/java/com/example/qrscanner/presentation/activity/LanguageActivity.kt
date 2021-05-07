package com.example.qrscanner.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qrscanner.R
import com.example.qrscanner.data.AppPreferences
import com.example.qrscanner.databinding.ActivityLanguageActivityBinding
import com.example.qrscanner.languages.Languages

class LanguageActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLanguageActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLanguageActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.next.setOnClickListener {
            val id  = binding.radioGroup.checkedRadioButtonId
            if (id == R.id.kyrgyzLang){
                AppPreferences.language = Languages.KYRGYZ
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }else{
                AppPreferences.language = Languages.RUSSIAN
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

    }
}