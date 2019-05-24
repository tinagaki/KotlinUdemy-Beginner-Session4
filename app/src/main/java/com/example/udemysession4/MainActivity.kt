package com.example.udemysession4

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var soundPool: SoundPool
    var soundId: Int = 0
    var soundId2: Int = 0
    var soundId3: Int = 0
    var soundId4: Int = 0
    var soundId5: Int = 0
    var soundId6: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener { soundPool.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f) }

        button2.setOnClickListener { soundPool.play(soundId2, 1.0f, 1.0f, 1, 0, 1.0f) }

        button3.setOnClickListener { soundPool.play(soundId3, 1.0f, 1.0f, 1, 0, 1.0f) }
        button4.setOnClickListener { soundPool.play(soundId4, 1.0f, 1.0f, 1, 0, 1.0f) }
        button5.setOnClickListener { soundPool.play(soundId5, 1.0f, 1.0f, 1, 0, 1.0f) }
        button6.setOnClickListener { soundPool.play(soundId6, 1.0f, 1.0f, 1, 0, 1.0f) }

    }

    override fun onResume() {
        super.onResume()
        //効果音を出すためのクラス：Soundpoolの準備
        soundPool = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            SoundPool.Builder().setAudioAttributes(
                AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
                .setMaxStreams(1)
                .build()
        } else {
            SoundPool(1, AudioManager.STREAM_MUSIC, 0)
        }
        soundId = soundPool.load(this, R.raw.autodoor_open1, 1)
        soundId2 = soundPool.load(this, R.raw.bath_out1, 1)
        soundId3 = soundPool.load(this, R.raw.money_drop1, 1)
        soundId4 = soundPool.load(this, R.raw.money_drop1, 1)
        soundId5 = soundPool.load(this, R.raw.walk_school1, 1)
        soundId6 = soundPool.load(this, R.raw.water_throw_stone1, 1)

    }

    override fun onPause() {
        super.onPause()
        soundPool.release()
    }
}
