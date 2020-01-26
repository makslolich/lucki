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
import com.superseven.goose.strategy.ContentStrategy
import java.io.Serializable

class Game(private val strategy: ContentStrategy) : Serializable {

    private val field: Field = Field(strategy.getFieldHeight(), strategy.getFieldWidth())
    private var soundPlayer: SoundPlayer = SilentSoundPlayer()
    private var cellSize: Int = 50

    fun init(parentLayout: FrameLayout) {
        cellSize = parentLayout.layoutParams.height / strategy.getFieldHeight()
        initField(parentLayout)
    }

    private fun initField(parentLayout: FrameLayout) {
        for (i in 0 until field.height) {
            for (j in 0 until field.width) {
                val cell = field.cell(i, j)
                val empty = i == 3 && j == 3
                cell.part = Part(i, j, createCellLayout(parentLayout, cell, empty), empty)
            }
        }
    }

    private fun createCellLayout(parentLayout: FrameLayout, block: Block, empty: Boolean): View {
        val cellLayout = loadCell(parentLayout.context) as FrameLayout

        val params = FrameLayout.LayoutParams(cellSize, cellSize)
        params.setMargins(block.x * cellSize, block.y * cellSize, 0, 0)
        cellLayout.layoutParams = params

        val cellButton = cellLayout.findViewById<Button>(R.id.cell_button)
        cellButton.setOnClickListener(BlockClickListener(block, field, cellSize, parentLayout.context, soundPlayer, strategy.getFinishImageId()))
        strategy.applyViewContent(cellButton, block, cellSize)

        cellLayout.visibility = if (empty) View.INVISIBLE else View.VISIBLE

        parentLayout.addView(cellLayout, 0, params)
        return cellLayout
    }

    private fun loadCell(context: Context): View {
        val systemService = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return systemService.inflate(R.layout.cell_layout, null)
    }
}
