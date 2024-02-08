package com.example.aaa

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity


class Lab2() : ComponentActivity(){
    private var count:Int = 0
    private var countMultiplier:Int = 1
    private var nextCountMultiplier: Int = 10
    private var isAnvilImage: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickerButton = findViewById<ImageButton>(R.id.clickerImageButton)

        val countTV = findViewById<TextView>(R.id.countTextVew)
        val countMultiplierTV = findViewById<TextView>(R.id.countMultiplierTextView)
        val nextCountMultiplierTV = findViewById<TextView>(R.id.nextCountMultiplierTextView)
        val anvilImageView = findViewById<ImageView>(R.id.AnvilImageView)

        countTV.text = "Points: $count"
        countMultiplierTV.text = "Points Multiplier: x$countMultiplier"
        nextCountMultiplierTV.text = "Next Points Goal: $nextCountMultiplier"

        clickerButton.setOnClickListener {
            count += countMultiplier
            countTV.text = "Points: $count"
            if (count >= nextCountMultiplier) {
                nextCountMultiplier *= 2
                countMultiplier++
                countMultiplierTV.text = "Points Multiplier: x$countMultiplier"
                nextCountMultiplierTV.text = "Next Points Goal: $nextCountMultiplier"
            }

            if (isAnvilImage) {
                anvilImageView.setImageResource(R.drawable.frame_09_delay_0_03s)
            }
            else{
                anvilImageView.setImageResource(R.drawable.frame_03_delay_0_03s)
            }
            isAnvilImage = !isAnvilImage
        }
    }
}
