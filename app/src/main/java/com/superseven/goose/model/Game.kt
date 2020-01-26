package com.superseven.goose.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import com.superseven.goose.BlockClickListener
import com.superseven.goose.R
import com.superseven.goose.sound.SilentSoundPlayer
import com.superseven.goose.sound.SoundPlayer
import com.superseven.goose.strategy.ContentStragy
import java.io.Serializable

class Game(private val stragy: ContentStragy) : Serializable {

    private val partRow: PartRow = PartRow(stragy.getFieldHeight(), stragy.getFieldWidth())
    private var soundPlayer: SoundPlayer = SilentSoundPlayer()
    private var cellSize: Int = 50

    fun init(parentLayout: FrameLayout) {
        cellSize = parentLayout.layoutParams.height / stragy.getFieldHeight()
        initField(parentLayout)
    }

    private fun initField(parentLayout: FrameLayout) {
        for (i in 0 until partRow.height) {
            for (j in 0 until partRow.width) {
                val cell = partRow.cell(i, j)
                val empty = i == 3 && j == 3
                cell.part = Part(i, j, createCellLayout(parentLayout, cell, empty), empty)
            }
        }
    }

    private fun createCellLayout(parentLayout: FrameLayout, gamePartBl: GamePartBl, empty: Boolean): View {
        val cellLayout = loadCell(parentLayout.context) as FrameLayout

        val params = FrameLayout.LayoutParams(cellSize, cellSize)
        params.setMargins(gamePartBl.x * cellSize, gamePartBl.y * cellSize, 0, 0)
        cellLayout.layoutParams = params

        val cellButton = cellLayout.findViewById<Button>(R.id.cell_button)
        cellButton.setOnClickListener(BlockClickListener(gamePartBl, partRow, cellSize, parentLayout.context, soundPlayer, stragy.getFinishImageId()))
        stragy.applyViewContent(cellButton, gamePartBl, cellSize)

        cellLayout.visibility = if (empty) View.INVISIBLE else View.VISIBLE

        parentLayout.addView(cellLayout, 0, params)
        return cellLayout
    }

    private fun loadCell(context: Context): View {
        val systemService = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return systemService.inflate(R.layout.cell_layout, null)
    }
}
