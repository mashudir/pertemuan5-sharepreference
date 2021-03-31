package com.mashudi.fintech

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var btnSubmit : Button
    private lateinit var etNim : EditText
    private lateinit var etName : EditText
    private lateinit var tvWelcome: TextView
    lateinit var pref: PreferenceUtil
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pref = PreferenceUtil.newInstance(this)

        if (pref.getBoolean("isLogin")) {
            val intentMainActivity = Intent(this,MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(intentMainActivity)
        }

        etNim = findViewById(R.id.etNim)
        etName = findViewById(R.id.etName)
        btnSubmit = findViewById(R.id.btSubmit)
        tvWelcome = findViewById(R.id.tv_welcome)
        updateData()
        btnSubmit.setOnClickListener {
            val nama = etName.text.toString()
            Toast.makeText(this, nama, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun updateData() {
        val nama = pref.getString("nama")
        val welcomemessage = "Welcome .$nama"
        tvWelcome.text= welcomemessage

        if (nama.isNullOrEmpty()) {
            tvWelcome.visibility = View.GONE
        }else{
            tvWelcome.visibility = View.VISIBLE
        }
    }
}