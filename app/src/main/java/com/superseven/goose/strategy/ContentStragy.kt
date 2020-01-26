package com.superseven.goose.strategy

import android.widget.Button

import com.superseven.goose.model.GamePartBl

interface ContentStragy {

    fun applyViewContent(cellButton: Button, gamePartBl: GamePartBl, cellSize: Int)

    fun getFinishImageId() : Int

    fun getFieldHeight() : Int

    fun getFieldWidth() : Int
}
