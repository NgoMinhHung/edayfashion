package com.crazyteam.edayfashion.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.crazyteam.edayfashion.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class ActivityDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val id = intent.getIntExtra("ID", 0)
        tvId.text = "id item = " + id.toString();
    }
}