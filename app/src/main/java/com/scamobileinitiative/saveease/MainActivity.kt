package com.scamobileinitiative.saveease

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.Serializable

class MainActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent: Intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }


}
