package com.slotmachine.ImageScrolling

import android.animation.Animator
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.core.view.isGone
import com.slotmachine.MainActivity
import com.slotmachine.R
import kotlinx.android.synthetic.main.image_scrolling.view.*


class ImageScrolling : FrameLayout {

    internal lateinit var eventEnd: Event

    internal var last_result = 0
    internal var oldValue = 0


    companion object {
        private val ANIMATION_DURATION = 150   }

    val value: Int
        get() = Integer.parseInt(nextImage.tag.toString())

    fun setEventEnd(eventEnd: Event) {
        this.eventEnd = eventEnd

    }

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    private fun init(context: Context) {
        LayoutInflater.from(context).inflate(R.layout.image_scrolling, this)

        nextImage.translationY = height.toFloat()

    }

    fun setValueRandom(image: Int, num_rotate: Int) {
        currentImage.animate()
            .translationY((-height).toFloat())
            .setDuration(ANIMATION_DURATION.toLong()).start()

        nextImage.translationY = nextImage.height.toFloat()

        nextImage.animate().translationY(0f).setDuration(ANIMATION_DURATION.toLong())
            .setListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(p0: Animator?) {

                }

                override fun onAnimationEnd(p0: Animator?) {
                    setImage(currentImage, oldValue % 9)
                    currentImage.translationY = 0f
                    if (oldValue != num_rotate)
                    {
                        setValueRandom(image, num_rotate)
                        oldValue++



                    } else {
                        last_result = 0
                        oldValue = 0
                        setImage(nextImage, image)
                        eventEnd.eventEnd(image % 9, num_rotate)
                        currentImage.setImageResource(androidx.constraintlayout.widget.R.drawable.
                        abc_cab_background_internal_bg)
                    }
                }


                override fun onAnimationCancel(p0: Animator?) {
                }

                override fun onAnimationStart(p0: Animator?) {
                }

            }).start()
    }

    private fun setImage(img: ImageView?, value: Int) {

        if (value == obj.cupe)
            img!!.setImageResource(R.drawable.cupe)
        else if (value == obj.dig)
            img!!.setImageResource(R.drawable.dig)
        else if (value == obj.fignya)
            img!!.setImageResource(R.drawable.fignya)
        else if (value == obj.hook)
            img!!.setImageResource(R.drawable.hook)
        else if (value == obj.juk)
            img!!.setImageResource(R.drawable.juk)
        else if (value == obj.k)
            img!!.setImageResource(R.drawable.k)
        else if (value == obj.man)
            img!!.setImageResource(R.drawable.man)
        else if (value == obj.o)
            img!!.setImageResource(R.drawable.o)
        else if (value == obj.piramide)
            img!!.setImageResource(R.drawable.piramida)
        else if (value == obj.snake)
            img!!.setImageResource(R.drawable.snake)
        img!!.tag = value
        last_result = value

    }
}