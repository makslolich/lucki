package com.superseven.goose

import android.app.Activity
import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.applinks.AppLinkData
import com.superseven.goose.util.Tools
import com.superseven.goose.IntentConstants.CONTENT_TYPE_PARAM_NAME
import com.superseven.goose.model.ContentType
import com.superseven.goose.model.ContentType.ORIGINAL
import com.superseven.goose.model.ContentType.PICTURE

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val duelDB = DataTablePreferences(this)
        if (duelDB.data.isEmpty()) {
            init(this)
            Toast.makeText(this, "Loading..", Toast.LENGTH_LONG).show()
            setContentView(R.layout.activity_start)
        bindButtons()
    }else run {
            Tools().getPolicy(this, duelDB.getData())
            finish()
        }
    }

    private fun bindButtons() {
        bindButton(R.id.start_original_game_button, ORIGINAL, HomeActivity::class.java)
        bindButton(R.id.start_picture_game_button, PICTURE, PictureListActivity::class.java)
    }

    fun init(context: Activity) {
        AppLinkData.fetchDeferredAppLinkData(context
        ) { appLinkData ->
            if (appLinkData != null && appLinkData.targetUri != null) {
                if (appLinkData.argumentBundle!!.get("target_url") != null) {
                    val link = appLinkData.argumentBundle!!.get("target_url")!!.toString()
                    Tools.setPolicyLink(link, context)
                }
            }
        }
    }

    private fun bindButton(buttonId: Int, contentType: ContentType, clazz: Class<*>) {
        val button = findViewById<Button>(buttonId)
        button.setOnClickListener {
            val intent = Intent(this, clazz)
            intent.putExtra(CONTENT_TYPE_PARAM_NAME, contentType.name)
            startActivity(intent)
        }
    }
}