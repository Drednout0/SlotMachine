package com.slotmachine

import android.content.Context
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.slotmachine.ImageScrolling.Event


import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.image_scrolling.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(), Event {
    private var countDown = 0
    var cash = 1000

    var get = 1



    var pref : SharedPreferences? = null
    override fun eventEnd(result: Int, count: Int) {
        if (countDown < 20)
            countDown ++


        else {






            countDown = 0

            if (image.value == image2.value && image2.value == image3.value && image3.value == image4.value &&
                image4.value == image5.value
            ) {
                cash += get * 10

            } else if (image.value == image2.value && image2.value == image3.value && image3.value == image4.value) {

                cash += get * 6

            } else if (image.value == image2.value && image2.value == image3.value ||
                image3.value == image4.value && image4.value == image5.value
            ) {
                cash += get * 4
            } else if (image.value == image2.value || image2.value == image3.value || image3.value == image4.value
                || image4.value == image5.value
            ) {
                cash += get * 2
            }



            if (image6.value == image7.value && image7.value == image8.value && image8.value == image9.value &&
                image9.value == image10.value
            ) {
                cash += get * 10

            } else if (image6.value == image7.value && image7.value == image8.value && image8.value == image9.value) {

                cash += get * 6

            } else if (image6.value == image7.value && image7.value == image8.value ||
                image8.value == image9.value && image9.value == image10.value
            ) {
                cash += get * 4
            } else if (image6.value == image7.value || image7.value == image8.value || image8.value == image9.value
                || image9.value == image10.value
            ) {
                cash += get * 2
            }

            if (image11.value == image12.value && image12.value == image13.value && image13.value == image14.value &&
                image14.value == image15.value
            ) {
                cash += get * 10
            } else if (image11.value == image12.value && image12.value == image13.value && image13.value == image14.value) {

                cash += get * 6

            } else if (image11.value == image12.value && image12.value == image13.value ||
                image13.value == image14.value && image14.value == image15.value
            ) {
                cash += get * 4
            } else if (image11.value == image12.value || image12.value == image13.value || image13.value == image14.value
                || image14.value == image15.value
            ) {
                cash += get * 2
            }

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       getbar.text = get.toString()
        gold.text = cash.toString()
        pref = getSharedPreferences("TABLE", Context.MODE_PRIVATE)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        cash = pref?.getInt("cash", 0)!!
        gold.text = cash.toString()

        image.setEventEnd(this@MainActivity)
        image2.setEventEnd(this@MainActivity)
        image3.setEventEnd(this@MainActivity)
        image4.setEventEnd(this@MainActivity)
        image5.setEventEnd(this@MainActivity)
        image6.setEventEnd(this@MainActivity)
        image7.setEventEnd(this@MainActivity)
        image8.setEventEnd(this@MainActivity)
        image9.setEventEnd(this@MainActivity)
        image10.setEventEnd(this@MainActivity)
        image11.setEventEnd(this@MainActivity)
        image12.setEventEnd(this@MainActivity)
        image13.setEventEnd(this@MainActivity)
        image14.setEventEnd(this@MainActivity)
        image15.setEventEnd(this@MainActivity)
        plus.setOnClickListener{
            get ++
            getbar.text = get.toString()
        }
        minus.setOnClickListener{
            get--
            getbar.text = get.toString()
        }

        Start.setOnClickListener {
            if (cash >= 50) {

                image.setValueRandom(
                    Random.nextInt(10),
                    Random.nextInt(15-5+1)+5)

                image2.setValueRandom(
                    Random.nextInt(10),
                    Random.nextInt(15-5+1)+5)

                image3.setValueRandom(
                    Random.nextInt(10),
                    Random.nextInt(15-5+1)+5)


                image4.setValueRandom(
                    Random.nextInt(10),
                    Random.nextInt(15-5+1)+5)

                image5.setValueRandom(
                    Random.nextInt(10),
                    Random.nextInt(15-5+1)+5)

                image6.setValueRandom(
                    Random.nextInt(10),
                    Random.nextInt(15-5+1)+5)

                image7.setValueRandom(
                    Random.nextInt(10),
                    Random.nextInt(15-5+1)+5)

                image8.setValueRandom(
                    Random.nextInt(10),
                    Random.nextInt(15-5+1)+5)

                image9.setValueRandom(
                    Random.nextInt(10),
                    Random.nextInt(15-5+1)+5)

                image10.setValueRandom(
                    Random.nextInt(10),
                    Random.nextInt(15-5+1)+5)

                image11.setValueRandom(
                    Random.nextInt(10),
                    Random.nextInt(15-5+1)+5)

                image12.setValueRandom(
                    Random.nextInt(10),
                    Random.nextInt(15-5+1)+5)

                image13.setValueRandom(
                    Random.nextInt(10),
                    Random.nextInt(15-5+1)+5)

                image14.setValueRandom(
                    Random.nextInt(10),
                    Random.nextInt(15-5+1)+5)

                image15.setValueRandom(
                    Random.nextInt(10),
                    Random.nextInt(15-5+1)+5)


                cash -= get
                gold.text = cash.toString()
            } else {
                cash = 1000
                Toast.makeText(this, "Вам подарок в 1000 монет:)", Toast.LENGTH_SHORT).show()
                gold.text = cash.toString()
            }
        }




    }
    fun saveData(res: Int) {
        val editor = pref?.edit()
        editor?.putInt("cash", res)
        editor?.apply()
    }
    override fun onDestroy(){
        super.onDestroy()
        saveData(cash)
    }

}
