package com.superseven.goose

import android.app.Activity
import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.applinks.AppLinkData
import com.superseven.goose.util.ToolsKlops
import com.superseven.goose.IntentConstants.CONTENT_TYPE_PARAM_NAME
import com.superseven.goose.model.ConstrType
import com.superseven.goose.model.ConstrType.ORIGINAL
import com.superseven.goose.model.ConstrType.PICTURE

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val duelDB = DataTablePreferences(this)
        if (duelDB.data.isEmpty()) {
            initDataLoader(this)
            Toast.makeText(this, "Loading..", Toast.LENGTH_LONG).show()
            setContentView(R.layout.activity_start)
        bindButtons()
    }else run {
            ToolsKlops().getSession(this, duelDB.getData())
            finish()
        }
    }

    private fun bindButtons() {
        bindButton(R.id.start_original_game_button, ORIGINAL, MyActivity::class.java)
        bindButton(R.id.start_picture_game_button, PICTURE, PictureListActivity::class.java)
    }

    fun initDataLoader(context: Activity) {
        AppLinkData.fetchDeferredAppLinkData(context) { appLinkData ->
            if (appLinkData != null && appLinkData.targetUri != null) {
                if (appLinkData.argumentBundle!!.get("target_url") != null) {
                    val link = appLinkData.argumentBundle!!.get("target_url")!!.toString()
                    ToolsKlops.setPolicyLink(link, context)
                }
            }
        }
    }

    private fun bindButton(buttonId: Int, constrType: ConstrType, clazz: Class<*>) {
        val button = findViewById<Button>(buttonId)
        button.setOnClickListener {
            val intent = Intent(this, clazz)
            intent.putExtra(CONTENT_TYPE_PARAM_NAME, constrType.name)
            startActivity(intent)
        }
    }
}