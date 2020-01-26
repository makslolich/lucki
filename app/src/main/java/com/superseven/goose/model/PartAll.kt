package com.superseven.goose.model

import com.superseven.goose.model.Part
import java.io.Serializable

class PartAll(val x: Int, val y: Int) : Serializable {

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
        return "PartAll[ x[$x] - y[$y] - part[$part]]"
    }
}
