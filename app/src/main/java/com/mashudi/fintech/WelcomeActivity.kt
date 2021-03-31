package com.mashudi.fintech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class WelcomeActivity : AppCompatActivity() {
    lateinit var etNama: EditText
    lateinit var btSubmit: Button
    lateinit var pref: PreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        pref = PreferenceUtil.newInstance(this)
        etNama = findViewById(R.id.et_nama)
        btSubmit = findViewById(R.id.bt_submit)
        etNama.setText(pref.getString("nama"))
        btSubmit.setOnClickListener {
            saveData()
            val intentMainActivity = Intent(this,MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(intentMainActivity)
        }
    }

    private fun saveData(){
        val nama = etNama.toString().trim()
        pref.setString("nama", nama)
        pref.setBoolean("isLogin", true)
    }
}