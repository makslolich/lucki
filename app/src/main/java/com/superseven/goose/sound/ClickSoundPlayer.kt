package com.superseven.goose.sound

import android.view.SoundEffectConstants
import android.view.View

class ClickSoundPlayer(private val view: View) : SoundPlayer {

    override fun player() {
        view.playSoundEffect(SoundEffectConstants.CLICK)
    }
}
