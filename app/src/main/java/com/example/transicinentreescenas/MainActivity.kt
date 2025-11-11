package com.example.transicinentreescenas

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val text = findViewById<TextView>(R.id.textPrincipal)
        val appearAnim = AnimationUtils.loadAnimation(this, R.anim.slide_up)
        text.startAnimation(appearAnim)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var img = findViewById<ImageView>(R.id.imageView)


        img.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.slide_down)
            text.startAnimation(animation)
            val intent = Intent(this, Escena2::class.java)
            intent.putExtra("image_resource", R.drawable.islas) // o la imagen real

            val options = ActivityOptions.makeSceneTransitionAnimation(
                this,
                img,
                "shared_image"
            )
            startActivity(intent, options.toBundle())
        }

    }
}