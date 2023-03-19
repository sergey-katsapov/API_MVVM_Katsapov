package com.example.filmsmvvm.presentation.service

import android.app.*
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import com.example.filmsmvvm.Constants
import com.example.filmsmvvm.Constants.CHANNEL_ID
import com.example.filmsmvvm.Constants.CHANNEL_NAME
import com.example.filmsmvvm.Constants.MUSIC_NOTIFICATION_ID
import com.example.filmsmvvm.Constants.VOLUME_MAX_VALUE
import com.example.filmsmvvm.R
import com.example.filmsmvvm.presentation.activity.MainActivity

class MusicService : Service() {

    private lateinit var musicPlayer: MediaPlayer

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        initMusic()
        createNotificationChannel()
    }

    private fun initMusic() {
        musicPlayer = MediaPlayer.create(this, R.raw.music).also {
            it.apply {
                isLooping = true
                setVolume(VOLUME_MAX_VALUE, VOLUME_MAX_VALUE)
            }
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        showNotification()
        musicPlayer.apply {
            if (isPlaying) {
                stop()
            } else {
                start()
            }
        }
        return START_STICKY
    }

    private fun createNotificationChannel() {
        val serviceChannel = NotificationChannel(
            CHANNEL_ID,
            CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT
        )

        val manager = getSystemService(
            NotificationManager::class.java
        )

        manager.createNotificationChannel(serviceChannel)
    }

    private fun showNotification() {
        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            notificationIntent,
            0
        )
        val notification = Notification
            .Builder(this, CHANNEL_ID)
            .setContentText(Constants.PLAYER)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(MUSIC_NOTIFICATION_ID, notification)
    }

    override fun onDestroy() {
        musicPlayer.stop()
        super.onDestroy()
    }
}