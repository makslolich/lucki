package com.superseven.goose.strategy

abstract class AbstractContentStragy(private val imageResId: Int,
                                     private val x: Int,
                                     private val y: Int) : ContentStragy {

    override fun getFieldHeight(): Int = x
    override fun getFieldWidth(): Int = y
    override fun getFinishImageId(): Int = imageResId

}
