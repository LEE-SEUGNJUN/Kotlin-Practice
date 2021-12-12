package com.seugnjunlee.androidpreference

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.seugnjunlee.androidpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val sharedGetPreferences = getSharedPreferences("AndroidPref",Context.MODE_PRIVATE)
        val checkStore = sharedGetPreferences.getBoolean("prefStore",false)
        if (checkStore){
            binding.checkStore.isChecked = true
            binding.editEmail.setText(sharedGetPreferences.getString("prefEmail",""))
            binding.editPassWord.setText(sharedGetPreferences.getString("prefPassWord",""))
        }

        binding.btnSave.setOnClickListener {
            val editPreferences = sharedGetPreferences.edit()
            if (binding.checkStore.isChecked) {
                editPreferences.putBoolean("prefStore", true)
                editPreferences.putString("prefEmail", binding.editEmail.text.toString())
                editPreferences.putString("prefPassWord", binding.editPassWord.text.toString())
                editPreferences.apply()
            } else {
                editPreferences.putBoolean("prefStore", false)
                editPreferences.putString("prefEmail", "")
                editPreferences.putString("prefPassWord", "")
                editPreferences.apply()
            }

        }
    }



}