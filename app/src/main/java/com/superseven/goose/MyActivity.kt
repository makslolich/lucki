package com.superseven.goose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.superseven.goose.GameplayConstants.FIELD_CELLS_SIZE
import com.superseven.goose.model.ConstrType
import com.superseven.goose.model.ConstrType.ORIGINAL
import com.superseven.goose.model.ConstrType.PICTURE
import com.superseven.goose.model.Game
import com.superseven.goose.strategy.ContentStragy
import com.superseven.goose.strategy.OriginalStragy
import com.superseven.goose.strategy.PictureStragy


class MyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fieldLayout = findViewById<FrameLayout>(R.id.partRow)
        init(fieldLayout, intent)
    }

    private fun init(fieldLayout: FrameLayout, intent: Intent) {
        val strategy = getStrategy(fieldLayout.context, intent)
        val game = Game(strategy)
        game.init(fieldLayout)
    }

    private fun getStrategy(context: Context, intent: Intent): ContentStragy {
        val contentType = ConstrType.valueOf(intent.getStringExtra(IntentConstants.CONTENT_TYPE_PARAM_NAME))
        return when (contentType) {
            ORIGINAL -> OriginalStragy(R.drawable.srawbr, FIELD_CELLS_SIZE, FIELD_CELLS_SIZE)
            PICTURE -> {
                val imageResId = intent.getIntExtra(IntentConstants.IMAGE_RES_ID_PARAM_NAME, 0)
                return PictureStragy(imageResId, FIELD_CELLS_SIZE, FIELD_CELLS_SIZE, context)
            }
        }
    }

}
