package com.superseven.goose.strategy

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.widget.Button
import androidx.annotation.RequiresApi
import com.superseven.goose.model.Block
import com.superseven.goose.util.BitmapUtil

class PictureStrategy(private val imageResId: Int, x: Int, y: Int, context: Context) : AbstractContentStrategy(imageResId, x, y) {

    private val bitmapArray: Array<Array<Bitmap>>

    init {
        val picture = BitmapFactory.decodeResource(context.resources, imageResId)
        bitmapArray = BitmapUtil.cropImage(picture, x, y)
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun applyViewContent(cellButton: Button, block: Block, cellSize: Int) {
        val context = cellButton.context
        cellButton.background = BitmapDrawable(context.resources, bitmapArray[block.x][block.y])
    }


}
