package com.example.videolivewallpaper

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.app.WallpaperManager
import android.content.ComponentName
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(40, 60, 40, 40)

        val title = TextView(this)
        title.text = "Video Live Wallpaper"
        title.textSize = 28f

        val button = Button(this)
        button.text = "Set Live Wallpaper"

        layout.addView(title)
        layout.addView(button)

        button.setOnClickListener {
            try {
                val wallpaperManager = WallpaperManager.getInstance(this)

                val intent = Intent(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER)
                intent.putExtra(
                    WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
                    ComponentName(
                        this,
                        VideoWallpaperService::class.java
                    )
                )

                startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        setContentView(layout)
    }
}
