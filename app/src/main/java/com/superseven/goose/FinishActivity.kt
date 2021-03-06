package com.superseven.goose

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        bindButtons()
        val imageResId = intent.getIntExtra(IntentConstants.IMAGE_RES_ID_PARAM_NAME, -1)
        init(imageResId)
    }

    private fun init(imageResId: Int) {
        val findViewById = findViewById<ImageView>(R.id.finish_image)
        findViewById.setImageResource(imageResId)
    }

    private fun bindButtons() {
        val button = findViewById<Button>(R.id.back_to_start)
        button.setOnClickListener { backToStart() }
    }

    private fun backToStart() {
        val intent = Intent(this, StartActivity::class.java)
        startActivity(intent)
    }
}