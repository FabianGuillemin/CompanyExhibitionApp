package ch.giime.fensterquiz

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_start_page_ttt.*


class StartPageTTT : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mView = inflater.inflate(R.layout.fragment_start_page_ttt,container,false)

        val animClockwise = AnimationUtils.loadAnimation(context, R.anim.clockwise)
        //val animMove = AnimationUtils.loadAnimation(context, R.anim.move)
        //val animFade = AnimationUtils.loadAnimation(context, R.anim.fade)
        //val animSlide = AnimationUtils.loadAnimation(context, R.anim.slide)
        val animZoom = AnimationUtils.loadAnimation(context, R.anim.zoom)
        val animZoom2 = AnimationUtils.loadAnimation(context, R.anim.zoom2)
        //val animBlink = AnimationUtils.loadAnimation(context,R.anim.blink)

        val buttonOnePlayer = mView.findViewById<Button>(R.id.buttonOnePlayer)
        buttonOnePlayer.setOnClickListener {
            buttonOnePlayer.startAnimation(animZoom2)
            this.fragmentManager!!.beginTransaction()
                .replace(R.id.fragmentPlace, SinglePlayerTTT())
                .addToBackStack(null)
                .commit()

        }
        val buttonTwoPlayer = mView.findViewById<Button>(R.id.buttonTwoPlayer)
        buttonTwoPlayer.setOnClickListener {
            buttonTwoPlayer.startAnimation(animZoom2)
            this.fragmentManager!!.beginTransaction()
                .replace(R.id.fragmentPlace, TwoPlayerTTT())
                .addToBackStack(null)
                .commit()
        }

        val textViewTTT = mView.findViewById<TextView>(R.id.textViewTTT)
            textViewTTT.startAnimation(animZoom)

        val imageViewLogo = mView.findViewById<ImageView>(R.id.imageViewLogo)
        imageViewLogo.startAnimation(animClockwise)
        imageViewLogo.setOnClickListener {
            imageViewLogo.startAnimation(animClockwise)
        }

        val HomeButton = mView.findViewById<Button>(R.id.homeButton)
        HomeButton.setOnClickListener {
            HomeButton.startAnimation(animZoom2)
            this.fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentPlace, StartPageFragment())
                ?.addToBackStack(null)
                ?.commit()
        }
    return mView
    }
}