package com.superseven.goose.strategy

import android.widget.Button

import com.superseven.goose.model.Block

interface ContentStrategy {

    fun applyViewContent(cellButton: Button, block: Block, cellSize: Int)

    fun getFinishImageId() : Int

    fun getFieldHeight() : Int

    fun getFieldWidth() : Int
}
