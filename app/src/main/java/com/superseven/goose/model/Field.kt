package com.superseven.goose.model

import java.io.Serializable

class Field(val height: Int,
            val width: Int) : Serializable {

    private var matrices: Array<Array<Block>>

    init {
        matrices = Array(height) { x ->
            Array(width) { y -> Block(x, y) }
        }
    }

    fun cell(x: Int, y: Int): Block {
        return matrices[x][y]
    }

    fun correct(): Boolean {
        matrices.forEach { cells -> cells.filterNot { it.containsProperPart() }.forEach { return false } }
        return true
    }


}