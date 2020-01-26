package com.superseven.goose.model

import java.io.Serializable

class PartRow(val height: Int,
              val width: Int) : Serializable {

    private var matrices: Array<Array<GamePartBl>>

    init {
        matrices = Array(height) { x ->
            Array(width) { y -> GamePartBl(x, y) }
        }
    }

    fun cell(x: Int, y: Int): GamePartBl {
        return matrices[x][y]
    }

    fun correct(): Boolean {
        matrices.forEach { cells -> cells.filterNot { it.containsProperPart() }.forEach { return false } }
        return true
    }


}