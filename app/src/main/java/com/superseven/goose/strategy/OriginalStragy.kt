package com.superseven.goose.strategy

import android.widget.Button
import com.superseven.goose.R
import com.superseven.goose.GameplayConstants.FIELD_CELLS_SIZE

import com.superseven.goose.model.GamePartBl

class OriginalStragy(finishImageResId: Int, x: Int, y: Int) : AbstractContentStragy(finishImageResId, x, y) {

    override fun applyViewContent(cellButton: Button, gamePartBl: GamePartBl, cellSize: Int) {
        cellButton.setBackgroundResource(R.drawable.border)
        cellButton.text = (gamePartBl.y * FIELD_CELLS_SIZE + gamePartBl.x + 1).toString()
        cellButton.textSize = (cellSize / 5).toFloat()
    }
}
