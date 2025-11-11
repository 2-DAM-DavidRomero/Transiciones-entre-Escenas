package com.example.transicinentreescenas

import android.content.Intent
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Escena2 : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.escena2)
        val layout = findViewById<LinearLayout>(R.id.linearLayout)
        val animation = AnimationUtils.loadAnimation(this, R.anim.slide_up)
        layout.startAnimation(animation)


        val boton = findViewById<FloatingActionButton>(R.id.fab)
        boton.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.slide_exit_down)
            layout.startAnimation(animation)

            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(p0: Animation?) {}

                override fun onAnimationEnd(p0: Animation?) {
                    finishAfterTransition()  // vuelve con la animación compartida inversa
                }

                override fun onAnimationRepeat(p0: Animation?) {}
            })
        }


    }
}