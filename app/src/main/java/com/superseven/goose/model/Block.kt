package com.superseven.goose.model

import java.io.Serializable

class Block(val x: Int, val y: Int) : Serializable {

    var part: Part? = null

    fun isEmpty(): Boolean {
        return part!!.empty
    }

    fun isNotEmpty(): Boolean {
        return !part!!.empty
    }

    fun containsProperPart(): Boolean {
        return part!!.originX == x && part!!.originY == y
    }

    override fun toString(): String {
        return "Block[ x[$x] - y[$y] - part[$part]]"
    }
}
