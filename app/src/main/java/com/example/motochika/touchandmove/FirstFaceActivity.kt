package com.example.motochika.touchandmove

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity(){

    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar

        actionBar!!.hide()



        var listener = View.OnTouchListener(function = {view, motionEvent ->


            //ドラッグして画像を動かす
            if (motionEvent.action == MotionEvent.ACTION_MOVE) {



                view.x = motionEvent.rawX - view.width/2
                view.y = motionEvent.rawY - view.height/2



                Log.d("MainActivity","touched")

            }
            //タップして画像を回転
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {

                i+=10

                view.rotation =i.toFloat()

                Log.d("MainActivity","rotated")


            }


            true

        })

        window.decorView.viewTreeObserver.addOnGlobalLayoutListener {

            val rightEyeX = rightEye_image.x
            val rightEyeY = rightEye_image.y
            val leftEyeX = leftEye_image.x
            val leftEyeY = leftEye_image.y
            val noseX = nose_image.x
            val noseY = nose_image.y
            val mouthX = mouth_image.x
            val mouthY = mouth_image.y


            changeFace_button.setOnClickListener {

                //画像を透明にする
                rightEye_image.alpha = 0.0.toFloat()
                leftEye_image.alpha = 0.0.toFloat()
                nose_image.alpha = 0.0.toFloat()
                mouth_image.alpha = 0.0.toFloat()


                rightEye_image.setOnTouchListener(listener)
                leftEye_image.setOnTouchListener(listener)
                nose_image.setOnTouchListener(listener)
                mouth_image.setOnTouchListener(listener)

            }

            open_button.setOnClickListener {

                //元の透明度に戻す
                rightEye_image.alpha = 1.0.toFloat()
                leftEye_image.alpha = 1.0.toFloat()
                nose_image.alpha = 1.0.toFloat()
                mouth_image.alpha = 1.0.toFloat()

                rightEye_image.setOnTouchListener(null)
                leftEye_image.setOnTouchListener(null)
                nose_image.setOnTouchListener(null)
                mouth_image.setOnTouchListener(null)

            }

            defo_button.setOnClickListener {

                //元の位置に戻す
                rightEye_image.x = rightEyeX
                rightEye_image.y = rightEyeY
                leftEye_image.x = leftEyeX
                leftEye_image.y = leftEyeY
                nose_image.x = noseX
                nose_image.y = noseY
                mouth_image.x = mouthX
                mouth_image.y = mouthY


            }

            back_button.setOnClickListener {

                //元の状態に戻す
                rightEye_image.x = rightEyeX
                rightEye_image.y = rightEyeY
                leftEye_image.x = leftEyeX
                leftEye_image.y = leftEyeY
                nose_image.x = noseX
                nose_image.y = noseY
                mouth_image.x = mouthX
                mouth_image.y = mouthY

                i = 0

                rightEye_image.rotation = 0.toFloat()
                leftEye_image.rotation = 0.toFloat()
                nose_image.rotation = 0.toFloat()
                mouth_image.rotation = 0.toFloat()


            }
        }

    }



}
