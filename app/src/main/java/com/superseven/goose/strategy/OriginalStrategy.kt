package com.superseven.goose.strategy

import android.widget.Button
import com.superseven.goose.R
import com.superseven.goose.GameplayConstants.FIELD_CELLS_SIZE

import com.superseven.goose.model.Block

class OriginalStrategy(finishImageResId: Int, x: Int, y: Int) : AbstractContentStrategy(finishImageResId, x, y) {

    override fun applyViewContent(cellButton: Button, block: Block, cellSize: Int) {
        cellButton.setBackgroundResource(R.drawable.border)
        cellButton.text = (block.y * FIELD_CELLS_SIZE + block.x + 1).toString()
        cellButton.textSize = (cellSize / 5).toFloat()
    }
}
